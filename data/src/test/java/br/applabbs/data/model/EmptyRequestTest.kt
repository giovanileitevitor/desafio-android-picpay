package br.applabbs.data.model

import br.applabbs.data.mockedEmptyRequest
import org.junit.Assert
import org.junit.Test

class EmptyRequestTest{

    @Test
    fun `assert that EmptyRequest has valid data`(){
        val expected = EmptyRequest(id = 10)
        val result = mockedEmptyRequest()
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `assert that EmptyRequest is non-null`(){
        val data = EmptyRequest(id = 10)
        Assert.assertNotNull(data)
    }

}