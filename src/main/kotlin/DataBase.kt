package org.example

import com.mongodb.client.MongoClients
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import com.sun.jdi.ClassType
import io.github.cdimascio.dotenv.Dotenv
import io.github.cdimascio.dotenv.dotenv
import org.bson.Document
import org.example.model.Juego
import kotlin.reflect.KClass

object DataBase {

    private val db_name = "fran_trujillo_db"

    private val collJuegosName = "coll_juegos"


    private val db: MongoDatabase by lazy {

        val dotenv: Dotenv = dotenv()

        // guardo la variable en una conexion
        val urlMongo = dotenv["URL_MONGODB"]

        // conexion al cluster
        val cluster = MongoClients.create(urlMongo)

        // bd
        cluster.getDatabase(db_name)

    }

    /*
    fun <T:Any>getCollection(collectionName:String,classType: Class<T>?): MongoCollection<T>? {

        print(classType)

        if (classType != null) {
            return db.getCollection(collectionName,classType)
        }else{
            return db.getCollection(collectionName)
        }
    }*/


    fun juegosGetCollection(): MongoCollection<Juego> {
        return db.getCollection(collJuegosName,Juego::class.java)
    }
}