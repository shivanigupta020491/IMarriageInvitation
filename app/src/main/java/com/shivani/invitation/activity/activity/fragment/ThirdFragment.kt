package com.shivani.invitation.activity.activity.fragment

import android.content.DialogInterface
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.Constraints.TAG
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.shivani.invitation.R


class ThirdFragment : Fragment() {

    var googleMapImage:ImageView? = null
    var mobileNo1:TextView? = null
    var mobileNo2:TextView? = null
    var mobileNo3:TextView? = null
    var map:LinearLayout?=  null
    var player: MediaPlayer? = null

    private val ARG_SECTION_NUMBER = "section_number"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        sliderViewModel!!.setIndex(2);
//        var main = MainActivity()
//        main.callFragment()


    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        var view = inflater.inflate(R.layout.fragment_third, container, false)
        googleMapImage = view.findViewById(R.id.googleMap)
        map = view.findViewById(R.id.map_layout)
        mobileNo1 = view.findViewById(R.id.father_number)
        mobileNo2 = view.findViewById(R.id.brother_number)
        mobileNo3 = view.findViewById(R.id.own_number)

        map!!.setOnClickListener {
            openGoogleMap()
        }

        mobileNo1!!.setOnClickListener {
           openDialPad("9893219636")
            }
        mobileNo2!!.setOnClickListener {
            openDialPad("9993149165")
            }
        mobileNo3!!.setOnClickListener {
            openDialPad("9009133091")
            }

        return view
    }

    private fun openGoogleMap(){
      stopPlayer()

        val builder: AlertDialog.Builder = AlertDialog.Builder(activity!!)
        builder.setMessage("Open Google Maps?")
            .setCancelable(true)
            .setPositiveButton("Yes",
                DialogInterface.OnClickListener { dialog, id ->
                    val latitude: String =
                        java.lang.String.valueOf(24.429134)
                    val longitude: String =
                        java.lang.String.valueOf(80.035235)
                    val gmmIntentUri =
                        Uri.parse("google.navigation:q=$latitude,$longitude")

                    val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                    mapIntent.setPackage("com.google.android.apps.maps")
                    try {
                        if (mapIntent.resolveActivity(activity!!.packageManager) != null) {
                            startActivity(mapIntent)
                        }
                    } catch (e: NullPointerException) {
                        Log.e(
                            TAG,
                            "onClick: NullPointerException: Couldn't open map." + e.message
                        )
                        Toast.makeText(activity, "Couldn't open map", Toast.LENGTH_SHORT)
                            .show()
                    }
                })
            .setNegativeButton("No",
                DialogInterface.OnClickListener { dialog, id -> dialog.cancel() })
        val alert: AlertDialog = builder.create()
        alert.show()

    }

    fun openDialPad(phoneNumber: String?) {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.data = Uri.parse("tel:" + phoneNumber)

        Log.d("data",Uri.parse("tel:" + phoneNumber).toString())
        activity!!.startActivity(intent)
    }

    public fun stopPlayer() {
        if (player != null) {
            player!!.release()
            player = null


        }
    }

}