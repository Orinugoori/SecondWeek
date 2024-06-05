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
}
