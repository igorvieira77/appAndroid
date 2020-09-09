package com.example.projeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun cliqueBotao(component:View) {

        val numeroInteiro = resultado.text.toString().toInt()
        val numeroReal = resultado.text.toString().toDouble()

        resultado.text = "A sua média final é ${numeroInteiro/2}"

    }


}