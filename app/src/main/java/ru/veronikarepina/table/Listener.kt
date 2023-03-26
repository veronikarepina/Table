package ru.veronikarepina.table

interface Listener {
    fun setValues(value: String, position: Int, field: Int)
}