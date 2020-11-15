package br.applabbs.data.di

import br.applabbs.data.entity.User
import br.applabbs.data.mapper.UserResponseToListUser
import br.applabbs.data.model.UserSchema
import br.applabbs.infrastructure.net.Mapper
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