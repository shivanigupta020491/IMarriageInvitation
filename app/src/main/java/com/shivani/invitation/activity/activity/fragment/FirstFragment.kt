package com.shivani.invitation.activity.activity.fragment

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.shivani.invitation.R
import com.shivani.invitation.activity.activity.Main2Activity
import com.shivani.invitation.activity.activity.MainActivity
import de.hdodenhof.circleimageview.CircleImageView

class FirstFragment : Fragment(), View.OnClickListener {

    var groomI: CircleImageView? = null
    var brideI: CircleImageView? = null
    var ganeshI: ImageView? = null
    var bottomNav: BottomNavigationView? = null
    var player: MediaPlayer? = null
    var speakerImage:ImageView? = null
    var muteImage:ImageView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activity!!.getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_first, container, false)
//        bottomNav = view.findViewById(R.id.bottom_navigation) as BottomNavigationView

        groomI = view.findViewById(R.id.groom_image)
        brideI = view.findViewById(R.id.bride_image)
        ganeshI = view.findViewById(R.id.namaste_image)
        speakerImage = view.findViewById(R.id.speaker)
        muteImage = view.findViewById(R.id.speaker_mute)

        speakerImage!!.setOnClickListener(this)
        muteImage!!.setOnClickListener(this)


        Glide.with(this).load(R.drawable.rahul).into(groomI!!)
        Glide.with(this).load(R.drawable.shristi).into(brideI!!)
        Glide.with(this).load(R.drawable.gan).into(ganeshI!!)

        return view

    }

    override fun onClick(view: View?) {

        when(view!!.id){

            R.id.speaker ->{
                speakerImage!!.visibility = View.GONE
                muteImage!!.visibility = View.VISIBLE
                (activity as Main2Activity?)!!.stopPlayer()
            }

            R.id.speaker_mute ->{
                muteImage!!.visibility = View.GONE
                speakerImage!!.visibility = View.VISIBLE
                (activity as Main2Activity?)!!.playMusic()
            }
        }


    }


//    private fun playMusic(){
//
//        if (player == null){
//            player = MediaPlayer.create(activity, R.raw.song);
//            player!!.setOnCompletionListener(object: MediaPlayer.OnCompletionListener{
//
//                override fun onCompletion(p0: MediaPlayer?) {
//                    stopPlayer()
//                }
//
//            })
//        }
//
//        player!!.start()
//    }
//
//    public fun stopPlayer(){
//        if (player != null){
//            player!!.release()
//            player = null
//
//
//        }
//    }
//
//    override fun onPause() {
//        stopPlayer()
//        super.onPause()
//    }
//
//    override fun onResume() {
//        playMusic()
//        super.onResume()
//    }

}