package ru.sber.orm.entity

import javax.persistence.*

@Table(name = "ranks")
@Entity
data class Rank (
    @Id
    @GeneratedValue
    @Column(name = "rank_id")
    val id: Long? = null,

    @Column(name = "rank_name")
    val name: String,
) {
    override fun equals(other: Any?) = false

    override fun hashCode() = 0

    override fun toString(): String = this.javaClass.simpleName
}