package com.example.tmdbmovieapp.model.remote

object Constant {
    const val BASE_URL = "https://api.themoviedb.org/3/movie/"
    const val POST_BASE = "https://image.tmdb.org/t/p/original"
    const val AUTHORIZATION = "Authorization"
    const val TOKEN_MASTER = "a53a3bcb8e2f8efe6d2988a34d73e750"
    const val TOKEN_JOSH = "441f9a2f476e2d801a859a9955fe6188"
    const val TOKEN_ALEX = "a51ff8a6730be4f36331b0b345e9e775"
    const val TOKEN_THOMAS = "47676b011f955d8193eec95be0ccd908"
    const val TOKEN_LUAN = ""
    const val END_POINT_LATEST_MOVIES = "latest" // Josh
    const val END_POINT_POPULAR_MOVIES = "" // LUAN
    const val END_POINT_UPCOMING_MOVIES = "upcoming" // ALex
    const val END_POINT_TOP_RATED_MOVIES = "top_rated" // Thomas
    const val END_POINT_MOVIE_DETAIL = "movie/{movie_id}"
    const val END_POINT_MOVIE_DETAIL_ARG_1 = "movie_id"

    const val TABLE_MOVIE = "movie"
    const val TABLE_MOVIE_DETAIL = "movieDetail"
    const val TABLE_MOVIE_GENRE = "movieGenre"
    const val TABLE_PRODUCTION_COMPANY = "productionCompany"
    const val TABLE_PRODUCTION_COUNTRY = "productionCountry"
    const val TABLE_SPOKEN_LANGUAGE = "spokenLanguage"
    const val TABLE_TRENDING_MOVIE = "trendingMovie"
}