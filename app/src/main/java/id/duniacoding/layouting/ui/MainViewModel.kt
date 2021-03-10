package id.duniacoding.layouting.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private val _numberOfItem = MutableLiveData<Int>()
    val numberOfItem: LiveData<Int>
        get() = _numberOfItem

    init {
        _numberOfItem.value = 0
    }

    fun increaseItem() {
        _numberOfItem.value?.plus(1)
    }

    fun decreaseItem() {
        _numberOfItem.value?.minus(1)
    }
}