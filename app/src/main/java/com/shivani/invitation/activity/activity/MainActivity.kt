package com.shivani.invitation.activity.activity

import android.media.MediaPlayer
import android.os.Bundle
import android.view.MenuItem
import android.view.WindowManager
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.shivani.invitation.R
import com.shivani.invitation.activity.activity.fragment.FirstFragment
import com.shivani.invitation.activity.activity.fragment.SecondFragment
import com.shivani.invitation.activity.activity.fragment.ThirdFragment
import com.shivani.invitation.activity.activity.fragment.albumFragmet
import de.hdodenhof.circleimageview.CircleImageView


class MainActivity : AppCompatActivity() {

    var groomI:CircleImageView? = null
    var brideI:CircleImageView? = null
    var ganeshI:ImageView? = null
    var bottomNav:BottomNavigationView? = null
    var player: MediaPlayer? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        initView()
        playMusic()
        openFragment(FirstFragment())

    }

    fun openFragment(fragment: Fragment?) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment!!)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun initView() {
         bottomNav = findViewById(R.id.bottom_navigation) as BottomNavigationView
//        val layoutParams =
//            bottomNav!!.getLayoutParams() as CoordinatorLayout.LayoutParams
        //layoutParams.behavior = BottomNavigationBehavior()

//        groomI = findViewById(R.id.groom_image)
//        brideI = findViewById(R.id.bride_image)
//        ganeshI = findViewById(R.id.namaste_image)
//
//        Glide.with(this).load(R.drawable.rahul).into(groomI!!)
//        Glide.with(this).load(R.drawable.shristi).into(brideI!!)
//        Glide.with(this).load(R.drawable.gan).into(ganeshI!!)

        bottomNav!!.setOnNavigationItemSelectedListener(object: NavigationView.OnNavigationItemSelectedListener,
            BottomNavigationView.OnNavigationItemSelectedListener {

            override fun onNavigationItemSelected(item: MenuItem): Boolean {

                for (i in 0 until bottomNav!!.getMenu().size()) {

                    val menuItem: MenuItem = bottomNav!!.getMenu().getItem(i)
                    val isChecked = menuItem.itemId == item.itemId
                    menuItem.isChecked = isChecked
                }

                when (item.itemId){

                    R.id.home ->{
//                        var intent = Intent(this@MainActivity,AboutActivity::class.java)
//                        startActivity(intent)
//                        return true
                        openFragment(FirstFragment())
                        return true;

                    }
                    R.id.mehandi ->{
//                        var intent = Intent(this@MainActivity, MehandiActivity::class.java)
//                        startActivity(intent)
                        openFragment(SecondFragment())
                        return true
                    }

//                    R.id.sangeet ->{
//                        var intent = Intent(this@MainActivity,ProjectActivity::class.java)
//                        startActivity(intent)
//                        return true
//                    }
//
                    R.id.album ->{
                      openFragment(albumFragmet())
                        return true
                    }

                    R.id.address ->{
//                        var intent = Intent(this@MainActivity,AddressActivity::class.java)
//                        startActivity(intent)
                        openFragment(ThirdFragment())
                        return true
                    }
//                    R.id.about->{
//                        var intent = Intent(this@MainActivity,PersonalActivity::class.java)
//                        startActivity(intent)
//                        return true
                    //}
                }

                return false
            }

        })
    }

     fun playMusic(){

        if (player == null){
            player = MediaPlayer.create(this, R.raw.song);
            player!!.setOnCompletionListener(object:MediaPlayer.OnCompletionListener{

                override fun onCompletion(p0: MediaPlayer?) {
                    stopPlayer()
                }

            })
        }

        player!!.start()
    }

    public fun stopPlayer(){
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

