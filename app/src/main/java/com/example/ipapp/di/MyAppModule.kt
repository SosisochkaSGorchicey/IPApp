package com.example.ipapp.di

import com.example.ipapp.data.datasource.IPService
import com.example.ipapp.data.repository.IPRepositoryImpl
import com.example.ipapp.domain.repository.IPRepository
import com.example.ipapp.domain.usecases.GetIPDataUseCase
import com.example.ipapp.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MyAppModule {
    val module = module {
        single { provideRetrofitForMyApp() }
        single { provideRecipesServiceForMyApp(retrofit = get()) }

        single<IPRepository> { IPRepositoryImpl(ipService = get()) }

        single { GetIPDataUseCase(ipRepository = get()) }

        viewModel { MainViewModel(getIPDataUseCase = get()) }
    }

    private fun provideRetrofitForMyApp(): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://ipdb.ipcalc.co/ipdata/")
        .build()


    private fun provideRecipesServiceForMyApp(retrofit: Retrofit): IPService =
        retrofit.create(IPService::class.java)
}