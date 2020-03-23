package com.matheussilas.gastodeviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bttCalculate.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.bttCalculate) {
            calculate()
        }
    }

    private fun calculate() {
        if (validation()) {
            try {
                val distance = editDistance.text.toString().toFloat()
                val price = editPrice.text.toString().toFloat()
                val autonomy = editAutonomy.text.toString().toFloat()

                val total = (distance * price) / autonomy

                txtValue.text = "R$ ${"%.2f".format(total)}"

            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Informe valores váldos", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Preencha todos os campos com valores válidos", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun validation(): Boolean {
        return (editDistance.text.toString() != "" && editPrice.text.toString() != "" && editAutonomy.text.toString() != "" && editAutonomy.text.toString() != "0"
                )
    }
}