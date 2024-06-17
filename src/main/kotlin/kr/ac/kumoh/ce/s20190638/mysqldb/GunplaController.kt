package kr.ac.kumoh.ce.s20190638.mysqldb

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class GunplaController(val service: MechanicService) {
    @GetMapping("/")
    fun welcome() : String {
        return "hello"
    }

    @GetMapping("/mechanics")
    fun mechanicList(): List<Mechanic> {
        return service.getAllMechanics()
    }

    @PostMapping("/mechanics/add")
    fun addMechanic(@RequestBody newMechanic: Mechanic): Map<String, Any> {
        val result = HashMap<String, Any>()
        return try {
            service.add(newMechanic)
            result["result"] = "success"
            result
        } catch (e: Exception) {
            result["result"] = "failed"
            result["message"] = e.message.toString()
            result
        }
    }

    @GetMapping("/mechanics/join/gunpla")
    fun mechanicJoinList(): List<MechanicJoinGunplaDto> {
        return service.getMechanicJoinGunpla()
    }
}