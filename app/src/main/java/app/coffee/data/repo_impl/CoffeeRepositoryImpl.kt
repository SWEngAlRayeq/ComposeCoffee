package app.coffee.data.repo_impl

import app.coffee.data.remote.CoffeeApi
import app.coffee.domain.model.CoffeeImage
import app.coffee.domain.repo.CoffeeRepository
import javax.inject.Inject

class CoffeeRepositoryImpl @Inject constructor(
    private val coffeeApi: CoffeeApi
) : CoffeeRepository {
    override suspend fun getCoffee(): CoffeeImage {
        val response = coffeeApi.getCoffee()
        return CoffeeImage(imageUrl = response.file)
    }

}