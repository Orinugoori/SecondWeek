package com.example.secondweek

abstract class AbstractOperation {
    protected fun analyzeResult(result : Number) :Number {
        return if (result.toDouble() % 1.0 == 0.0 ) result.toInt() else result
    }

    abstract fun apply (numbers : List<Number>) :Number

}


