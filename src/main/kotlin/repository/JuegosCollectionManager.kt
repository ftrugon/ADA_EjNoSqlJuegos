package org.example.collectionManager

import com.mongodb.client.MongoCollection
import com.mongodb.client.model.Filters
import org.bson.conversions.Bson
import org.example.model.Juego
import java.util.logging.Filter

class JuegosCollectionManager(val collection: MongoCollection<Juego>) {


    fun getJuegoByTitulo(titulo:String): Juego? {
        val filter = Filters.eq("titulo", titulo)
        return collection.find(filter).first()
    }

    fun getJuegos():List<Juego> {
        return collection.find().toList()
    }

    fun addJuego(j:Juego){
        collection.insertOne(j)
    }

    fun delJuegos(filter: Bson) {
        collection.deleteMany(filter)
    }

    fun modJuego(filter: Bson,update: Bson) {
        collection.updateOne(filter,update)
    }

}