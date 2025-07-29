package app.coffee.di

import app.coffee.data.remote.CoffeeApi
import app.coffee.data.repo_impl.CoffeeRepositoryImpl
import app.coffee.domain.repo.CoffeeRepository
import app.coffee.domain.usecase.GetCoffeeQuoteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideCoffeeApi(): CoffeeApi {
        val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl("https://coffee.alexflipnote.dev/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoffeeApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoffeeRepository(api: CoffeeApi): CoffeeRepository {
        return CoffeeRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideGetCoffeeQuoteUseCase(repository: CoffeeRepository): GetCoffeeQuoteUseCase {
        return GetCoffeeQuoteUseCase(repository)
    }


}