package com.example.planets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_planet_details.*

class PlanetDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planet_details)

        var bundle:Bundle? = intent.extras
        var adi= bundle?.getString("Adi")
        var aciklama=bundle?.getString("Aciklama")
        var resim=bundle?.getInt("Resim")

        detaybaslik.text = adi
        detayaciklama.text = aciklama
        Detayresim.setImageResource(resim!!)
    }
}