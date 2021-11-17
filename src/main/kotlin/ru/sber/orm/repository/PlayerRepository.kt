package ru.sber.orm.repository

import org.hibernate.SessionFactory
import ru.sber.orm.entity.Player

class PlayerRepository(
    private val sessionFactory: SessionFactory
) {
    fun save(player: Player) {
        sessionFactory.openSession().use { session ->
            session.beginTransaction()
            session.persist(player)
            session.transaction.commit()
        }
    }

    fun saveAll(players: MutableList<Player>) {
        players.forEach{ player ->
            save(player)
        }
    }

    fun findById(id: Long): Player? {
        val result: Player?
        sessionFactory.openSession().use { session ->
            session.beginTransaction()
            result = session.get(Player::class.java, id)
            session.transaction.commit()
        }
        return result
    }
}