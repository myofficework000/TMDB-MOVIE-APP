package com.example.tmdbmovieapp.model.remote

object Constant {
    const val BASE_URL = "https://api.themoviedb.org/3/"
    const val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/original/"
    const val AUTHORIZATION = "Authorization"
    const val TOKEN_MASTER = "a53a3bcb8e2f8efe6d2988a34d73e750"
    const val TOKEN_JOSH = "441f9a2f476e2d801a859a9955fe6188"
    const val TOKEN_ALEX = "a51ff8a6730be4f36331b0b345e9e775"
    const val RANDOM_API_KEY = "ed75ba81d3a8253393684108406b8e26"
    const val TOKEN_THOMAS = ""
    const val TOKEN_LUAN = ""
    const val END_POINT_LATEST_MOVIES = "movie/latest"
    const val END_POINT_POPULAR_MOVIES = "movie/popular"
    const val END_POINT_UPCOMING_MOVIES = "movie/upcoming"
    const val END_POINT_TOP_RATED_MOVIES = "movie/top_rated"
    const val END_POINT_MOVIE_DETAIL = "movie/{movie_id}"
    const val END_POINT_MOVIE_DETAIL_ARG_1 = "movie_id"
    const val END_POINT_SEARCH = "search/movie"
    const val TABLE_MOVIE = "movie"
    const val TABLE_MOVIE_DETAIL = "movieDetail"
    const val TABLE_MOVIE_GENRE = "movieGenre"
    const val TABLE_PRODUCTION_COMPANY = "productionCompany"
    const val TABLE_PRODUCTION_COUNTRY = "productionCountry"
    const val TABLE_SPOKEN_LANGUAGE = "spokenLanguage"

    // for movie detail
    //https://api.themoviedb.org/3/movie/677179?append_to_response=credits&api_key=ed75ba81d3a8253393684108406b8e26

    // for now playing movie in threater
    // https://api.themoviedb.org/3/movie/now_playing?api_key=ed75ba81d3a8253393684108406b8e26&page=12
}