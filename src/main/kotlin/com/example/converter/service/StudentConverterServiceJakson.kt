package com.example.converter.service

import com.example.converter.dto.Hobbies
import com.example.converter.dto.StudentDTO
import com.example.converter.mapper.HobbyMapper
import com.example.converter.mapper.StudentMapper
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import org.springframework.stereotype.Service


@Service("Jakson")
class StudentConverterServiceJakson : StudentService {
    private lateinit var xmlMapper: ObjectMapper

    init {
        xmlMapper = XmlMapper(JacksonXmlModule().apply {
            setDefaultUseWrapper(false)
        })
            .registerModules()
            .configure(
                DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false
            )
    }

    private var jsonMapper: ObjectMapper = ObjectMapper()

    override fun xmlToJson(xml: String): String {

        val studentXml = xmlMapper.readTree(xml)
        val student = xmlMapper.convertValue(studentXml, StudentDTO::class.java)
        val studentHobbies = xmlMapper.convertValue(studentXml.get("Hobbies"), Hobbies::class.java)

        val studentMapper = StudentMapper().apply {
            name = student.name
            surname = student.surname
            birthdate = student.birthdate
            age = student.age
            hobbies = studentHobbies.hobbies.map { HobbyMapper(it.genre, it.title) }

        }
        return jsonMapper.writeValueAsString(studentMapper)
    }


}
