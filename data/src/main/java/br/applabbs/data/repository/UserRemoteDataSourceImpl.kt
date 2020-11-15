package br.applabbs.data.repository

import br.applabbs.data.entity.User
import br.applabbs.data.mapper.UserResponseToListUser
import br.applabbs.data.service.PicPayEndpointService
import br.applabbs.infrastructure.net.Results
import br.applabbs.infrastructure.net.create

class UserRemoteDataSourceImpl(
    private val picPayServiceApi: PicPayEndpointService,
    private val mapperUser: UserResponseToListUser
) : UserRemoteDataSource {

    override suspend fun getUsersRemote(): Results<List<User>>{
        return picPayServiceApi.getUsers().create(mapperUser)
    }
}