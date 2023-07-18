package persistence

import com.mongodb.client.MongoClient
import com.mongodb.client.MongoDatabase
import jakarta.enterprise.context.ApplicationScoped
import org.litote.kmongo.KMongo

@ApplicationScoped
class MongoDB(
    private val client: MongoClient = KMongo.createClient(),
    val database: MongoDatabase = client.getDatabase("basket")
) : MongoDatabase by database