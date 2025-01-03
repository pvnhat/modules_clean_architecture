package com.example.domain.entities

data class MovieModel(
    val adult: Boolean? = null,
    val backdropPath: String? = null,
    val belongsToCollection: Any? = null,
    val budget: Int? = null,
    val genreIds: List<Int>? = null,
    val genres: List<GenreModel>? = null,
    val homepage: String? = null,
    val id: Int? = null,
    val imdbId: String? = null,
    val originCountry: List<String?>? = null,
    val originalLanguage: String? = null,
    val originalTitle: String? = null,
    val overview: String? = null,
    val popularity: Double? = null,
    val posterPath: String? = null,
    val releaseDate: String? = null,
    val revenue: Int? = null,
    val runtime: Int? = null,
    val status: String? = null,
    val tagline: String? = null,
    val title: String? = null,
    val video: Boolean? = null,
    val voteAverage: Double? = null,
    val voteCount: Int? = null
) : BaseModel() {
    fun getGenresStr(): String {
        return genres?.joinToString { it.name.orEmpty() }.orEmpty()
    }

    val lengthFormatted: String
        get() = MOVIE_LENGTH_FORMAT.format((runtime ?: 0) / 60, (runtime ?: 0) % 60)

    companion object {
        private const val MOVIE_LENGTH_FORMAT = "%dh %dm"
        private const val RATING_FORMAT = "%.1f/10 IMDB"
    }
}
