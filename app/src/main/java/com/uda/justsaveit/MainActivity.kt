package com.uda.justsaveit

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Testing RealTime DB
        var database = FirebaseDatabase.getInstance().reference
        database.setValue("Data Saved in db")
    }

    fun redirectToMaps(view: View) {
        startActivity(Intent(applicationContext, MapsActivity::class.java))
    }

    fun redirectToHome(view: View) {
        startActivity(Intent(applicationContext, HomeActivity::class.java))
    }


    fun goBack(view: View) {
        startActivity(Intent(applicationContext, HomeActivity::class.java))
    }
}