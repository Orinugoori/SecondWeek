package com.example.secondweek

class StringAnalyze {

    fun filterNumbers(currentInput: String): List<Number> {
        return currentInput.split(Regex("[+\\-*/%]"))
            .mapNotNull { it.toDoubleOrNull() ?: it.toIntOrNull() }
    }


    fun filterOperators(currentInput: String): List<String> {
        return currentInput.filter { it in "+-*/%" }.map { it.toString() }
    }



}

