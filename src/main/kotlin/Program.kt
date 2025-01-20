package org.example

import org.example.collectionManager.JuegosCollectionManager
import org.example.entradaSalida.consolaManager
import org.example.service.JuegoService

class Program(val js: JuegoService,val console:consolaManager) {


    fun showOptions(){
        console.showText("",true)
        console.showText("Opciones:",true)
        console.showText("1. Mostrar todos los juegos:",true)
        console.showText("2. Mostrar juegos por genero:",true)
        console.showText("3. Añadir juego:",true)
        console.showText("4. Eliminar juegos por genero:",true)
        console.showText("5. Modificar juego por titulo:",true)
        console.showText("6. Salir del programa:",true)
        console.showText("Elige: ")
    }

    fun startProgram(){
        var op = 0
        do{
            showOptions()
            op = console.readText().toIntOrNull() ?: 0

            try {
                when(op){
                    1->{
                        console.showText("----------JUEGOS----------:",true)
                        js.getJuegos().forEach{
                            console.showText(it.toString(),true)
                        }
                    }
                    2->{
                        console.showText("----------JUEGOS----------:",true)
                        js.getJuegosByGenero().forEach{
                            console.showText(it.toString(),true)
                        }
                    }
                    3->{
                        js.addJuego()
                    }
                    4->{
                        js.delJuegoByGenero()
                    }
                    5->{
                        js.modJuego()
                    }
                    6->{
                        console.showText("Saliendo del programa")
                    }
                    else ->{
                        console.showText("OPCION NO VALIDA",true)
                    }
                }
            }catch (e:Exception){
                console.showText("**ERROR**:${e.message}")
            }



        }while (op != 6)
    }

}