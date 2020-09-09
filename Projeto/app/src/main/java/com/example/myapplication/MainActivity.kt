 package com.example.myapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

 class MainActivity : AppCompatActivity() {
     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)
     }

     fun calcular(view: View) {
         when {
             et_nome.text.isEmpty() || et_1nota.text.isEmpty() || et_2nota.text.isEmpty() || et_3nota.text.isEmpty() || et_4nota.text.isEmpty() -> {
                 Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
                 return
             }
         }

         val nome = et_nome.text.toString()
         val nota1 = et_1nota.text.toString().toDouble()
         val nota2 = et_2nota.text.toString().toDouble()
         val nota3 = et_3nota.text.toString().toDouble()
         val nota4 = et_4nota.text.toString().toDouble()

         when {
             nome.isBlank() -> {
                 Toast.makeText(this, "Digite seu nome", Toast.LENGTH_SHORT).show()
                 return
             }
             nota1 < 0 || nota2 < 0 || nota3 < 0 || nota4 < 0 -> {
                 Toast.makeText(this, "As notas devem ser maior que 0", Toast.LENGTH_SHORT).show()
                 return
             }
             nota1 > 10 || nota2 > 10 || nota3 > 10 || nota4 > 10 -> {
                 Toast.makeText(this, "As notas devem ser menor que 10", Toast.LENGTH_SHORT).show()
                 return
             }
         }

         val media = (nota1 + nota2 + nota3 + nota4) / 4

         tv_resultado.visibility = View.VISIBLE

         when(media) {
             in 7.0..10.0 -> {
                 tv_resultado.setTextColor(Color.parseColor("#67E000"))
                 tv_resultado.text = "$nome aprovado(a) com $media de média"
             }
             else -> {
                 tv_resultado.setTextColor(Color.parseColor("#FB5161"))
                 tv_resultado.text = " $nome reprovado(a) com $media de média"
             }
         }
     }
 }