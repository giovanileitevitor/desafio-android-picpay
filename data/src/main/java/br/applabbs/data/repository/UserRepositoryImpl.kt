package br.applabbs.data.repository

import br.applabbs.data.entity.User
import br.applabbs.infrastructure.net.Results

class UserRepositoryImpl(
    private val userRemoteDataSource: UserRemoteDataSource
) : UserRepository {

    override suspend fun getUsers(): Results<List<User>> {
        return userRemoteDataSource.getUsersRemote()
    }
}