package com.example.data.mapper

import com.example.data.model.MovieData
import com.example.domain.entities.MovieModel
import javax.inject.Inject

class MovieMapper @Inject constructor(
    private val genreMapper: GenreMapper,
) : DataMapper<MovieData, MovieModel>() {
    override fun map(data: MovieData): MovieModel {
        return MovieModel(
            adult = data.adult,
            backdropPath = data.backdropPath,
            belongsToCollection = data.belongsToCollection,
            budget = data.budget,
            genreIds = data.genreIds,
            genres = genreMapper.nullableCollectionMap(data.genres),
            homepage = data.homepage,
            id = data.id,
            imdbId = data.imdbId,
            originCountry = data.originCountry,
            originalLanguage = data.originalLanguage,
            originalTitle = data.originalTitle,
            overview = data.overview,
            popularity = data.popularity,
            posterPath = data.posterPath,
            releaseDate = data.releaseDate,
            revenue = data.revenue,
            runtime = data.runtime,
            status = data.status,
            tagline = data.tagline,
            title = data.title,
            video = data.video,
            voteAverage = data.voteAverage,
            voteCount = data.voteCount
        )
    }
}
