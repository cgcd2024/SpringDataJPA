package kr.ac.kumoh.ce.s20190638.mysqldb

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface MechanicRepository : JpaRepository<Mechanic, Int> {
    @Query("""
        select new kr.ac.kumoh.ce.s20190638.mysqldb.MechanicJoinGunplaDto(
            m.id, m.name, m.model,
            g.id, g.title, g.grade, g.date, g.price)
        from Mechanic m left join Gunpla g
        on m.id = g.mechanic_id
    """)
    fun findMechanicJoinGunpla(): List<MechanicJoinGunplaDto>
}