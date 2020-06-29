package com.example.mapstruct.model

import java.util.*

class Book {
    var id: Int? = null

    var title: String? = null

    var releaseDate: Date? = null

    // the default constructor is required by MapStruct to convert
    // a DTO object into a model domain object
    constructor()

    constructor(id : Int, title : String, releaseDate: Date) {
        this.id = id
        this.title = title
        this.releaseDate = releaseDate
    }
}