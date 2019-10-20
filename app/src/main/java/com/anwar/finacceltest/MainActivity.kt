package com.anwar.finacceltest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.anwar.finacceltest.ui.main.MainFragment
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        setupToolbar()

        val navController = findNavController(R.id.nav_host_fragment)
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            println("Dest: $destination")
            tvMainActivityCustomTitle.text = destination.label
        }
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbarMainActivity)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

}
