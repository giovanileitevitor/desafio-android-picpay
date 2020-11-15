package com.picpay.desafio.android

import org.koin.core.KoinComponent
import androidx.multidex.MultiDexApplication
import com.picpay.desafio.android.di.AppComponent.getAllModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

open class PicPayApplication : MultiDexApplication(), KoinComponent {

    override fun onCreate() {
        super.onCreate()
        initDI()
    }

    private fun initDI() {
        startKoin {
            androidLogger()
            androidContext(this@PicPayApplication)
            koin.loadModules(getAllModules())
            koin.createRootScope()
        }
    }
}