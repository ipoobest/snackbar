package com.hoikhong.snackbar

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import com.hoikhong.snackbar.R.id.coordinatorLayout
import android.widget.TextView
import com.hoikhong.snackbar.R.id.coordinatorLayout







class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        btnSimpleSnackbar.setOnClickListener(this)
        btnActionCallback.setOnClickListener(this)
        btnCustomSnackbar.setOnClickListener(this)

    }

    fun simpleSnackbar() {
        val snackBar = Snackbar.make(coordinatorLayout,
                "Hello world",
                Snackbar.LENGTH_INDEFINITE)
        snackBar.show()
    }

    fun actionCallback() {
        val snackBar = Snackbar.make(coordinatorLayout,
                "Hello world",
                Snackbar.LENGTH_LONG)
                .setAction("Toast", {
                    Toast.makeText(this@MainActivity, "action callback", Toast.LENGTH_SHORT).show()
                }).show()



    }

    fun customSanckbar() {
        val snackbar = Snackbar
                .make(coordinatorLayout, "Custom SanckBar", Snackbar.LENGTH_LONG)
                .setAction("RETRY") { }

        // Changing message text color
        snackbar.setActionTextColor(Color.RED)

// Changing action button text color
        val sbView = snackbar.view
        val textView = sbView.findViewById<View>(android.support.design.R.id.snackbar_text) as TextView
        textView.setTextColor(Color.WHITE)
        snackbar.show()
    }

    override fun onClick(v: View?) {
        when (v) {
            btnSimpleSnackbar -> {
                simpleSnackbar()
            }
            btnActionCallback -> {
                actionCallback()
            }
            btnCustomSnackbar -> {
                customSanckbar()
            }

        }
    }

}
