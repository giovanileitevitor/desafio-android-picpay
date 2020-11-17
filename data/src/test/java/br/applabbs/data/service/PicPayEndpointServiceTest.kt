package br.applabbs.data.service

import io.mockk.impl.annotations.MockK
import org.junit.jupiter.api.BeforeEach
import org.mockito.MockitoAnnotations

class PicPayEndpointServiceTest {

    @MockK
    lateinit var service: PicPayEndpointService

    @BeforeEach
    internal fun setup(){
        MockitoAnnotations.initMocks(this)

    }
}