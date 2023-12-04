package com.example.registroalumnos

import android.os.Bundle
import androidx.room.Delete
import com.example.registroalumnos.database.Alumno
import com.example.registroalumnos.database.MiAlumnoApp
import com.example.registroalumnos.databinding.ActivityDeleteBinding
import com.example.registroalumnos.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DeleteActivity : ActivityWithMenus() {

    lateinit var binding: ActivityDeleteBinding
    lateinit var listaAlumnos: MutableList<Alumno>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeleteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listaAlumnos = ArrayList()

        binding.buttonBorrar.setOnClickListener() {
            deleteListaAlumnos(binding.tbNombreBorrar.text.toString())
        }
    }

    private fun deleteListaAlumnos(alumno: String) {
        CoroutineScope(Dispatchers.IO).launch {
           val alumno = MiAlumnoApp.database.alumnoDao().obtenerAlumnoPorNombre(alumno)
            runOnUiThread(){
                val lista = alumno[0]
                MiAlumnoApp.database.alumnoDao()
            }
        }
    }

}