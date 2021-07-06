package br.com.fao.businerscard

import android.app.Application
import br.com.fao.businerscard.data.AppDataBase
import br.com.fao.businerscard.data.BusinessCardRepository

class App: Application() {
    val database by lazy { AppDataBase.getDatabase(this) }
    val repository by lazy { BusinessCardRepository(database.businessDao()) }
}