package ru.sber.orm.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.sber.orm.entity.Rank

@Repository
interface RankRepository: CrudRepository<Rank, Long> {

}