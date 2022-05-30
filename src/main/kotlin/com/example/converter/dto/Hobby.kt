package com.example.converter.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName

@JsonRootName("Hobby")
class Hobby(
    @set:JsonProperty("genre")
    var genre: String = "",
    @set:JsonProperty("title")
    var title: String = ""
) {
    override fun toString(): String {
        return "genre: $genre; " +
                "title:  $title"
    }
}
