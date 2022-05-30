package com.example.converter.dto

import com.fasterxml.jackson.annotation.*
import com.fasterxml.jackson.databind.JsonNode

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName("Student")
@JsonPropertyOrder(value = ["name", "surname", "birthdate","age", "hobbies"])
class StudentDTO(
    @set:JsonProperty("name")
    var name: String = "",
    @set:JsonProperty("surname")
    var surname: String = "",
    @set:JsonProperty("age")
    var age: Double? = null,
    @set:JsonProperty("birthdate")
    var birthdate: String = "",
    @set:JsonAlias(value =  ["Hobbies", "Hobby"])
    var hobbies: JsonNode? = null

 ){
    override fun toString(): String {
        return "name $name \n" +
                "surname $surname \n" +
                "age $age \n" +
                "birthdate $birthdate \n" +
                "hobbies $hobbies \n "
    }
}
