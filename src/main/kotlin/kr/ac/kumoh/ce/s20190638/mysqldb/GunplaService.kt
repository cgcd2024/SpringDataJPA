package kr.ac.kumoh.ce.s20190638.mysqldb

import org.springframework.stereotype.Service


@Service
class MechanicService(val repository: MechanicRepository) {
    fun getAllMechanics() : List<Mechanic> {
        return repository.findAll()
    }

    fun add(mechanic: Mechanic) {
        if (mechanic.name.isBlank() || mechanic.model.isBlank())
            throw IllegalArgumentException("not null")
        repository.save(mechanic)
    }

    fun getMechanicJoinGunpla(): List<MechanicJoinGunplaDto> {
        return repository.findMechanicJoinGunpla()
    }
}