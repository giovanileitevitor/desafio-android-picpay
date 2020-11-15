package com.picpay.desafio.android.di

import br.applabbs.data.di.DataModule.userResponseToUser
import br.applabbs.data.repository.UserRemoteDataSource
import br.applabbs.data.repository.UserRemoteDataSourceImpl
import br.applabbs.data.repository.UserRepository
import br.applabbs.data.repository.UserRepositoryImpl
import br.applabbs.data.service.PicPayEndpointService
import br.applabbs.infrastructure.net.Network
import br.applabbs.infrastructure.net.NetworkImpl
import br.applabbs.infrastructure.net.RetrofitBuild.makeService
import com.picpay.desafio.android.BuildConfig
import com.picpay.desafio.android.viewModel.MainViewModel
import com.picpay.desafio.android.viewModel.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

object AppModules {

    const val abvService = "AbvService"

    val serviceModules = module {
        single(named(abvService)) { makeService<PicPayEndpointService>(BuildConfig.BASE_URL) }
        viewModel { SplashViewModel() }
        viewModel { MainViewModel(get()) }
    }

    val netModules = module {
        single<Network> { NetworkImpl(get()) }
    }

    val dataSourceModules = module {
        single<UserRemoteDataSource> {
            UserRemoteDataSourceImpl(
                get(named(abvService)),
                get(named(userResponseToUser))
            )
        }

        single<UserRepository> {
            UserRepositoryImpl(
                get()
            )
        }
    }
}