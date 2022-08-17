package io.github.viniciusalvesmello.brasilapibanks.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import io.github.viniciusalvesmello.brasilapibanks.Factory
import io.github.viniciusalvesmello.brasilapibanks.repository.BankRepository
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private val scope = MainScope()
    private val repository: BankRepository by lazy {
        Factory.bankRepository
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)
        getBanksTexts { text ->
            tv.text = text
        }
    }

    private fun getBanksTexts(resultBanks: (String) -> Unit = {}) {
        scope.launch {
            runCatching {
                repository.getListBanks()
            }.onSuccess { banks ->
                resultBanks(banks.joinToString { it.fullName ?: "" })
            }.onFailure {
                resultBanks("Error: ${it.localizedMessage}")
            }
        }
    }
}
