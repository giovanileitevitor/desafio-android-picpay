package br.applabbs.data.repository

import br.applabbs.data.entity.User
import br.applabbs.infrastructure.net.Results

interface UserRepository {
    suspend fun getUsers(): Results<List<User>>
}