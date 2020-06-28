package com.example.mapstruct.data

import com.example.mapstruct.model.Author
import com.example.mapstruct.model.Book
import org.springframework.stereotype.Component
import java.util.*


@Component
class DataSource {

    val data : MutableList<Author> = ArrayList()

    init {
        val book1 = Book(1, "Book 1", GregorianCalendar(2018, 10, 24).time)
        val book2 = Book(2, "Book 2", GregorianCalendar(2010, 7, 12).time)
        val book3 = Book(3, "Book 3", GregorianCalendar(2011, 3, 8).time)
        val author1 = Author(
                1,
                "John",
                "Smith",
                GregorianCalendar(1967, 1, 2).time,
                listOf(book1, book2, book3)
        )
        val book4 = Book(4, "Book 4", GregorianCalendar(2012, 12, 9).time)
        val book5 = Book(5, "Book 5", GregorianCalendar(2017, 9, 22).time)
        val author2 = Author(
                2,
                "Emma",
                "Potter",
                GregorianCalendar(1967, 1, 2).time,
                listOf(book5, book4)
        )

        data.addAll(listOf(author1, author2))
    }
}