package com.example.registroalumnos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.registroalumnos.database.Alumno
import com.example.registroalumnos.databinding.ActivityMainBinding
import com.example.registroalumnos.databinding.ActivityUpdateBinding

class UpdateActivity : ActivityWithMenus() {

    lateinit var binding: ActivityUpdateBinding
    lateinit var listaAlumnos: MutableList<Alumno>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}