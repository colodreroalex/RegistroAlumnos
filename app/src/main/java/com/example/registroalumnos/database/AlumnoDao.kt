package com.example.registroalumnos.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
@Dao
interface AlumnoDao {
    @Insert
    fun addAlumno(alumno: Alumno):Long


    @Query("SELECT * FROM alumno WHERE nombre LIKE :nombre")
    fun obteneralumnopornombre(nombre:String): MutableList<Alumno>

    @Update
    fun updateLista(alumno: Alumno)

    @Delete
    fun deleteLista(alumno: Alumno)



}