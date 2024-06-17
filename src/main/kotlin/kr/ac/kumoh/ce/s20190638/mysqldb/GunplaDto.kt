package kr.ac.kumoh.ce.s20190638.mysqldb

import java.time.LocalDate

data class MechanicJoinGunplaDto (
    val mechanicId: Int,
    val name: String,
    val model: String,
    val gunplaId: Int?,
    val title: String?,
    val grade: String?,
    val date : LocalDate?,
    val price: Int?
)