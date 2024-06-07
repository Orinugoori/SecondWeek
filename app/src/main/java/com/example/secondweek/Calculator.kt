package com.example.secondweek

open class Calculator(private val operations : Map <Char, AbstractOperation>) {

    fun calculate(numbers: List<Number>, operators: List<Char>): Number {
        val result = numbers[0]
        for (i in operators.indices) {
            val nextNumber = numbers[i + 1]
            val currentNumbers = listOf(result, nextNumber)
            val operation =
                operations[operators[i]] ?: throw IllegalArgumentException("invalid operator")
            return operation.apply(currentNumbers)
        }
        return result
    }
}








