package com.example.plugins

import com.example.model.Disp_loginhist
import com.example.model.Disp_loginhists
import com.example.model.Disp_loginhists.loginmonth
import com.example.model.Disp_loginhists.userid
import com.example.service.LoginHistService
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import io.ktor.server.thymeleaf.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

fun Application.configureRouting(loginHistService: LoginHistService) {
    routing {
        route("/") {
            // call.respondText("Hello World!")
            get{
                val sampleUser = User(1, "John")
                call.respond(ThymeleafContent("index", mapOf("user" to sampleUser)))
            }
            get("index") {
                val sampleUser = User(1, "John")
                call.respond(ThymeleafContent("index", mapOf("user" to sampleUser)))
            }
        }
        /*get("/index") {
            val sampleUser = User(1, "John")
            call.respond(ThymeleafContent("index", mapOf("user" to sampleUser)))
        }*/
        get("/hello/{name}") {
            val sampleUser = User(1, call.parameters["name"].toString())
            call.respond(ThymeleafContent("index", mapOf("user" to sampleUser)))
        }

        get("/getLoginHist/{memberid}") {
            call.respond(ThymeleafContent("loginhist", mapOf("Disp_loginhist" to loginHistService.getByUserId(call.parameters["memberid"].toString()))))
        }
    }
}

data class User(val id: Int,val name: String)
