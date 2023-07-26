package com.example

import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.server.testing.*
import kotlin.test.*
import io.ktor.http.*
import com.example.plugins.*
import com.example.service.LoginHistService

class ApplicationTest {
    @Test
    fun testRoot() = testApplication {
        application {
            configureRouting(LoginHistService())
        }
        client.get("/").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("Hello World!", bodyAsText())
        }
    }
}
