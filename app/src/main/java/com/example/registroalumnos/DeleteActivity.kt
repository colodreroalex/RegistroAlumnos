package com.example.registroalumnos

import androidx.appcompat.app.AppCompatActivity
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
            deleteListaAlumnos(
                Alumno(
                    nombre = binding.tbNombreBorrar.text.toString(),
                )
            )
        }
    }

    private fun deleteListaAlumnos(alumno: Alumno){
        CoroutineScope(Dispatchers.IO).launch {
            val position = listaAlumnos.indexOf(alumno)
            MiAlumnoApp.database.alumnoDao().deleteAlumno(alumno)
            listaAlumnos.remove(alumno)

        }
    }
}