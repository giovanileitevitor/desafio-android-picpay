package br.applabbs.data.mapper

import br.applabbs.data.entity.User
import br.applabbs.data.model.UserResponse
import br.applabbs.data.model.UserSchema
import br.applabbs.infrastructure.net.Mapper

class UserResponseToListUser() : Mapper<List<UserSchema>, List<User>>() {

    override fun transform(item: List<UserSchema>) : List<User>{
        val users = mutableListOf<User>()

        item.forEach{
            users.add(
                User(
                    img = it.img,
                    name = it.name,
                    id = it.id,
                    username = it.username
                )
            )
        }

        return users
    }
}