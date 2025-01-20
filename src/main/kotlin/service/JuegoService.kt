package org.example.service

import com.mongodb.client.model.Filters
import com.mongodb.client.model.Updates
import org.example.collectionManager.JuegosCollectionManager
import org.example.entradaSalida.consolaManager
import org.example.model.Juego
import java.util.*

class JuegoService(val jm: JuegosCollectionManager,val consolaManager: consolaManager) {

    fun getJuegos(): List<Juego> {
        return jm.getJuegos()
    }

    fun getJuegosByGenero():List<Juego> {
        //Todo: buscar juegos del mismo genero y ordenar por titulo
        val genero = readln()
        return jm.getJuegos().filter { it.genero.contains(genero) }.sortedBy { it.titulo }
    }

    fun addJuego(){
        //Todo: pedir el juego y saber si existe, solo es obligatorio el nombre

        consolaManager.showText("Introduce el titulo del juego a introducir: ")
        val titulo = readln()
        val exist = jm.getJuegoByTitulo(titulo)
        if (exist != null){
            throw IllegalArgumentException("El juego introducido ya existe")
        }

        consolaManager.showText("Introduce el genero del juego a introducir: ")
        val genero = consolaManager.readText()

        consolaManager.showText("Introduce el precio del juego a introducir: ")
        val precio = consolaManager.readText().toDoubleOrNull() ?: 0.0

        consolaManager.showText("Introduce la fecha de lanzamiento del juego a introducir(mm/dd/aaaa): ")
        val fecha = Date(consolaManager.readText())

        jm.addJuego(Juego(titulo,genero,precio,fecha))
    }

    fun delJuegoByGenero(){
        //Todo: eliminar a todos los juegos con ese genero, pasarle el filtro al jm
        val genero = readln()
        val filter = Filters.eq("genero",genero)
        jm.delJuegos(filter)
    }

    fun modJuego(){
        consolaManager.showText("Introduce el titulo del juego a modificar: ")
        val titulo = readln()
        val exist = jm.getJuegoByTitulo(titulo) ?: throw IllegalArgumentException("El juego introducido no existe")

        consolaManager.showText("Introduce el genero del juego a modificar: ")
        val genero = consolaManager.readText()

        consolaManager.showText("Introduce el precio del juego a modificar: ")
        val precio = consolaManager.readText().toDoubleOrNull() ?: 0.0

        consolaManager.showText("Introduce la fecha de lanzamiento del juego a modificar(mm/dd/aaaa): ")
        val fecha = Date(consolaManager.readText())

        val filter = Filters.eq("titulo",titulo)
        val update = Updates.

    }

}