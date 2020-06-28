package com.example.mapstruct.model

import java.util.*

class Author {
    val id: Int

    val name: String

    val surname: String

    val birthDate: Date

    val books: MutableList<Book> = ArrayList()

    constructor(id : Int, name: String, surname: String, birthDate: Date) {
        this.id = id
        this.name = name
        this.surname = surname
        this.birthDate = birthDate
    }

    constructor(id: Int, name: String, surname: String, birthDate: Date, books: List<Book>) : this(id, name, surname, birthDate) {
        this.books.addAll(books)
    }
}