package com.example.calculoimc.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.calculoimc.R
import com.example.calculoimc.ResultadoActivity
import com.google.android.material.textfield.TextInputEditText
import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configBotao()
    }

    private fun configBotao(){
        val botao = findViewById<Button>(R.id.botao)
        botao.setOnClickListener {
            val intent = Intent(this, ResultadoActivity::class.java)
            val nome = findViewById<TextInputEditText>(R.id.nome)

            intent.putExtra("resultado", calculaImc())
            intent.putExtra("nome", nome.text.toString())

            startActivity(intent)

        }
    }

    private fun calculaImc():String{
        val peso = findViewById<TextInputEditText>(R.id.peso).text.toString().toFloat()
        val altura = findViewById<TextInputEditText>(R.id.altura).text.toString().toFloat()
        val imc = peso / (altura*altura)
        val dec = DecimalFormat("#.##")
        dec.roundingMode = RoundingMode.CEILING
        val numero = dec.format(imc)

        return when {
            numero > 40.00.toString() -> {
                "$numero: Obesidade grau III."
            }
            numero > 35.00.toString() -> {
                "$numero: Obesidade grau II"
            }
            numero > 30.00.toString() -> {
                "$numero: Obesidade grau I"
            }
            numero > 25.00.toString() -> {
                "$numero: Sobrepeso"
            }
            numero > 18.6.toString() -> {
                "$numero: Peso normal"
            }
            else -> {
                "$numero: Baixo peso"
            }
        }
    }
}