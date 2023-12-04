package com.example.registroalumnos.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Alumno::class), version = 1)
abstract class DBAlumno : RoomDatabase() {
    abstract fun alumnoDao(): AlumnoDao // Devuelve el DAO
}