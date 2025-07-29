package app.coffee.domain.repo

import app.coffee.domain.model.CoffeeImage

interface CoffeeRepository {
        suspend fun getCoffee(): CoffeeImage
}