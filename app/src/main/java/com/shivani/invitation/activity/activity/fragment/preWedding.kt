package com.shivani.invitation.activity.activity.fragment

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager.widget.ViewPager
import com.shivani.invitation.R
import com.shivani.invitation.activity.activity.MainActivity
import com.shivani.weddinginvitation.adapter.prewedPagerAdapter
import me.relex.circleindicator.CircleIndicator
import java.util.*


class preWedding : Fragment() {
    private var viewPager: ViewPager? = null
    private var adapter: prewedPagerAdapter? = null
    private var indictor: CircleIndicator? = null
    private var currentPage:Int = 0
    private var condition = false
    var toolbar: Toolbar? = null
    lateinit var handler: Handler
    lateinit var runnable:Runnable
    var player: MediaPlayer? = null
    var main = MainActivity()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_pre_wedding, container, false)

        viewPager = view.findViewById<ViewPager>(R.id.preWeddingViewPager)
        indictor = view.findViewById(R.id.cirle_indicator_prewed)
        toolbar = view.findViewById(R.id.toolbarb)

        val activity = activity as AppCompatActivity

        activity.setSupportActionBar(toolbar)
        activity.getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true);
        activity.getSupportActionBar()!!.setDisplayShowHomeEnabled(true);


        adapter = prewedPagerAdapter(activity)
        viewPager!!.adapter = adapter
        indictor!!.setViewPager(viewPager)

        startHandler()
        if (condition == true){
            condition = false
        }

        toolbar!!.setNavigationOnClickListener {
           activity.onBackPressed()
//            var intent = Intent(view.context, albumFragmet::class.java)
//            startActivity(intent)

        }


        return view
    }

    private fun startHandler(){

        handler = Handler()
        runnable = Runnable {

            if (!condition) {
                var i = viewPager!!.currentItem

                if (i == 5 || i > 5) {

                    condition = true
                } else {
                    i = i + 1
                    viewPager!!.setCurrentItem(i, true)
                }
            }
        }

        Timer().schedule(object: TimerTask(){
            override fun run() {

                handler.post(runnable)

            }

        },4000,5000)
    }



}
