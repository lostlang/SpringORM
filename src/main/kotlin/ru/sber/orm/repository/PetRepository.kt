package ru.sber.orm.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.sber.orm.entity.Pet

@Repository
interface PetRepository: CrudRepository<Pet, Long> {

}