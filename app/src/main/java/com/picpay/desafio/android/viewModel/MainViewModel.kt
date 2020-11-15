package com.picpay.desafio.android.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.applabbs.data.entity.User
import br.applabbs.data.repository.UserRepository
import br.applabbs.infrastructure.base.BaseViewModel
import br.applabbs.infrastructure.net.ErrorResults
import br.applabbs.infrastructure.net.Network
import br.applabbs.infrastructure.net.SuccessResults

open class MainViewModel(
    private val userRepository: UserRepository
): BaseViewModel() {

    private val _resposta = MutableLiveData<List<User>>()
    val resposta : LiveData<List<User>> get() = _resposta

    fun getUsers(){
        launchDataLoad {
            _loading.value = true

            when (val request = userRepository.getUsers()){
                is SuccessResults -> {
                    _loading.value = false
                    _resposta.value = request.body
                }
                is ErrorResults -> {
                    _loading.value = false
                    _error.value = true
                }
            }
        }
    }
}