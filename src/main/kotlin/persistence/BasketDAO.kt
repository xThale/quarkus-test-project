package persistence

import domain.model.Product
import org.bson.codecs.pojo.annotations.BsonId
import java.util.UUID

data class BasketDAO(
    @BsonId val id: UUID,
    val items: List<Product>
) : DAO<UUID>