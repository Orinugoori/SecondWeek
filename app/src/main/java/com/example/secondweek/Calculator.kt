package com.example.secondweek

class Calculator {

    fun add(numbers: List<Number>): Number{
        return if (numbers.isEmpty()) {
            0
        } else {
            val sum = numbers.sumOf { it.toDouble() }

            if (sum % 1.0 == 0.0) {
                sum.toInt()
            } else {
                sum
            }
        }
    }

    fun subtract(numbers: List<Number>): Number {

        var calculateNumber = numbers[0].toDouble()

        for (i in 1 until numbers.size) {
            calculateNumber -= numbers[i].toDouble()
        }

        return if (calculateNumber % 1.0 == 0.0) {
            calculateNumber.toInt()
        } else {
            calculateNumber
        }

    }


    fun multiply(numbers: List<Number>): Number {
        var calculateNumber = numbers[0].toDouble()
        for (i in 1 until numbers.size) {
            calculateNumber *= numbers[i].toDouble()
        }
        return if (calculateNumber % 1.0 == 0.0) {
            calculateNumber.toInt()
        } else {
            calculateNumber
        }
    }

    fun divide(numbers: List<Number>): Number {
        var quotient = numbers[0].toDouble()

        for (i in 1 until numbers.size) {
            quotient /= numbers[i].toDouble()
        }

        return if (quotient % 1.0 == 0.0) {
            quotient.toInt()
        } else {
            quotient
        }
    }


    fun mod(numbers: List<Number>): Number {
        var calculateNumber = numbers[0].toDouble()
        for (i in 1 until numbers.size) {
            calculateNumber %= numbers[i].toDouble()
        }
        return if (calculateNumber % 1.0 == 0.0) {
            calculateNumber.toInt()
        } else {
            calculateNumber
        }
    }


}
