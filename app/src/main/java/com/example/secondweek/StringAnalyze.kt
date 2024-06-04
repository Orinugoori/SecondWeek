package com.example.secondweek

class StringAnalyze {

    fun filterNumbers(currentInput: String): List<Double> {
        return currentInput.split("+","-","*","/")
            .mapNotNull { it.toDoubleOrNull() }
    }

    fun filterOperators(currentInput: String): List<String> {
        return currentInput.split(" ")
            .filter{it.toDoubleOrNull()==null}
    }



}

