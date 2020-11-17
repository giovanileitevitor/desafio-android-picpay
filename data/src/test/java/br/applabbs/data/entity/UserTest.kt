package br.applabbs.data.entity

import br.applabbs.data.mockedUser
import org.junit.Test
import org.junit.Assert.*

class UserTest {

    @Test
    fun `assert that User has valid data`() {
        val expected = User(id = 1,
                            img = "https://randomuser.me/api/portraits/men/9.jpg",
                            name = "Giovani Leite",
                            username = "@GiovaniLeite"
        )

        val result = mockedUser()

        assertEquals(expected, result)
    }

    @Test
    fun `assert that User is non-null`(){
        val data = User(id = 1,
                        img = "https://randomuser.me/api/portraits/men/9.jpg",
                        name = "Giovani Leite",
                        username = "@GiovaniLeite"
        )

        assertNotNull(data)
    }
}