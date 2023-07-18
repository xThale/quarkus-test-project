package domain.service

import domain.model.Address
import domain.model.Basket
import domain.model.CountryCode
import domain.model.Customer
import jakarta.enterprise.context.ApplicationScoped
import persistence.BasketDAO
import persistence.BasketRepository
import java.time.Instant
import java.util.UUID

@ApplicationScoped
class BasketService(
    val basketRepository: BasketRepository
) {

    fun getBasket(id: UUID): Basket {
        return basketRepository.findOne(id) ?: throw IllegalArgumentException()
    }

    fun createBasket(): Basket {
        val basket = Basket(
            UUID.randomUUID(),
            Customer("", "", "", Address("", "", "", "", CountryCode.DE), Instant.now()),
            emptyList()
        )

        return basketRepository.insert(basket)
    }

}