package com.github.tumusx.wearos_app

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.fragment.app.FragmentActivity
import com.github.tumusx.wearos_app.databinding.ActivityHomeWearOsBinding

class HomeWearOsActivity : FragmentActivity() {
    private lateinit var binding: ActivityHomeWearOsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeWearOsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}