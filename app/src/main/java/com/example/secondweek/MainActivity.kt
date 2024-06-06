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

        val buttonList = listOf(
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
            binding.ibtnDot,
            binding.ibtnPlus,
            binding.ibtnMinus,
            binding.ibtnMultiple,
            binding.ibtnDivide,
            binding.ibtnMod
        )

        for (button in buttonList) {
            button.setOnClickListener {
                addCurrentInput(button.contentDescription.toString())

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

        var result = ""

        for (i in operators.indices) {
            result = when(operators[i]){
                "+" -> calculator.add(numbers)
                "-" -> calculator.subtract(numbers)
                "*" -> calculator.multiply(numbers)
                "/" -> calculator.divide(numbers)
                "%" -> calculator.mod(numbers)
                else -> {
                    displayText.text = "Error"
                    return
                }
            }
        }
            displayText.text = result
            currentInput = result
        }



    }







