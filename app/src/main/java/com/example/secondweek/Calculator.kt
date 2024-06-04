package com.example.secondweek

class Calculator {

    fun add(numbers : List<Double>): String{
        return if (numbers.isEmpty()){
            "0"
        } else{
            val sum = numbers.sum()
            sum.toString()
        }
    }

}
