package br.applabbs.data.model

import br.applabbs.data.mockedUserSchema
import org.junit.Assert
import org.junit.Test

class UserSchemaTest {

    @Test
    fun `assert that UserSchema has valid data`(){
        val expected = UserSchema(
                            id = 2,
                            img = "https://randomuser.me/api/portraits/men/9.jpg",
                            name = "Leite Vitor",
                            username = "@LeiteVitor")

        val result = mockedUserSchema()
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `assert that UserSchema is non-null`(){
        val data = UserSchema(
                        id = 2,
                        img = "https://randomuser.me/api/portraits/men/9.jpg",
                        name = "Leite Vitor",
                        username = "@LeiteVitor")

        Assert.assertNotNull(data)
    }
}