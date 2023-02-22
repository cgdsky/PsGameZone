package com.uraniumcode.psgamezone.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.example.example.GameDetail
import com.uraniumcode.psgamezone.R
import com.uraniumcode.psgamezone.adapters.ImageViewPagerAdapter
import com.uraniumcode.psgamezone.utils.ApiHelper
import com.uraniumcode.psgamezone.viewmodels.GameDetailViewModel
import kotlinx.android.synthetic.main.fragment_detail.*


class GameDetailFragment : Fragment() {
    private lateinit var detailUrl: String
    private lateinit var viewModel: GameDetailViewModel
    private lateinit var gameDetail: GameDetail
    private lateinit var imageDots: Array<ImageView?>
    private lateinit var imageViewPagerAdapter: ImageViewPagerAdapter

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
        tv_game_detail.text = HtmlCompat.fromHtml(gameDetail.longDesc!!, HtmlCompat.FROM_HTML_MODE_LEGACY)
        imageViewPagerAdapter = ImageViewPagerAdapter(
            ApiHelper().createImageArray(gameDetail.images, gameDetail.mediaList!!.screenshots),
            context!!
        )
        view_pager_images.adapter = imageViewPagerAdapter
        setDots()
        setListeners()
    }

    private fun setDots() {
        val dotsCount = imageViewPagerAdapter.count
        imageDots = arrayOfNulls(dotsCount)
        for (i in 0 until dotsCount) {
            imageDots[i] = ImageView(context)
            imageDots[i]?.setImageDrawable(ContextCompat.getDrawable(context!!,R.drawable.non_active_dot))
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(8, 0, 8, 0)
            view_pager_dots.addView(imageDots[i], params)
        }

        imageDots[0]?.setImageDrawable(ContextCompat.getDrawable(context!!,R.drawable.active_dot))

    }

    private fun setListeners() {
        view_pager_images.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                for (i in 0 until imageViewPagerAdapter.count) {
                    imageDots[i]?.setImageDrawable(ContextCompat.getDrawable(context!!,R.drawable.non_active_dot))
                }
                imageDots[position]?.setImageDrawable(ContextCompat.getDrawable(context!!,R.drawable.active_dot))

            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
    }

}