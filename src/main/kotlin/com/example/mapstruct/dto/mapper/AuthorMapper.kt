package com.example.mapstruct.dto.mapper

import com.example.mapstruct.dto.AuthorDto
import com.example.mapstruct.model.Author
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface AuthorMapper {

    fun authorToAuthorDto(
        author : Author
    ) : AuthorDto

    fun authorsToAuthorDtos(
        authors : List<Author>
    ) : List<AuthorDto>

}