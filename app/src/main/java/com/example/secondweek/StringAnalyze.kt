package com.example.secondweek

class StringAnalyze {

    fun filterNumbers(currentInput: String): List<Number> {
        return currentInput.split("+","-","*","/")
            .mapNotNull { it.toDoubleOrNull() ?: it.toIntOrNull() }
    }


    fun filterOperators(currentInput: String): List<String> {
        return currentInput.split(" ")
            .filter{it.toDoubleOrNull()==null && it.toIntOrNull() == null }
    }



}

