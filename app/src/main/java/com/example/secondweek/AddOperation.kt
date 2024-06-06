package com.example.secondweek

class AddOperation : AbstractOperation() {

     override fun apply(numbers: List<Number>): Number{
         val calculatorNumber = numbers.sumOf { it.toDouble() }
         return analyzeResult(calculatorNumber)
     }

}