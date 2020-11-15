package br.applabbs.infrastructure.lifecycle

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import br.applabbs.infrastructure.livedata.observeSmart


fun <T : Any> LifecycleOwner.bindToVM(data: LiveData<T>, function: (id: T) -> Unit) {
    data.observeSmart(this) { function.invoke(it) }
}


