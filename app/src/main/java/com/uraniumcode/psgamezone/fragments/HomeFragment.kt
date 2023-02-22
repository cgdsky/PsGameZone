package com.uraniumcode.psgamezone.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.example.GameDetail
import com.uraniumcode.e_cuzdanplus.viewModels.HomeViewModel
import com.uraniumcode.psgamezone.R
import com.uraniumcode.psgamezone.adapters.GamesAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    private lateinit var viewModel: HomeViewModel
    private lateinit var gamesAdapter: GamesAdapter
    private lateinit var gameList: ArrayList<GameDetail>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        setAdapters()
        getData()
        observeLiveData()
    }

    private fun setAdapters() {
        recycler_games.layoutManager = GridLayoutManager(
            context, 2
        )

        gamesAdapter = GamesAdapter(arrayListOf())

        recycler_games.adapter = gamesAdapter

    }

    private fun observeLiveData() {
        viewModel.gamesLiveData.observe(viewLifecycleOwner) { games ->
            games?.let {
                gameList = it.gameDetails
                gamesAdapter.updateGameList(gameList)

            }
        }
    }

    private fun getData() {
        viewModel.getNewGames()

    }
}