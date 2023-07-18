package domain.model

import java.util.UUID

data class Product(
    val id: UUID,
    val name: String,
    val price: Double
)