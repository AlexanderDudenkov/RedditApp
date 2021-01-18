package com.dudencov.redditapp.presentation.view.activies

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dudencov.redditapp.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //override fun onSupportNavigateUp() = NavHostFragment.findNavController(findViewById<>(nav_host_fragment)).navigateUp()
}
