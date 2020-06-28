package com.example.mapstruct.repository

import com.example.mapstruct.data.DataSource
import com.example.mapstruct.model.Author
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class AuthorRepository {

    @Autowired
    lateinit var dataSource: DataSource

    fun findAll() : List<Author> {
        return dataSource.data
    }

    fun find(id: Int) : Author {
        return dataSource.data.first { it.id == id }
    }
}