package com.picpay.desafio.android.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.applabbs.infrastructure.base.BaseViewModel

class SplashViewModel : BaseViewModel() {

    private val _next = MutableLiveData<Boolean>()
    val next: LiveData<Boolean> get() = _next

    fun getLongProcess() {
        launchDataLoad {
            android.os.Handler().postDelayed({
                _next.value = true
            }, 2000)
        }
    }
}