package persistence

import domain.model.Basket
import domain.model.Customer

object BasketPersistenceMapper : Mapper<BasketDAO, Basket> {

    override fun mapToModel(dao: BasketDAO): Basket =
        Basket(
            basketId = dao.id,
            customer = Customer(),
            items = dao.items
        )

    override fun mapToDao(domainObject: Basket): BasketDAO =
        BasketDAO(
            id = domainObject.basketId,
            items = domainObject.items
        )

}

