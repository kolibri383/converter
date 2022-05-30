package com.example.converter.controller

import com.example.converter.dto.StudentDTO
import com.example.converter.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest


@RestController
@RequestMapping("/","")
class XmlController {
    @Autowired
    @Qualifier("Jakson")
    lateinit var studentService: StudentService

    @PostMapping(consumes = [MediaType.APPLICATION_XML_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getJSON(@RequestBody xml: List<StudentDTO>, request: HttpServletRequest): ResponseEntity<List<StudentDTO>> {
        return ResponseEntity<List<StudentDTO>>(xml, HttpStatus.OK)
    }


    @PostMapping("/students", consumes = [MediaType.APPLICATION_XML_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getStudents(@RequestBody xml: String): ResponseEntity<String>{
        return ResponseEntity<String>(studentService.xmlToJson(xml), HttpStatus.OK)
    }



}