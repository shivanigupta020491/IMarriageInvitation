package com.shivani.invitation.activity.activity.fragment

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.shivani.invitation.R
import de.hdodenhof.circleimageview.CircleImageView


class SecondFragment : Fragment() {

    var familyImage: CircleImageView?=  null
    var preweddingImageView:CircleImageView? = null
    var familyLayout:LinearLayout? = null
    var myLayout:LinearLayout? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        var view = inflater.inflate(R.layout.fragment_second, container, false)

       // familyImage = view.findViewById(R.id.myfamily)
        //preweddingImageView = view.findViewById(R.id.prewedding)
       // familyLayout = view.findViewById(R.id.familyAlbumLayout)
        //myLayout = view.findViewById(R.id.myAlbumLayout)

//        familyLayout!!.setOnClickListener{
//
//            var intent = Intent(view.context,FimilyPicActivity::class.java)
//            startActivity(intent)
//        }
////
//        myLayout!!.setOnClickListener {
//
//            var intent = Intent(view.context,preweddingPicActivity::class.java)
//            startActivity(intent)
//
//        }
//

        return view

    }
}
