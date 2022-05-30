package com.example.converter.mapper

data class StudentMapper(
    var name: String = "",
    var surname: String = "",
    var age: Double? = null,
    var birthdate: String = "",
    var hobbies: List<HobbyMapper> = emptyList()
)