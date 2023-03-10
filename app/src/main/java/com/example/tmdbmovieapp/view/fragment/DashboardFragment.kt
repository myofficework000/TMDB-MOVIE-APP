package com.example.tmdbmovieapp.view.fragment

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuItemCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdbmovieapp.R
import com.example.tmdbmovieapp.databinding.FragmentDashboardBinding
import com.example.tmdbmovieapp.view.adapters.UpcomingRVAdapter
import com.example.tmdbmovieapp.viewmodel.MovieListViewModel
import com.example.tmdbmovieapp.viewmodel.createFactory
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import java.util.concurrent.TimeUnit

class DashboardFragment : Fragment(), MenuItem.OnActionExpandListener {

    private lateinit var binding: FragmentDashboardBinding
    private val viewModel by lazy {
        requireActivity().run {
            ViewModelProvider(
                requireActivity(), MovieListViewModel(application).createFactory()
            )[MovieListViewModel::class.java]
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentDashboardBinding.inflate(inflater, container, false).apply {
        dashboardFragment = this@DashboardFragment
        binding = this
        setHasOptionsMenu(true)
    }.root

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.main, menu)
        initSearchView(menu)
        setUpObserver()
    }

    private fun setUpObserver() {
        viewModel.searchedMovieLiveData.observe(viewLifecycleOwner) {
            if (it == null) return@observe
            binding.recyclerViewSearchResult.layoutManager = LinearLayoutManager(context)
            if (it.isNotEmpty()) {
                binding.recyclerViewSearchResult.adapter = UpcomingRVAdapter(it)
            }
        }
    }

    private fun initSearchView(menu: Menu) {
        val searchItem = menu.findItem(R.id.action_search)
        val searchView = MenuItemCompat.getActionView(searchItem) as SearchView
        initializeSearch(searchView)
        searchItem.setOnActionExpandListener(this)
    }

    private fun initializeSearch(searchView: SearchView) {
        val disposable = RxSearchObservable.fromView(searchView)
            .debounce(300, TimeUnit.MILLISECONDS)
            .filter { it.isNotEmpty() }
            .distinctUntilChanged()
            .subscribe { viewModel.getSearchedMovies(it) }
    }

    object RxSearchObservable {

        fun fromView(searchView: SearchView): Observable<String> {

            val subject = PublishSubject.create<String>()

            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(s: String): Boolean {
                    subject.onComplete()
                    return true
                }

                override fun onQueryTextChange(text: String): Boolean {
                    subject.onNext(text)
                    return true
                }
            })

            return subject
        }
    }

    override fun onStop() {
        super.onStop()

    }

    override fun onMenuItemActionExpand(item: MenuItem): Boolean {

        binding.recyclerViewSearchResult.visibility = View.VISIBLE
        binding.layoutTabs.visibility = View.GONE
        return true
    }

    override fun onMenuItemActionCollapse(item: MenuItem): Boolean {
        binding.recyclerViewSearchResult.visibility = View.GONE
        binding.layoutTabs.visibility = View.VISIBLE
        print("collapsed")
        return true
    }
}