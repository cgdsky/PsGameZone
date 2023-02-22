package com.uraniumcode.psgamezone.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.example.GameDetail
import com.uraniumcode.psgamezone.R
import com.uraniumcode.psgamezone.fragments.HomeFragmentDirections
import com.uraniumcode.psgamezone.utils.downloadFromUrl
import com.uraniumcode.psgamezone.utils.placeholderProgressBar
import kotlinx.android.synthetic.main.item_games.view.*

class GamesAdapter(
    private val gameList: ArrayList<GameDetail>,
) : RecyclerView.Adapter<GamesAdapter.PsGamesViewHolder>() {

    class PsGamesViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    private var view: View? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PsGamesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        view = inflater.inflate(R.layout.item_games, parent, false)

        return PsGamesViewHolder(view!!)
    }

    override fun onBindViewHolder(holder: PsGamesViewHolder, position: Int) {
        holder.view.image_game.downloadFromUrl(
            gameList[position].images[0].url,
            placeholderProgressBar(holder.view.context),
            true
        )
        holder.view.setOnClickListener {
            if (gameList[position].url != null) {
                val action =
                    HomeFragmentDirections.actionHomeFragmentToDetailFragment(gameList[position].url!!)
                Navigation.findNavController(it).navigate(action)
            } else {
            //todo
            //Toast
            }

        }
    }

    override fun getItemCount(): Int {
        return gameList.size
    }


    @SuppressLint("NotifyDataSetChanged")
    fun updateGameList(newGameList: List<GameDetail>) {
        gameList.clear()
        gameList.addAll(newGameList)
        notifyDataSetChanged()
    }
}