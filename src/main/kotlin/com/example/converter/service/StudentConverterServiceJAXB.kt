package com.example.converter.service

import com.example.converter.dto.StudentDTO
import org.springframework.stereotype.Service
import java.io.StringReader
import javax.xml.bind.JAXBContext

@Service("JAXB")
class StudentConverterServiceJAXB: StudentService {
    override fun xmlToJson(xml: String): String {
        val reader = StringReader(xml)
        val context = JAXBContext.newInstance(StudentDTO::class.java)
        println(context)
        val unmarshaller = context.createUnmarshaller()
        val student = unmarshaller.unmarshal(reader)
        println(student)
        return ""
    }


}