package ru.sber.orm

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import ru.sber.orm.entity.Pet
import ru.sber.orm.entity.Player
import ru.sber.orm.entity.Rank
import ru.sber.orm.repository.PetRepository
import ru.sber.orm.repository.PlayerRepository
import ru.sber.orm.repository.RankRepository

@SpringBootApplication
class OrmApplication(
    private val petRepository: PetRepository,
    private val rankRepository: RankRepository,
    private val playerRepository: PlayerRepository
) : CommandLineRunner {
    override fun run(vararg args: String?) {
        val pets: MutableList<Pet> = mutableListOf()

        pets.add(Pet(name = "Eevee"))
        pets.add(Pet(name = "Pikachu"))
        pets.add(Pet(name = "Ponita"))

        petRepository.saveAll(pets)

        val ranks: MutableList<Rank> = mutableListOf()
        ranks.add(Rank(name = "Noob"))
        ranks.add(Rank(name = "Pro"))

        rankRepository.saveAll(ranks)

        val players: MutableList<Player> = mutableListOf()
        players.add(
            Player(
                name = "Ash",
                pets = pets,
                rank = ranks[0]
            )
        )

        players.add(
            Player(
                name = "Brock",
                pets = mutableListOf(pets[2]),
                rank = ranks[0]
            )
        )

        playerRepository.saveAll(players)
    }
}

fun main(args: Array<String>) {
    runApplication<OrmApplication>(*args)
}
