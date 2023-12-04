package com.example.registroalumnos

import android.os.Bundle
import android.widget.Toast
import com.example.registroalumnos.database.Alumno
import com.example.registroalumnos.database.MiAlumnoApp
import com.example.registroalumnos.databinding.ActivityUpdateBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UpdateActivity : ActivityWithMenus() {

    lateinit var binding: ActivityUpdateBinding
    lateinit var listaAlumnos: MutableList<Alumno>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonActualizar.setOnClickListener() {
            var nombreAlumno = binding.tbActualizarNombre.text.toString()
            var cursoAlumno = binding.tbActualizarCurso.text.toString()

            // Validaciones
            if (nombreAlumno.isEmpty())
            {
                Toast.makeText(this, "No puede haber campos vacíos", Toast.LENGTH_SHORT).show()
            }
            else
            {

                updateAlumno(nombreAlumno, cursoAlumno)
                Toast.makeText(this, "Alumno eliminado", Toast.LENGTH_SHORT).show()
        }
    }



    }

     fun updateAlumno(nombreAlumno: String, cursoAlumno: String) {
        CoroutineScope(Dispatchers.IO).launch{
            val alumno = MiAlumnoApp.database.alumnoDao().obteneralumnopornombre(nombreAlumno)

            val listaAlumnos = alumno[0]
            listaAlumnos.curso = cursoAlumno
            MiAlumnoApp.database.alumnoDao().updateLista(listaAlumnos)


        }
    }
}
