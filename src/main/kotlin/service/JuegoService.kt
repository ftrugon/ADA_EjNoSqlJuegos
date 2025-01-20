package org.example.service

import com.mongodb.client.model.Filters
import com.mongodb.client.model.Updates
import org.bson.Document
import org.example.collectionManager.JuegosCollectionManager
import org.example.entradaSalida.consolaManager
import org.example.model.Juego
import java.util.*

class JuegoService(val jm: JuegosCollectionManager,val consolaManager: consolaManager) {

    fun getJuegos(): List<Juego> {
        return jm.getJuegos()
    }

    fun getJuegosByGenero():List<Juego> {
        consolaManager.showText("Escribe el genero que quieres buscar:")
        val genero = consolaManager.readText()
        return jm.getJuegos().filter { it.genero.contains(genero) }.sortedBy { it.titulo }
    }

    fun addJuego(){

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
        val fecha = try {
            Date(consolaManager.readText())
        }catch (e:Exception){
            consolaManager.showText("Error al insertar la fecha, se pondra la fehca actual")
            Date()
        }


        jm.addJuego(Juego(titulo,genero,precio,fecha))
    }

    fun delJuegoByGenero(){
        consolaManager.showText("Introduce el genero del juego a eliminar: ")
        val genero = consolaManager.readText()
        val filter = Filters.eq("genero",genero)
        jm.delJuegos(filter)
    }

    fun modJuego(){
        consolaManager.showText("Introduce el titulo del juego a modificar: ")
        val titulo = readln()
        jm.getJuegoByTitulo(titulo) ?: throw IllegalArgumentException("El juego introducido no existe")

        consolaManager.showText("Introduce el genero del juego a modificar: ")
        val genero = consolaManager.readText()

        consolaManager.showText("Introduce el precio del juego a modificar: ")
        val precio = consolaManager.readText().toDoubleOrNull() ?: 0.0

        consolaManager.showText("Introduce la fecha de lanzamiento del juego a modificar(mm/dd/aaaa): ")
        val fecha = try {
            Date(consolaManager.readText())
        }catch (e:Exception){
            consolaManager.showText("Error al insertar la fecha, se pondra la fehca actual")
            Date()
        }

        val filter = Filters.eq("titulo",titulo)
        val updates = Updates.combine(
            Updates.set("genero",genero),
            Updates.set("precio",precio),
            Updates.set("fecha_lanzamiento",fecha)
        )

        jm.modJuego(filter, updates)

    }

}