package com.example.database

import io.ktor.server.config.*
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction

object OracleDatabaseFactory {

    fun init(dbInfo: ApplicationConfig) {
        // val database = Database.connect("jdbc:mysql://10.92.21.188:5605/hangame_hist?useUnicode=true&characterEncoding=MS932&jdbcCompliantTruncation=false&useOldAliasMetadataBehavior=true", "com.mysql.jdbc.Driver", "hangame", "kd9838ijm87d")
        val url = dbInfo.property("ktor.database.oracle.url").getString()
        val user = dbInfo.property("ktor.database.oracle.user").getString()
        val password = dbInfo.property("ktor.database.oracle.password").getString()
        val driver  = dbInfo.property("ktor.database.oracle.driver").getString()

        Database.connect(url, driver ,user, password)
    }

    suspend fun <T> query(block: suspend () -> T): T =
        newSuspendedTransaction(Dispatchers.IO) { block() }
}