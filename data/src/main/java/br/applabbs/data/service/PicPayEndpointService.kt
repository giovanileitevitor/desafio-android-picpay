package br.applabbs.data.service

import br.applabbs.data.entity.User
import retrofit2.http.GET
import retrofit2.Response

interface PicPayEndpointService {

    @GET("users")
    suspend fun getUsers(): Response<List<User>>

}