package com.hugo.businesscard

import android.app.Application
import com.hugo.businesscard.data.AppDataBase
import com.hugo.businesscard.data.BusinessCardRepository

class App:Application() {
    val database by lazy { AppDataBase.getDataBase(this) }
    val repository by lazy { BusinessCardRepository(database.businessDao()) }
}