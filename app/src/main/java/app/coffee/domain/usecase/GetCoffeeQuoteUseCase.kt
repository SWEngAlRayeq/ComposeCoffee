package app.coffee.domain.usecase

import app.coffee.domain.model.CoffeeImage
import app.coffee.domain.repo.CoffeeRepository
import javax.inject.Inject

class GetCoffeeQuoteUseCase @Inject constructor(
    private val coffeeRepository: CoffeeRepository
) {
    suspend operator fun invoke(): CoffeeImage {
        return coffeeRepository.getCoffee()
    }
}