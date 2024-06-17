package kr.ac.kumoh.ce.s20190638.mysqldb

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class GunplaController(val service: MechanicService) {
    @GetMapping("/")
    fun welcom() : String {
        return "sex"
    }

    @GetMapping("/mechanics")
    fun mechanicList(): List<Mechanic> {
        return service.getAllMechanics()
    }

    @GetMapping("/mechanics/add")
    fun addMechanic(): Map<String, Any> {
        val result = HashMap<String, Any>()
        try {
            //TODO : 하드코딩 대신 데이터 받아서 추가하도록 변경할것
            // @PostMapping 사용
            service.add(
                Mechanic(0, "네러티브 건담", "RX-9", "Anaheim Electronics", "Gundarium Alloy",21,40)
            )
            result["result"] = "success"
            return result
        } catch (e: Exception) {
            result["result"] = "failed"
            result["message"] = e.toString()
            return result
        }
    }

    @GetMapping("/mechanics/join/gunpla")
    fun mechanicJoinList(): List<MechanicJoinGunplaDto> {
        return service.getMechanicJoinGunpla()
    }
}