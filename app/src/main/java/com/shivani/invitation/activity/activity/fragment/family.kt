package com.shivani.invitation.activity.activity.fragment

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager

import com.shivani.invitation.R
import com.shivani.invitation.activity.activity.MainActivity
import com.shivani.weddinginvitation.adapter.familyFragmentAdapter
import me.relex.circleindicator.CircleIndicator
import java.util.*


class family : Fragment() {

    private var viewPager: ViewPager? = null
    private var adapter: familyFragmentAdapter? = null
    private var indictor: CircleIndicator? = null
    private var currentPage:Int = 0
    private var conditiona = false
    lateinit var handler: Handler
    var toolbar: Toolbar? = null
    lateinit var runnable:Runnable
    var player: MediaPlayer? = null
    var main = MainActivity()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_family, container, false)

        viewPager = view.findViewById<ViewPager>(R.id.fanilyPicViewPager)
        indictor = view.findViewById(R.id.cirle_indicator_family)
        toolbar = view.findViewById(R.id.toolbara)

        val activity = activity as AppCompatActivity

        activity.setSupportActionBar(toolbar)
        activity.getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true);
        activity.getSupportActionBar()!!.setDisplayShowHomeEnabled(true);


        adapter = familyFragmentAdapter(activity)
        viewPager!!.adapter = adapter
        indictor!!.setViewPager(viewPager)

        toolbar!!.setNavigationOnClickListener {
            activity.onBackPressed()
//            var intent = Intent(view.context, albumFragmet::class.java)
//            startActivity(intent)

        }


        startHandler()
        if (conditiona == true){
            conditiona = false
        }



        return view
    }
    private fun startHandler(){

        handler = Handler()
        runnable = Runnable {

            if (!conditiona) {
                var i = viewPager!!.currentItem

                Log.d(">>>>>curent item xfmily", i.toString())
                if (i == 3 || i > 3) {


                    conditiona = true
                    Log.d(">>>>>curent  xfmily", i.toString())

//                    handler.removeMessages(0)
//                      handler.removeCallbacks(runnable)

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
