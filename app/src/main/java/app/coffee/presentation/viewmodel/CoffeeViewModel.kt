package app.coffee.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.coffee.domain.model.CoffeeImage
import app.coffee.domain.usecase.GetCoffeeQuoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoffeeViewModel @Inject constructor(
    private val getCoffeeQuoteUseCase: GetCoffeeQuoteUseCase
) : ViewModel() {

    var coffeeState by mutableStateOf<CoffeeImage?>(null)
        private set

    init {
        fetchCoffeeImage()
    }

    fun fetchCoffeeImage() {
        viewModelScope.launch {
            coffeeState = getCoffeeQuoteUseCase()
        }
    }

}