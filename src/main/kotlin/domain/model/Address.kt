package domain.model

data class Address(
    val street: String,
    val houseNumber: String,
    val city: String,
    val postalCode: String,
    val countryCode: CountryCode
)