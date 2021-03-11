package id.duniacoding.layouting.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private val _numberOfItem = MutableLiveData<Int>()
    val numberOfItem: LiveData<Int>
        get() = _numberOfItem

    init {
        _numberOfItem.value = 1
    }

    fun increaseItem() {
        _numberOfItem.value?.let { q ->
            if (q < 9) {
                _numberOfItem.value = q + 1
            }
        }
    }

    fun decreaseItem() {
        _numberOfItem.value?.let { q ->
            if (q > 1) {
                _numberOfItem.value = q - 1
            }
        }
    }
}