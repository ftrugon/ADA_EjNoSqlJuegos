package org.example.service

import org.example.collectionManager.JuegosCollectionManager
import org.example.model.Juego

class JuegoService(val jm: JuegosCollectionManager) {

    fun getJuegos(): List<Juego> {
        return jm.getJuegos()
    }

    fun getJuegoByGenero(){
        //Todo: buscar juegos del mismo genero y ordenar por titulo

    }

    fun addJuego(j:Juego){
        //Todo: pedir el juego y saber si existe, solo es obligatorio el nombre

        jm.addJuego(j)
    }


    fun delJuegoByGenero(genero:String){
        //Todo: eliminar a todos los juegos con ese genero, pasarle el filtro al jm


    }


}