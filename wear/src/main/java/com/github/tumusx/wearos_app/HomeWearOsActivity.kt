package com.github.tumusx.wearos_app

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import com.github.tumusx.wearos_app.databinding.ActivityHomeWearOsBinding

class HomeWearOsActivity : Activity() {

    private lateinit var binding: ActivityHomeWearOsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeWearOsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var click = 0
        binding.btnMessage.setOnClickListener {
            click++
            Toast.makeText(
                this@HomeWearOsActivity,
                "Primeiro App: $click",
                Toast.LENGTH_LONG
            )
                .show()
        }
    }
}