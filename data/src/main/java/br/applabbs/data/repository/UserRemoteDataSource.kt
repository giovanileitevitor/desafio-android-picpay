package br.applabbs.data.repository

import br.applabbs.data.entity.User
import br.applabbs.infrastructure.net.Results

interface UserRemoteDataSource {
    suspend fun getUsersRemote(): Results<List<User>>
}