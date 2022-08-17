package io.github.viniciusalvesmello.brasilapibanks.model

import kotlinx.serialization.Serializable

@Serializable
data class Bank(
    val ispb: String?,
    val name: String?,
    val code: Int?,
    val fullName: String?,
)
