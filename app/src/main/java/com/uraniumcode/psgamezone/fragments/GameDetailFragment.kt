package com.uraniumcode.psgamezone.fragments

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.example.GameDetail
import com.uraniumcode.psgamezone.R
import com.uraniumcode.psgamezone.utils.downloadFromUrl
import com.uraniumcode.psgamezone.utils.placeholderProgressBar
import com.uraniumcode.psgamezone.viewmodels.GameDetailViewModel
import kotlinx.android.synthetic.main.fragment_detail.*


class GameDetailFragment : Fragment() {
    private lateinit var detailUrl: String
    private lateinit var viewModel: GameDetailViewModel
    private lateinit var gameDetail: GameDetail


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(GameDetailViewModel::class.java)
        getData()
        observeLiveData()

    }

    private fun getData() {
        arguments?.let {
            detailUrl = GameDetailFragmentArgs.fromBundle(it).url
            viewModel.getGameDetail(detailUrl)
        }
    }

    private fun observeLiveData() {
        viewModel.gameLiveData.observe(viewLifecycleOwner) { game ->
            game.let {
                gameDetail = it
                setDataToView()
            }
        }
    }

    private fun setDataToView() {
        image_game.downloadFromUrl(
            gameDetail.images[0].url,
            placeholderProgressBar(context!!),
            false
        )

        tv_game_detail.text = Html.fromHtml(gameDetail.longDesc)

    }

}