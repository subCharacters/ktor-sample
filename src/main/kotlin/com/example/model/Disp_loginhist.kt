package com.example.model

import org.jetbrains.exposed.sql.Table

data class Disp_loginhist (
    var loginmonth: Int? = null,
    var userid: String? = null
        )

object Disp_loginhists : Table(name = "disp_loginhist") {
    var loginmonth = integer("loginmonth")
    var userid = varchar("userid", 255)
}