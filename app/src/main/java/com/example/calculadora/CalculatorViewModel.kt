package com.example.calculadora

import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {

    private val model = Calculator

    fun getDisplayValue(): String {
        return model.expression
    }

    fun onClickSymbol(symbol: String): String {
        return model.insertSymbol(symbol)
    }

    fun onClickClear(): String {
        return model.clear()
    }

    fun onClickBackspace(): String {
        return model.deleteLastSymbol()
    }

    fun onClickGetLastOperation(onFinished: (String) -> Unit) {
        model.getLastOperation(onFinished)
    }

    fun onGetHistory(onFinished: (List<Operation>) -> Unit) {
        model.getHistory(onFinished)
    }

    fun onDeleteOperation(uuid: String, onSuccess: () -> Unit) {
        model.deleteOperation(uuid, onSuccess)
    }

    fun onClickEquals(onSaved: () -> Unit): String {
        model.performOperation(onSaved)
        val result = getDisplayValue().toDouble()
        return if(result % 1 == 0.0) result.toLong().toString() else result.toString()
    }

}