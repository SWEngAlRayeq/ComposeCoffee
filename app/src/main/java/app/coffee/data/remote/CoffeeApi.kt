package app.coffee.data.remote

import app.coffee.data.model.CoffeeResponse
import retrofit2.http.GET

interface CoffeeApi {

    @GET("random.json")
    suspend fun getCoffee(): CoffeeResponse

}