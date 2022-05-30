package com.example.converter.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName

@JsonRootName("Hobbies")
class Hobbies(
    @set:JsonProperty("Hobby")
    var hobbies: List<Hobby> = ArrayList()
)
{
    override fun toString(): String =
        hobbies.toString()

}