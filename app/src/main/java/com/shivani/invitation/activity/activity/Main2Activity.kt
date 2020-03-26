package com.shivani.invitation.activity.activity

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.shivani.invitation.R
import com.shivani.invitation.activity.activity.adapter.ViewPagerAdapter
import com.shivani.invitation.activity.activity.fragment.FirstFragment
import com.shivani.invitation.activity.activity.fragment.SecondFragment
import com.shivani.invitation.activity.activity.fragment.ThirdFragment
import com.shivani.invitation.activity.activity.fragment.albumFragmet


class Main2Activity : AppCompatActivity() {

    var bottomNav: BottomNavigationView? = null
    var viewPager: ViewPager? = null
    var prevMenuItem: MenuItem? = null
    var player: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)

        playMusic()
        initView()



    }

    private fun initView(){
       bottomNav = findViewById(R.id.navigation) as BottomNavigationView
        viewPager = findViewById(R.id.myViewPager)


        bottomNav!!.setOnNavigationItemSelectedListener(object: NavigationView.OnNavigationItemSelectedListener,
            BottomNavigationView.OnNavigationItemSelectedListener {

            override fun onNavigationItemSelected(item: MenuItem): Boolean {

//                for (i in 0 until bottomNav!!.getMenu().size()) {
//
//                    val menuItem: MenuItem = bottomNav!!.getMenu().getItem(i)
//                    val isChecked = menuItem.itemId == item.itemId
//                    menuItem.isChecked = isChecked
//                }

                when (item.itemId){

                    R.id.home ->{

                        //openFragment(FirstFragment())
                        viewPager!!.setCurrentItem(0)
                        return true;

                    }
                    R.id.mehandi ->{

                        //openFragment(SecondFragment())
                        viewPager!!.setCurrentItem(1)
                        return true
                    }

                    R.id.album ->{
                        //openFragment(albumFragmet())
                        viewPager!!.setCurrentItem(2)
                        return true
                    }
//
                    R.id.address ->{
//
                        //openFragment(ThirdFragment())
                        viewPager!!.setCurrentItem(3)
                        return true
                    }

                }

                return false
            }
//
        })

        viewPager!!.addOnPageChangeListener(object : OnPageChangeListener {

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                if (prevMenuItem != null) {
                    prevMenuItem!!.isChecked = false
                } else {
                    bottomNav!!.getMenu().getItem(0).setChecked(false)
                }
                Log.d("page", "onPageSelected: $position")
                bottomNav!!.getMenu().getItem(position).setChecked(true)
                prevMenuItem = bottomNav!!.getMenu().getItem(position)
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
//
//        viewPager!!.setOnTouchListener(object: View.OnTouchListener{
//            override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
//               return true
//            }
//
//        })

       setupViewPager(viewPager!!);

    }

    fun openFragment(fragment: Fragment?) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment!!)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)

        viewPagerAdapter.addFragment(FirstFragment())
        viewPagerAdapter.addFragment(SecondFragment())
        viewPagerAdapter.addFragment(albumFragmet())
        viewPagerAdapter.addFragment(ThirdFragment())
        viewPager.adapter = viewPagerAdapter
    }

    fun playMusic(){

        if (player == null){
            player = MediaPlayer.create(this, R.raw.song);
            player!!.setOnCompletionListener(object: MediaPlayer.OnCompletionListener{

                override fun onCompletion(p0: MediaPlayer?) {
                    stopPlayer()
                }

            })
        }

        player!!.start()
    }

     fun stopPlayer(){
        if (player != null){
            player!!.release()
            player = null


        }
    }

    override fun onPause() {
        stopPlayer()
        super.onPause()
    }

    override fun onResume() {
        playMusic()
        super.onResume()
    }

    }

