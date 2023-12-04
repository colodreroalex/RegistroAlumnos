package com.example.registroalumnos

import android.os.Bundle
import android.widget.Toast
import com.example.registroalumnos.database.Alumno
import com.example.registroalumnos.database.MiAlumnoApp
import com.example.registroalumnos.database.MiAlumnoApp.Companion.database
import com.example.registroalumnos.databinding.ActivityDeleteBinding
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



        binding.buttonBorrar.setOnClickListener() {
            var nombreAlumno = binding.tbNombreBorrar.text.toString()
            // Validaciones
            if (nombreAlumno.isEmpty())
            {
                Toast.makeText(this, "No puede haber campos vacíos", Toast.LENGTH_SHORT).show()
            }
            else
            {
                var alumno = Alumno(nombre = nombreAlumno)

                deleteAlumno(binding.tbNombreBorrar.text.toString())
                Toast.makeText(this, "Alumno eliminado", Toast.LENGTH_SHORT).show()

            }
        }


    }

    fun deleteAlumno(alumno: String){
        CoroutineScope(Dispatchers.IO).launch{
            val alumno = MiAlumnoApp.database.alumnoDao().obteneralumnopornombre(alumno)

            val listaAlumnos = alumno[0]
            database.alumnoDao().deleteLista(listaAlumnos)


        }
    }

}