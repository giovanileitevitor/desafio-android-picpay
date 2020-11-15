package br.applabbs.infrastructure.net

abstract class ApiStatus(
    val status: Int = -1,
    val message: String = ""
)