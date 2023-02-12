package mx.edu.itson.examenu1

import android.os.Bundle
import android.telecom.InCallService
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    /**
     * Examen Unidad 1
     * Kevin Daniel Rios Rancaño
     * 00000180384
     * Conversor de Grados (Celcius, Farenheit, Kelvin)
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Declaracion de los edit text / buttons
        val celsius: EditText = findViewById(R.id.etC)
        val faren: EditText = findViewById(R.id.etF)
        val kelvin: EditText = findViewById(R.id.etK)
        val btnCelsius: Button = findViewById(R.id.btnGC)
        val btnFar: Button = findViewById(R.id.btnGF)
        val btnKelvin: Button = findViewById(R.id.btnGK)
        val btnLimpiarC: Button = findViewById(R.id.btnLimpiarC)
        val btnLimpiarF: Button = findViewById(R.id.btnLimpiarF)
        val btnLimpiarK: Button = findViewById(R.id.btnLimpiarK)

        //Limpiar edit text celsius
        btnLimpiarC.setOnClickListener(){
            celsius.setText("")
        }
        //Limpiar edit text faren
        btnLimpiarF.setOnClickListener(){
            faren.setText("")
        }
        //Limpiar edit text kelvin
        btnLimpiarK.setOnClickListener(){
            kelvin.setText("")
        }

        //Accion de activar el boton celcius
        btnCelsius.setOnClickListener(){
            //Metodo para convertir de grados farenheit a Celcius
            if (!faren.text.isBlank() && kelvin.text.isBlank() && celsius.text.isBlank()){
                var temperaturaF: Double = 0.0
                temperaturaF = faren.text.toString().toDouble()
                val temperaturaC = fahrenheitToCelsius(temperaturaF)
                val formattedNumber = "%.2f".format(temperaturaF)
                val formattedNumber3 = "%.2f".format(temperaturaC)
                faren.setText(formattedNumber)
                celsius.setText(formattedNumber3)
            }
            // Metodo para convertir de grados Kelevin a grados celcius
            if(!kelvin.text.isBlank() && celsius.text.isBlank() && faren.text.isBlank()){
                var temperaturaK: Double = 0.0
                temperaturaK = kelvin.text.toString().toDouble()
                val temperaturaC = kelvinToCelsius(temperaturaK)
                val formattedNumber = "%.2f".format(temperaturaK)
                val formattedNumber3 = "%.2f".format(temperaturaC)
                kelvin.setText(formattedNumber)
                celsius.setText(formattedNumber3)
            }
        }

        //Accion de activar el boton Farenheit
        btnFar.setOnClickListener(){
            // Metodo para convertir de grados Celcius a grados Farenheit
            if (!celsius.text.isBlank() && kelvin.text.isBlank() && faren.text.isBlank()){
                var temperaturaC: Double = 0.0
                temperaturaC = celsius.text.toString().toDouble()
                val temperaturaF = celsiusToFahrenheit(temperaturaC)
                val formattedNumber = "%.2f".format(temperaturaF)
                val formattedNumber3 = "%.2f".format(temperaturaC)
                faren.setText(formattedNumber)
                celsius.setText(formattedNumber3)
            }
            // Metodo para convertir de grados Kelvin a Farenheit
            if(!kelvin.text.isBlank()&& celsius.text.isBlank() && faren.text.isBlank()){
                var temperaturaK: Double = 0.0
                temperaturaK = kelvin.text.toString().toDouble()
                val temperaturaF = kelvinToFahrenheit(temperaturaK)
                val formattedNumber = "%.2f".format(temperaturaK)
                val formattedNumber3 = "%.2f".format(temperaturaF)
                kelvin.setText(formattedNumber)
                faren.setText(formattedNumber3)
            }
        }

        //Accion de activar el boton Kelvin
        btnKelvin.setOnClickListener(){
            // Metodo para convertir de grados Celcius a Kelvin
            if (!celsius.text.isBlank() && faren.text.isBlank() && kelvin.text.isBlank()){
                var temperaturaC: Double = 0.0
                temperaturaC = celsius.text.toString().toDouble()
                val temperaturaK = celsiusToKelvin(temperaturaC)
                val formattedNumber = "%.2f".format(temperaturaK)
                val formattedNumber3 = "%.2f".format(temperaturaC)
                kelvin.setText(formattedNumber)
                celsius.setText(formattedNumber3)
            }
            // Metodo para convertir de grados farenheit a Kelvin
            if (!faren.text.isBlank() && celsius.text.isBlank() && kelvin.text.isBlank()){
                var temperaturaF: Double = 0.0
                temperaturaF = faren.text.toString().toDouble()
                val temperaturaC = fahrenheitToKelvin(temperaturaF)
                val formattedNumber = "%.2f".format(temperaturaF)
                val formattedNumber3 = "%.2f".format(temperaturaC)
                faren.setText(formattedNumber)
                kelvin.setText(formattedNumber3)
            }
        }
    }
    //Funciones para convertir los grados
    fun celsiusToFahrenheit(celsius: Double): Double {
        return celsius * 1.8 + 32.0
    }

    fun celsiusToKelvin(celsius: Double): Double {
        return celsius + 273.15
    }

    fun fahrenheitToCelsius(fahrenheit: Double): Double {
        return (fahrenheit - 32) * 5/9
    }

    fun fahrenheitToKelvin(fahrenheit: Double): Double {
        return (fahrenheit + 459.67) * 5/9
    }

    fun kelvinToCelsius(kelvin: Double): Double {
        return kelvin - 273.15
    }

    fun kelvinToFahrenheit(kelvin: Double): Double {
        return kelvin * 9/5 - 459.67
    }
}
