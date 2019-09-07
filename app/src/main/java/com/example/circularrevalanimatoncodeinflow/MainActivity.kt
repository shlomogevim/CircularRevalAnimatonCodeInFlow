package com.example.circularrevalanimatoncodeinflow

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewAnimationUtils
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.hypot

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_hide.setOnClickListener {
            hidFab()
        }
        button_reval.setOnClickListener {
            reavealFAD()
        }
    }

    private fun hidFab() {
        val myView: View = findViewById(R.id.fad)

// Check if the runtime version is at least Lollipop
      //  if (Build.VERSION.SDK_INT == Build.VERSION_CODES.LOLLIPOP) {
            // get the center for the clipping circle
            val cx = myView.width / 2
            val cy = myView.height / 2

            // get the initial radius for the clipping circle
            val initialRadius = hypot(cx.toDouble(), cy.toDouble()).toFloat()

            // create the animation (the final radius is zero)
            val anim = ViewAnimationUtils.createCircularReveal(myView, cx, cy, initialRadius, 0f)

            // make the view invisible when the animation is done
            anim.addListener(object : AnimatorListenerAdapter() {

                override fun onAnimationEnd(animation: Animator?) {
                    super.onAnimationEnd(animation)
                    myView.visibility = View.INVISIBLE
                }
            })
            // start the animation
            anim.start()
       /* } else {
            // set the view to visible without a circular reveal animation below Lollipop
            myView.visibility = View.VISIBLE
        }*/
    }

    private fun reavealFAD() {
        // previously invisible view
        val myView: View = findViewById(R.id.fad)
// Check if the runtime version is at least Lollipop
     //   if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // get the center for the clipping circle
            val cx = myView.width / 2
            val cy = myView.height / 2
            // get the final radius for the clipping circle
            val finalRadius = hypot(cx.toDouble(), cy.toDouble()).toFloat()

            // create the animator for this view (the start radius is zero)
            val anim = ViewAnimationUtils.createCircularReveal(myView, cx, cy, 0f, finalRadius)
            // make the view visible and start the animation
            myView.visibility = View.VISIBLE
            anim.start()
       /* } else {
            // set the view to invisible without a circular reveal animation below Lollipop
            myView.visibility = View.INVISIBLE
        }*/

    }

}
