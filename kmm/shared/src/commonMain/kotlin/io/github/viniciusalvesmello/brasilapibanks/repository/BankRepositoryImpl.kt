package io.github.viniciusalvesmello.brasilapibanks.repository

import io.github.viniciusalvesmello.brasilapibanks.Factory
import io.github.viniciusalvesmello.brasilapibanks.client.Client
import io.github.viniciusalvesmello.brasilapibanks.model.Bank
import io.ktor.client.call.*

class BankRepositoryImpl : BankRepository {
    private val client: Client by lazy { Factory.client }

    @Throws(Exception::class)
    override suspend fun getListBanks(): List<Bank> = client.get(PATH_LIST_BANKS).body()

    private companion object {
        const val PATH_LIST_BANKS = "/banks/v1"
    }
}