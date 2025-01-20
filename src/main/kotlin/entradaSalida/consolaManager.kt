package org.example.entradaSalida

class consolaManager {

    fun showText(message: String,nextLine:Boolean = false){
        if (nextLine){
            println(message)
        }else print(message)
    }


    fun readText(): String {
        return readln()
    }

}