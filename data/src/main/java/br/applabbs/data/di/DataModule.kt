package br.applabbs.data.di

import br.applabbs.data.mapper.UserResponseToListUser
import org.koin.core.qualifier.named
import org.koin.dsl.module

object DataModule {

    const val userResponseToUser = "UserResponseToUser"

    val dataModule = module {

        single(named(userResponseToUser)) {
            UserResponseToListUser()
        }
    }
}