package ru.sber.orm.entity

import javax.persistence.*

@Table(name = "pets")
@Entity
data class Pet (
    @Id
    @GeneratedValue
    @Column(name = "pet_id")
    val id: Long? = null,

    @Column(name = "pet_name")
    val name: String
) {
    override fun equals(other: Any?): Boolean {
        return false
    }

    override fun hashCode() = 0

    override fun toString(): String {
        return this.javaClass.simpleName
    }
}