package org.example

import com.mongodb.client.MongoClients
import io.github.cdimascio.dotenv.Dotenv
import io.github.cdimascio.dotenv.dotenv
import org.bson.Document
import org.example.collectionManager.JuegosCollectionManager
import org.example.model.Juego
import org.example.service.JuegoService
import javax.xml.crypto.Data

fun main() {

    val coll = DataBase.juegosGetCollection()
    val jm = JuegosCollectionManager(coll)

    val service = JuegoService(jm)
    service.delJuegoByGenero()

}