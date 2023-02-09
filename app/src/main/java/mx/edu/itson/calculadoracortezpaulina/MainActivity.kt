package mx.edu.itson.calculadoracortezpaulina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var operacion: Int = 0
    var numero1: Double=0.0
    lateinit var tv_num1: TextView
    lateinit var tv_num2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_num1 = findViewById(R.id.tvArriba)
        tv_num2 = findViewById(R.id.tvAbajo)
        val btnBorrar: Button = findViewById(R.id.bnC)
        val btnIgual: Button = findViewById(R.id.bnIgual)

        btnIgual.setOnClickListener{
            var respuesta: Double = 0.0
            var numero2:Double = 0.0

            try {
                numero2 = tv_num2.text.toString().toDouble()

            } catch (e: java.lang.Exception){
                println(e)
            }


            when (operacion){
                1 -> respuesta = numero1 + numero2
                2 -> respuesta = numero1 - numero2
                3 -> respuesta = numero1 * numero2
                4 -> respuesta = numero1 / numero2
            }

            tv_num2.setText(respuesta.toString())
            tv_num1.setText(" ")
        }

        btnBorrar.setOnClickListener {
            tv_num1.setText(" ")
            tv_num2.setText(" ")
            numero1 = 0.0
            operacion = 0
        }
    }

    fun presionarNumero(view: View){
        val tv_num2: TextView=findViewById(R.id.tvAbajo)
        val num2: String = tv_num2.text.toString()

        when(view.id){
            R.id.bn0 -> tv_num2.setText(num2 + "0")
            R.id.bn1 -> tv_num2.setText(num2 + "1")
            R.id.bn2 -> tv_num2.setText(num2 + "2")
            R.id.bn3 -> tv_num2.setText(num2 + "3")
            R.id.bn4 -> tv_num2.setText(num2 + "4")
            R.id.bn5 -> tv_num2.setText(num2 + "5")
            R.id.bn6 -> tv_num2.setText(num2 + "6")
            R.id.bn7 -> tv_num2.setText(num2 + "7")
            R.id.bn8 -> tv_num2.setText(num2 + "8")
            R.id.bn9 -> tv_num2.setText(num2 + "9")
        }
    }

    fun presionarOperacion(view:View){
        numero1 = tv_num2.text.toString().toDouble()
        var num2_text : String = tv_num2.text.toString()
        tv_num2.setText(" ")

        when(view.id){
            R.id.bnSum -> {
                tv_num1.setText(num2_text + "+")
                operacion = 1
            }

            R.id.bnResta -> {
                tv_num1.setText(num2_text + "-")
                operacion = 2
            }

            R.id.bnMul-> {
                tv_num1.setText(num2_text + "*")
                operacion = 3
            }

            R.id.bnDiv -> {
                tv_num1.setText(num2_text + "/")
                operacion = 4
            }
        }
    }
}