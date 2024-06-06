package com.example.secondweek

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.secondweek.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var displayText: TextView
    private var currentInput = ""
    private val stringAnalyze = StringAnalyze()
    private val calculator = Calculator()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        displayText = binding.tvDisplay

        val numberButtonList = listOf(
            binding.ibtnSeven,
            binding.ibtnEight,
            binding.ibtnNine,
            binding.ibtnFour,
            binding.ibtnFive,
            binding.ibtnSix,
            binding.ibtnOne,
            binding.ibtnTwo,
            binding.ibtnThree,
            binding.ibtnZero,
        )

        val operatorButtonList = listOf(
            binding.ibtnDot,
            binding.ibtnPlus,
            binding.ibtnMinus,
            binding.ibtnMultiple,
            binding.ibtnDivide,
            binding.ibtnMod
        )

        for (button in numberButtonList) {
            button.setOnClickListener {
                addCurrentInput(button.contentDescription.toString())

            }
        }

        for (button in operatorButtonList){
            button.setOnClickListener {
                addOperatorInput(button.contentDescription.toString())
            }
        }

        binding.ibtnC.setOnClickListener {
            clearAll()
        }

        binding.ibtnDel.setOnClickListener {
            deleteLast()
        }

        binding.ibtnEqual.setOnClickListener {
            calculateResult()
        }

    }

    private fun addCurrentInput(letter: String) {
        currentInput += "$letter"
        displayText.text = currentInput
    }

    private fun addOperatorInput(unduplicableLetter: String){
        if( currentInput.isNotEmpty() && "+-*/%.".contains(currentInput.last())){
            currentInput = currentInput.dropLast(1) + unduplicableLetter
        }else{
            currentInput += unduplicableLetter
        }
        displayText.text = currentInput
    }

    private fun clearAll() {
        currentInput = ""
        displayText.text = "Hello"
    }

    private fun deleteLast() {
        if (currentInput.isNotEmpty()) {
            currentInput = currentInput.dropLast(1)
            displayText.text = if (currentInput.isNotEmpty()) currentInput else "Hello"
        }
    }

    private fun calculateResult() {
        val numbers = stringAnalyze.filterNumbers(currentInput)
        val operators = stringAnalyze.filterOperators(currentInput)

        if (numbers.isEmpty() || operators.isEmpty()){
            displayText.text = "there's no number"
            return
        }

        var calculateResult: Number = numbers[0]

        for (i in operators.indices) {
            val nextNumber = numbers[i+1]
            val currentNumbers = listOf(calculateResult, nextNumber)

            calculateResult = calculator.calculate(currentNumbers, operators[i])

        }

        val result = calculateResult.toString().removeSurrounding("[","]")

            displayText.text = result
            currentInput = result
        }

    }







