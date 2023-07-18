package persistence

interface Mapper<DAO, DomainObject> {

    fun mapToModel(dao: DAO): DomainObject

    fun mapToDao(domainObject: DomainObject): DAO
}
