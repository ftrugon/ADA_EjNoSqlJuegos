package org.example.collectionManager

import com.mongodb.client.MongoCollection
import org.example.model.Juego

class JuegosCollectionManager(val collection: MongoCollection<Juego>) {

    fun getJuegos():List<Juego> {
        return collection.find().toList()
    }

    fun addJuego(j:Juego){
        collection.insertOne(j)
    }


}