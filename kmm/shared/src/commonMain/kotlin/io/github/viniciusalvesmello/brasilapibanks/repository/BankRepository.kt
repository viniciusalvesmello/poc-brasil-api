package io.github.viniciusalvesmello.brasilapibanks.repository

import io.github.viniciusalvesmello.brasilapibanks.model.Bank

interface BankRepository {
    @Throws(Exception::class)
    suspend fun getListBanks(): List<Bank>
}