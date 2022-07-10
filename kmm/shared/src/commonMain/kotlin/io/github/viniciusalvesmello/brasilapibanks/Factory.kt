package io.github.viniciusalvesmello.brasilapibanks

import io.github.viniciusalvesmello.brasilapibanks.client.Client
import io.github.viniciusalvesmello.brasilapibanks.client.ClientImpl
import io.github.viniciusalvesmello.brasilapibanks.repository.BankRepository
import io.github.viniciusalvesmello.brasilapibanks.repository.BankRepositoryImpl

object Factory {
    internal val client: Client by lazy { ClientImpl() }
    val bankRepository: BankRepository by lazy { BankRepositoryImpl() }
}