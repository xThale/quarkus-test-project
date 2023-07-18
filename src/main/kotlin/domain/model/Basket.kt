package domain.model

import java.util.UUID

data class Basket(
    val basketId: UUID,
    val customer: Customer,
    val items: List<Product>
)