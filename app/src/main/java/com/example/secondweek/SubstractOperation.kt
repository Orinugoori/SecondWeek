package com.example.secondweek

class SubstractOperation : AbstractOperation() {

    override fun apply(numbers: List<Number>): Number {
        var calculateNumber = numbers[0].toDouble()
        for (i in 1 until numbers.size) {
            calculateNumber -= numbers[i].toDouble()
        }
        return analyzeResult(calculateNumber)
    }



}