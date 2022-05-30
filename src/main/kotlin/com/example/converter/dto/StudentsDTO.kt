package com.example.converter.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName

@JsonRootName("Students")
class StudentsDTO(
    @set:JsonProperty("Student")
    var students: List<StudentDTO> = ArrayList()
)