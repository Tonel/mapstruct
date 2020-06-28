package com.example.mapstruct.dto.mapper

import com.example.mapstruct.dto.BookDto
import com.example.mapstruct.dto.SpecialAuthorDto
import com.example.mapstruct.model.Author
import com.example.mapstruct.model.Book
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
abstract class SpecialAuthorMapper {

    // author's book property is accessed through java setter
    @Mappings(
        Mapping(target="firstBook", expression = "java(booksToFirstBook(author.getBooks()))")
    )
    abstract fun authorToSpecialAuthorDto(
        author : Author
    ) : SpecialAuthorDto

    // required in order to convert Book into BookDto
    // in booksToFirstBook
    abstract fun bookToBookDto(
        book : Book
    ) : BookDto

    // converting books into the first released book
    fun booksToFirstBook(books : List<Book>) : BookDto {
        return bookToBookDto(
            books
                .sortedWith(Comparator { e1: Book, e2: Book -> e1.releaseDate.compareTo(e2.releaseDate) })
                .first()
        )
    }


}