package br.applabbs.infrastructure.net

interface Network  {
    fun hasActiveInternetConnection(): Boolean
    fun getConnectionType(): Int
}