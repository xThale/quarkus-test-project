package controller

import domain.model.Address
import domain.model.Basket
import domain.model.CountryCode
import domain.model.Customer
import domain.service.BasketService
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import org.jboss.resteasy.reactive.RestPath
import java.time.Instant
import java.util.UUID

@Path("/basket")
class BasketController(
    val basketService: BasketService
) {

    @GET
    @Path("/{basketId}")
    @Produces(MediaType.APPLICATION_JSON)
    fun getBasket(@RestPath basketId: UUID) = Basket(
        basketId,
        Customer("", "", "", Address("", "", "", "", CountryCode.DE), Instant.now()),
        emptyList()
    )

    @POST
    @Path("/{basketId}")
    @Produces(MediaType.APPLICATION_JSON)
    fun createBasket() = basketService.createBasket()


}