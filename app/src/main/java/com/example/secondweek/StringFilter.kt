package com.example.secondweek

interface StringFilter {
    fun filterNumbers(currentInput : String): List<Number>
    fun filterOperators(currentInput: String):List<String>
}