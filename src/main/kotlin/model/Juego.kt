package org.example.model

import java.util.*

data class Juego(
    val titulo:String,
    val genero:String,
    val precio:Double,
    val fecha_lanzamiento: Date
){

    override fun toString(): String {
        return "titulo: $titulo, genero: $genero, precio: $precio, fecha_lanzamiento: $fecha_lanzamiento"
    }
}
