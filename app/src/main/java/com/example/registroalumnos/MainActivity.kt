package com.example.registroalumnos


import android.os.Bundle

import com.example.registroalumnos.database.Alumno

import com.example.registroalumnos.database.MiAlumnoApp
import com.example.registroalumnos.databinding.ActivityMainBinding

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ActivityWithMenus() {

    lateinit var binding: ActivityMainBinding
    lateinit var listaAlumnos: MutableList<Alumno>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listaAlumnos = ArrayList()

        binding.botonAnadir.setOnClickListener() {
            addAlumno(
                Alumno(
                    nombre = binding.tvNombre.text.toString(),
                    apellidos = binding.tvApellidos.text.toString(),
                    curso = binding.tvCurso.text.toString()
                )
            )
        }

    }

    private fun addAlumno(alumno: Alumno) {
        CoroutineScope(Dispatchers.IO).launch {
            MiAlumnoApp.database.alumnoDao().addAlumno(alumno)
        }
    }





}


