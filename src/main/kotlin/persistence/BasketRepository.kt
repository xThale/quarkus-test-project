package persistence

import com.mongodb.client.MongoCollection
import domain.model.Basket
import io.quarkus.arc.DefaultBean
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.ws.rs.Produces
import org.litote.kmongo.getCollection
import java.util.UUID
import kotlin.reflect.KProperty1

@ApplicationScoped
class BasketRepository(
    mongoDB: MongoDB,
    override val mapper: Mapper<BasketDAO, Basket> = BasketPersistenceMapper,
    override val doaId: KProperty1<BasketDAO, UUID> = BasketDAO::id
) : MongoRepository<BasketDAO, Basket, UUID> {

    override val collection: MongoCollection<BasketDAO> = mongoDB.getCollection<BasketDAO>("basket")

}