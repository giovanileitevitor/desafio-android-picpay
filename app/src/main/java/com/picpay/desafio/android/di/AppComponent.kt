package com.picpay.desafio.android.di

import br.applabbs.data.di.DataModule.dataModule
import com.picpay.desafio.android.di.AppModules.dataSourceModules
import com.picpay.desafio.android.di.AppModules.netModules
import com.picpay.desafio.android.di.AppModules.serviceModules
import org.koin.core.module.Module

object AppComponent {

    fun getAllModules(): List<Module> = listOf(*getAppModules())

    private fun getAppModules(): Array<Module> {
        return arrayOf(serviceModules, netModules,dataSourceModules, dataModule)
    }
}