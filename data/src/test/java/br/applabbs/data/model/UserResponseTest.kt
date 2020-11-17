package br.applabbs.data.model

import br.applabbs.data.mockedUserResponse
import org.junit.Assert
import org.junit.Test

class UserResponseTest{

    @Test
    fun `assert that UserResponse List is not null`(){
        val data = mockedUserResponse()
        Assert.assertNotNull(data)
    }

    @Test
    fun `assert that UserResponse List has valid data`(){
        val data = mockedUserResponse()
        val datasize = data.size
        Assert.assertNotNull(data)
        Assert.assertEquals(datasize, 1)
    }
}