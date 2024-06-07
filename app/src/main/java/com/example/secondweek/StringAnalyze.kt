package com.example.secondweek

class StringAnalyze : StringFilter{

    override fun filterNumbers(currentInput: String): List<Number> {
        return currentInput.split(Regex("[+\\-*/%]"))
            .mapNotNull { it.toDoubleOrNull() ?: it.toIntOrNull() }
    }


    override fun filterOperators(currentInput: String): List<String> {
        return currentInput.filter { it in "+-*/%" }.map { it.toString() }
    }



}

