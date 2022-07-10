package io.github.viniciusalvesmello.brasilapibanks.repository

import io.github.viniciusalvesmello.brasilapibanks.model.Bank

interface BankRepository {
    suspend fun getListBanks(): List<Bank>
}