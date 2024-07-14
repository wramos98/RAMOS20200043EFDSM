package com.example.ramos20200043ef202401

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ramos20200043ef202401.model.EquipoModel
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etNombreEquipo: EditText = findViewById(R.id.etNombreEquipo)
        val etUrlEscudoEquipo: EditText = findViewById(R.id.etUrlEscudoEquipo)
        val btGuardarEquipo: Button = findViewById(R.id.btGuardarEquipo)
        val btRegistrarEntrenamientos: Button = findViewById(R.id.btRegistrarEntrenamientos)
        val btListadoEntrenamientos: Button = findViewById(R.id.btListadoEntrenamientos)

        val db = FirebaseFirestore.getInstance()

        btGuardarEquipo.setOnClickListener {
            val nombre = etNombreEquipo.text.toString()
            val url = etUrlEscudoEquipo.text.toString()

            val equipoModel = EquipoModel(nombre,url)

            db.collection("equipos").add(equipoModel)
                .addOnCompleteListener{
                    Snackbar.make(
                        findViewById(android.R.id.content)
                        , "Se registro el equipo satisfactoriamente"
                        , Snackbar.LENGTH_LONG
                    ).show()


                    etNombreEquipo.text.clear()
                    etUrlEscudoEquipo.text.clear()

                }.addOnFailureListener {error->
                    Snackbar.make(
                        findViewById(android.R.id.content)
                        , "Ocurrió un error al registrar: ${error.message}"
                        , Snackbar.LENGTH_LONG
                    ).show()
                }




        }

        btRegistrarEntrenamientos.setOnClickListener {
            val intent = Intent(this, RegistroEntrenamientos::class.java)
            startActivity(intent)
        }

        btListadoEntrenamientos.setOnClickListener {
            val intent = Intent(this, ListadoEntrenamientos::class.java)
            startActivity(intent)
        }

    }
}