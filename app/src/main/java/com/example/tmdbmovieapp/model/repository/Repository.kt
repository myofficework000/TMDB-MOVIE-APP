package com.example.tmdbmovieapp.model.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tmdbmovieapp.model.local.AppDatabase
import com.example.tmdbmovieapp.model.remote.data.MovieResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class Repository @Inject constructor(
    private val appDatabase: AppDatabase,
    private val localRepository: LocalRepository,
    private val remoteRepository: RemoteRepository
) : IRepository {
    private val _latestMovie = MutableLiveData<MovieResponse>()
    val latestMovie: LiveData<MovieResponse> get() = _latestMovie
    val movieDetail = localRepository.getMovieDetailById(-1)
    val upComingMovie = localRepository.getUpComingMovies()
    val topRatedMovie = localRepository.getTopRatedMovies()
    val popularMovieData = localRepository.getPopularMovies()
    val searchedMovies = localRepository.getSearchMovies()
    private val compositeDisposable = CompositeDisposable()

    override fun getMovieDetail(movieId: Int) {
        val disposable = remoteRepository.getMovieDetail(movieId)
            .observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe({ res ->
                localRepository.saveMovieDetail(
                    listOf(res.toLocal(appDatabase.getMovieDao()))
                )
            }, {
                Log.i("error", it.message.toString())
            })

        compositeDisposable.add(disposable)
    }

    override fun getLatestMovie() {

        val disposable = remoteRepository.getLatestMovie()
            .observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe({ res ->
                _latestMovie.postValue(res)
            }, {
                Log.i("error", it.message.toString())
            })

        compositeDisposable.add(disposable)
    }

    override val isProcessing = MutableLiveData<Boolean>()

    //override fun getUpComingMovie() = remoteRepository.loadUpcomingMovies()
    override fun getUpComingMovie() {
        val disposable = remoteRepository.loadUpcomingMovies()
            .observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe({ res ->
                localRepository.saveUpComingMovies(
                    (res.results.map { result ->
                        result.toLocal(isUpcoming = true)
                    })
                )
            }, {
                Log.i("error", it.message.toString())
            }
            )

        compositeDisposable.add(disposable)
    }


    override fun getTopRatedMovie() {
        val disposable = remoteRepository.loadTopRatedMovies()
            .observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe({ res ->
                localRepository.saveTopRatedMovies(
                    (res.results.map { result ->
                        result.toLocal(isTopRated = true)
                    })
                )
            }, {
                Log.i("error", it.message.toString())
            }
            )

        compositeDisposable.add(disposable)
    }

    override fun getPopularMovie() {
        val disposable = remoteRepository.loadPopularMovies()
            .observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe({ res ->
                localRepository.savePopularMovies(
                    (res.results.map { result ->
                        result.toLocal(isPopular = true)
                    })
                )
            }, {
                Log.i("error", it.message.toString())
            }
            )

        compositeDisposable.add(disposable)
    }

    override fun searchMovie(movieName: String) {
        val disposable = remoteRepository.searchMovie(movieName)
            .observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe({ res ->
                localRepository.saveAsSearchMovies(
                    (res.results.map { result ->
                        result.toLocal(isSearch = true)
                    })
                )
            }, {
                Log.i("error", it.message.toString())
            }
            )

        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        compositeDisposable.dispose()
    }
}