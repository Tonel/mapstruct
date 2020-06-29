package com.example.mapstruct.model

import java.util.*

class Author {
    var id: Int? = null

    var name: String? = null

    var surname: String? = null

    var birthDate: Date? = null

    val books: MutableList<Book> = ArrayList()

    // the default constructor is required by MapStruct to convert
    // a DTO object into a model domain object
    constructor()

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