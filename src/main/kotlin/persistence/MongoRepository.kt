package persistence

import com.mongodb.client.MongoCollection
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import kotlin.reflect.KProperty1

interface MongoRepository<DAO: persistence.DAO<ID>, DomainObject, ID> {

    val mapper: Mapper<DAO, DomainObject>

    val collection: MongoCollection<DAO>

    fun insert(entity: DomainObject): DomainObject {
        val dao = mapper.mapToDao(entity)
        val result = collection.insertOne(dao)

        if (!result.wasAcknowledged()) {
            throw IllegalStateException()
        }

        return entity
    }

    val doaId: KProperty1<DAO, ID>

    fun findOne(id: ID): DomainObject? {
        val dao = collection.findOne(doaId eq id)
        return dao?.let { mapper.mapToModel(it) }
    }


}