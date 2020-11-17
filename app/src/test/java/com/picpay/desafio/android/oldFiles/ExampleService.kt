package com.picpay.desafio.android.oldFiles

import br.applabbs.data.entity.User
import br.applabbs.data.service.PicPayEndpointServiceTest

class ExampleService(
    private val service: PicPayEndpointServiceTest
) {

    fun example(): List<User> {
        val users = service.getUsers().execute()

        return users.body() ?: emptyList()
    }
}