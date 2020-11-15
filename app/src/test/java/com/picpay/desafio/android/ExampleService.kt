package com.picpay.desafio.android

import br.applabbs.data.entity.User
import br.applabbs.data.model.response.User
import br.applabbs.data.service.PicPayEndpointService

class ExampleService(
    private val service: PicPayEndpointService
) {

    fun example(): List<User> {
        val users = service.getUsers().execute()

        return users.body() ?: emptyList()
    }
}