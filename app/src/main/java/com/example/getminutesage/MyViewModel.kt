package com.example.getminutesage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MyViewModel: ViewModel() {
    private var _isLoading = MutableStateFlow(true)
    private  var isLoading = _isLoading.asStateFlow()


    init {
        viewModelScope.launch {
            delay(3000)
            _isLoading.value = false
        }
    }
}