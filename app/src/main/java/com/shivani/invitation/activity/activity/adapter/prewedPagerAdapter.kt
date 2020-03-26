package com.shivani.weddinginvitation.adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.shivani.invitation.R



class prewedPagerAdapter(var context:Context):PagerAdapter() {

    var images: Array<Int> = arrayOf(R.drawable.images, R.drawable.images, R.drawable.images_2, R.drawable.family,R.drawable.images_doli,R.drawable.sangeet)
    // var images:Array<Int>? = Array(5)


    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`

    }

    override fun getCount(): Int {
    return images.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(context)

        val viewItem: View = inflater.inflate(R.layout.slideshow_layout, container, false)
        val imageView: ImageView = viewItem.findViewById<View>(R.id.image_id) as ImageView
        Glide.with(context).asDrawable().load(images.get(position)).into(imageView)
        //imageView.setImageResource(images.get(position))

        (container as ViewPager).addView(viewItem)

        return viewItem
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }
}