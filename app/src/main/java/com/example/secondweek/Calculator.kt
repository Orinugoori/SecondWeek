package com.example.secondweek

class Calculator {

    fun add(numbers: List<Number>): String {
        return if (numbers.isEmpty()) {
            "0"
        } else {
            val sum = numbers.sumOf { it.toDouble() }
            if (sum % 1.0 == 0.0) {
                sum.toInt().toString()
            } else {
                sum.toString()
            }
        }
    }

    fun subtract(numbers: List<Number>): String {

        var calculateNumber = numbers[0].toDouble()

        for (i in 1 until numbers.size) {
            calculateNumber -= numbers[i].toDouble()
        }

        return if (calculateNumber % 1.0 == 0.0) {
            calculateNumber.toInt().toString()
        } else {
            calculateNumber.toString()
        }

    }


    fun multiply(numbers: List<Number>): String {
        var calculateNumber = numbers[0].toDouble()
        for (i in 1 until numbers.size) {
            calculateNumber *= numbers[i].toDouble()
        }
        return if (calculateNumber % 1.0 == 0.0) {
            calculateNumber.toInt().toString()
        } else {
            calculateNumber.toString()
        }
    }

    fun divide(numbers: List<Number>): String {
        var quotient = numbers[0].toDouble()

        for (i in 1 until numbers.size) {
            quotient /= numbers[i].toDouble()
        }

        return if (quotient % 1.0 == 0.0) {
            quotient.toInt().toString()
        } else {
            quotient.toString()
        }
    }


    fun mod(numbers: List<Number>): String {
        var calculateNumber = numbers[0].toDouble()
        for (i in 1 until numbers.size) {
            calculateNumber %= numbers[i].toDouble()
        }
        return if (calculateNumber % 1.0 == 0.0) {
            calculateNumber.toInt().toString() // 정수로 반환
        } else {
            calculateNumber.toString() // 실수로 반환
        }
    }


}
