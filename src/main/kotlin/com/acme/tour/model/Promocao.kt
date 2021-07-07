package com.acme.tour.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Promocao(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val descricao: String,
    val local: String,
    val isAllInclusive: Boolean,
    val qtdDias: Int,
    val preco: Double
)