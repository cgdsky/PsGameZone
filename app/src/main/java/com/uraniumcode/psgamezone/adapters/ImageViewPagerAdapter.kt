package com.uraniumcode.psgamezone.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.uraniumcode.psgamezone.R
import com.uraniumcode.psgamezone.utils.downloadFromUrl
import com.uraniumcode.psgamezone.utils.placeholderProgressBar


class ImageViewPagerAdapter(
    private var coverimages: ArrayList<String>,
    private val context: Context
) : PagerAdapter() {

    override fun getCount(): Int {
        return coverimages.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as LinearLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view: View = (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)
                as LayoutInflater).inflate(R.layout.item_images, null)

        val imageView: ImageView = view.findViewById<View>(R.id.image_main) as ImageView

        imageView.downloadFromUrl(
            coverimages[position],
            placeholderProgressBar(context),
            true
        )

        val vp = container as ViewPager
        vp.addView(view, 0)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val vp = container as ViewPager
        val view = `object` as View
        vp.removeView(view)
    }
}