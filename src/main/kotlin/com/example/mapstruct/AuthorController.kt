package com.example.mapstruct

import com.example.mapstruct.dto.AuthorDto
import com.example.mapstruct.dto.SpecialAuthorDto
import com.example.mapstruct.dto.mapper.AuthorMapper
import com.example.mapstruct.dto.mapper.SpecialAuthorMapper
import com.example.mapstruct.repository.AuthorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/authors")
class AuthorController {
    @Autowired
    lateinit var authorRepository: AuthorRepository

    @Autowired
    lateinit var authorMapper: AuthorMapper

    @Autowired
    lateinit var specialAuthorMapper: SpecialAuthorMapper

    @GetMapping
    fun getAll() : ResponseEntity<List<AuthorDto>> {
        return ResponseEntity(
            authorMapper.authorsToAuthorDtos(authorRepository.findAll()),
            HttpStatus.OK)
    }

    @GetMapping("special/{id}")
    fun getSpecial(@PathVariable(value = "id") id: Int) : ResponseEntity<SpecialAuthorDto> {
        return ResponseEntity(
            specialAuthorMapper.authorToSpecialAuthorDto(authorRepository.find(id)),
            HttpStatus.OK)
    }

    @GetMapping("{id}")
    fun get(@PathVariable(value = "id") id: Int) : ResponseEntity<AuthorDto> {
        return ResponseEntity(
            authorMapper.authorToAuthorDto(authorRepository.find(id)),
            HttpStatus.OK)
    }

}