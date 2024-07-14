package com.example.ramos20200043ef202401

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegistroEntrenamientos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registro_entrenamientos)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val spEquipoVisitante: Spinner = findViewById(R.id.spEquipoVisitante)
        val spEquipoLocal: Spinner = findViewById(R.id.spEquipoLocal)
        val etCuotaLocal: EditText = findViewById(R.id.etCuotaLocal)
        val etCuotaEmpate: EditText = findViewById(R.id.etCuotaEmpate)
        val etCuotaVista: EditText = findViewById(R.id.etCuotaVisita)
        val btGuardar : Button = findViewById(R.id.btRegistrar)
        val btListadoEntrenamientos: Button = findViewById(R.id.btListaEntrenamientos2)
        val btRegistrarEquipos: Button = findViewById(R.id.btRegistrarEquipos)


        btRegistrarEquipos.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btListadoEntrenamientos.setOnClickListener {
            val intent = Intent(this, ListadoEntrenamientos::class.java)
            startActivity(intent)
        }




    }
}