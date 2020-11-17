package br.applabbs.data

import br.applabbs.data.model.EmptyRequest
import br.applabbs.data.model.UserSchema
import br.applabbs.data.entity.User as User

internal fun mockedUser() : User {
    return User(
        id = 1,
        img = "https://randomuser.me/api/portraits/men/9.jpg",
        name = "Giovani Leite",
        username = "@GiovaniLeite"
    )
}

internal fun mockedUserSchema() : UserSchema{
    return UserSchema(
        id = 2,
        img = "https://randomuser.me/api/portraits/men/9.jpg",
        name = "Leite Vitor",
        username = "@LeiteVitor"
    )
}

internal fun mockedUserResponse() : List<UserSchema>{
    return arrayListOf(
        UserSchema(id = 1,
                    img = "https://randomuser.me/api/portraits/men/9.jpg",
                    name = "Giovani Leite",
                    username = "@GiovaniLeite")
    )
}

internal fun mockedEmptyRequest() : EmptyRequest{
    return EmptyRequest(id = 10)
}