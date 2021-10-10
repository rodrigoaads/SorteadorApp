package com.rodrigoaads.sorteador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text_btn_result.setOnClickListener {
            onRaffle(editText_min.text.toString(), editText_max.text.toString())
        }
    }

    fun onRaffle(min: String, max: String){
        val fMin = min.toIntOrNull()
        val fMax = max.toIntOrNull()
        try {
            if(fMin != null && fMax != null){
                val result = (fMin..fMax).random().toString()
                text_result.text = result
                text_result.visibility = View.VISIBLE
            }else{
                Toast.makeText(this, "Valores Inválidos.", Toast.LENGTH_SHORT).show()
            }
        }catch(e: Exception){
            Toast.makeText(this, "Informe os valores corretamente.", Toast.LENGTH_SHORT).show()
        }
    }
}