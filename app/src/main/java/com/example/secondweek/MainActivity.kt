package com.example.secondweek

import android.media.MediaPlayer
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

    private val stringAnalyze : StringFilter = StringAnalyze()
    private lateinit var calculator : Calculator
    private lateinit var sound : Sound

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
        sound = Sound(this)



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
                sound.playSound()
                addCurrentInput(button.contentDescription.toString())

            }
        }

        for (button in operatorButtonList){
            button.setOnClickListener {
                sound.playSound()
                addOperatorInput(button.contentDescription.toString())
            }
        }

        binding.ibtnC.setOnClickListener {
            sound.playSound()
            clearAll()
        }

        binding.ibtnDel.setOnClickListener {
            sound.playSound()
            deleteLast()
        }

        binding.ibtnEqual.setOnClickListener {
            sound.playSound()
            calculateResult()
        }

        binding.ibtnParenthesis.setOnClickListener {
            sound.playSound()
            addParenthesisInput()
        }

        val operations = mapOf(
            '+' to AddOperation(),
            '-' to SubstractOperation(),
            '*' to MultiplyOperation(),
            '/' to DivideOperation(),
            '%' to ModOperation()
        )

        calculator = Calculator(operations)

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

    private fun addParenthesisInput(){
        val actualInput = if (isNextParenthesisOpen(currentInput)){
            "("
        }else {
            ")"
        }
        currentInput += actualInput
        displayText.text = currentInput
    }

    private fun isNextParenthesisOpen(currentInput: String) : Boolean {
        val openCount = currentInput.count { it == '(' }
        val closeCount = currentInput.count { it == ')' }
        return openCount <= closeCount
    }

    private fun calculateResult() {
        val numbers = stringAnalyze.filterNumbers(currentInput)
        val operators = stringAnalyze.filterOperators(currentInput)

            if (numbers.isEmpty() || operators.isEmpty()) {
            displayText.text = "there's no number"
            return
        }

        val calculateResult = calculator.calculate(numbers, operators.map { it[0] })

        val result = calculateResult.toString()

        displayText.text = result
        currentInput = result
        }






    override fun onDestroy(){
        super.onDestroy()
        sound.release()
    }

    }







