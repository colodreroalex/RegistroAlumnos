package com.example.registroalumnos.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
@Dao
interface AlumnoDao {
    @Query("SELECT * FROM alumno")
    fun getAllElements(): MutableList<Alumno>

    @Query("SELECT * FROM alumno WHERE id like :id")
    fun getElementById(id: Long): Alumno

    //Query para eliminar todos los elementos por nombre de la tabla
    @Query("DELETE FROM alumno WHERE nombre like :nombre")
    fun deleteElementByNombre(nombre: String): Int


    @Insert
    fun addAlumno(elemento: Alumno):Long

    @Update
    fun updateAlumno(elemento: Alumno):Int

    @Delete
    fun deleteAlumno(elemento: Alumno):Int
}