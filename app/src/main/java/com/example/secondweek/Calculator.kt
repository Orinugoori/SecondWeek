package com.example.secondweek

open class Calculator {

    private val operations = mapOf<String, AbstractOperation>(
        "+" to AddOperation(),
        "-" to SubstractOperation(),
        "*" to MultiplyOperation(),
        "/" to DivideOperation(),
        "%" to ModOperation()
    )
    fun calculate(numbers: List<Number>, operator : String): Number {
        val operation = operations[operator] ?: throw IllegalArgumentException ("invalid operator")
        return operation.apply(numbers)
    }

}








