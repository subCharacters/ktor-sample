package com.example.dao

import com.example.database.MySQLDatabaseFactory.query
import com.example.model.Disp_loginhist
import com.example.model.Disp_loginhists
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.select

class DAOFacadeImpl : DAOFacade {
    private fun resultRowToDispLoginHist(row: ResultRow) = Disp_loginhist (
        userid = row[Disp_loginhists.userid],
        loginmonth = row[Disp_loginhists.loginmonth]
    )

    override suspend fun getByUserId(userId: String): List<Disp_loginhist> = query {
        Disp_loginhists.select { Disp_loginhists.userid eq userId }
            .map(::resultRowToDispLoginHist)
            .toList()
    }
}