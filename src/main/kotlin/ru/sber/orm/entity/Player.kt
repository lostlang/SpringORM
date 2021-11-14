package ru.sber.orm.entity

import javax.persistence.*

@Table(name = "players")
@Entity
data class Player (
    @Id
    @GeneratedValue
    @Column(name = "player_id")
    val id: Long? = null,

    @Column(name = "player_name")
    val name: String,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rank", referencedColumnName = "rank_id")
    val rank: Rank,

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "pets", referencedColumnName = "pet_id")
    val pets: MutableList<Pet> = mutableListOf()
)