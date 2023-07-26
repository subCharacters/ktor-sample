package com.example.database

import io.ktor.server.config.*
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

object MySQLDatabaseFactory {

    fun init(dbInfo: ApplicationConfig) {
        // val database = Database.connect("jdbc:mysql://10.92.21.188:5605/hangame_hist?useUnicode=true&characterEncoding=MS932&jdbcCompliantTruncation=false&useOldAliasMetadataBehavior=true", "com.mysql.jdbc.Driver", "hangame", "kd9838ijm87d")
        val url = dbInfo.property("ktor.database.mysql.url").getString()
        val user = dbInfo.property("ktor.database.mysql.user").getString()
        val password = dbInfo.property("ktor.database.mysql.password").getString()
        val driver  = dbInfo.property("ktor.database.mysql.driver").getString()

        Database.connect(url, driver ,user, password)
    }

    suspend fun <T> query(block: suspend () -> T): T =
        newSuspendedTransaction(Dispatchers.IO) { block() }
}