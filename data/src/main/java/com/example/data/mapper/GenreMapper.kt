package com.example.data.mapper

import com.example.data.model.GenreData
import com.example.domain.entities.GenreModel
import javax.inject.Inject

class GenreMapper @Inject constructor(
) : DataMapper<GenreData, GenreModel>() {
    override fun map(data: GenreData): GenreModel {
        return GenreModel(
            id = data.id, name = data.name
        )
    }
}
