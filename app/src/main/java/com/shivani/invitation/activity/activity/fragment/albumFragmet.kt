package com.shivani.invitation.activity.activity.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

import com.shivani.invitation.R

class albumFragmet : Fragment() {

    var familyLayout: LinearLayout? = null
    var myLayout: LinearLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_album_fragmet, container, false)

        familyLayout = view.findViewById(R.id.familyAlbumLayout)
        myLayout = view.findViewById(R.id.myAlbumLayout)

        familyLayout!!.setOnClickListener {

            System.out.println(">>.... >>. nnn")
//            var intent = Intent(view.context, FimilyPicActivity::class.java)
//            startActivity(intent)
           openFragment(family())
        }
//
        myLayout!!.setOnClickListener {

//            var intent = Intent(view.context, preweddingPicActivity::class.java)
//            startActivity(intent)
            openFragment(preWedding())

        }

        return view
    }
    fun openFragment(fragment: Fragment?) {
        var fm: FragmentManager = getFragmentManager()!!
        val transaction: FragmentTransaction = fm.beginTransaction()
        transaction.replace(R.id.container_album, fragment!!)
        transaction.addToBackStack(null)
        transaction.commit()
    }


}
