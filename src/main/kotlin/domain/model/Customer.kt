package domain.model

import java.time.Instant

data class Customer(
    val salutation: String? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    val address: Address? = null,
    val birthDate: Instant? = null
)