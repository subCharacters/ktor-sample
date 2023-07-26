package com.example

import com.example.database.MySQLDatabaseFactory
import com.example.database.OracleDatabaseFactory
import io.ktor.server.application.*
import com.example.plugins.*
import com.example.service.LoginHistService

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

/*fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}*/

fun Application.module() {
    val dbInfo = environment.config
    MySQLDatabaseFactory.init(dbInfo)
    OracleDatabaseFactory.init(dbInfo)
    configureRouting(LoginHistService())
    configureTemplating()
}
