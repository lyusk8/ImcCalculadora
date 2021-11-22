package com.example.calculoimc

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultadoActivity: AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val texto = findViewById<TextView>(R.id.texto)

        val dados = intent.extras
        val nome = dados?.getString("nome")
        val resultado = dados?.getString("resultado")
        texto.text = "$nome o resultado do seu imc é: $resultado"
    }
}