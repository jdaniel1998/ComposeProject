package com.example.composeadmin.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeadmin.domain.model.Variable
import com.example.composeadmin.domain.usecases.GetVariablesListUseCase
import com.example.composeadmin.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getJsonUseCase: GetVariablesListUseCase
) :
    ViewModel() {

    private val _homeUiState = MutableStateFlow<HomeUIState>(HomeUIState.Loading)
    val homeUIState: StateFlow<HomeUIState> = _homeUiState

    init {
        getJson()
    }

    fun getJson() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _homeUiState.emit(HomeUIState.Loading)
                when (val result = getJsonUseCase()) {
                    is Resource.Error -> _homeUiState.emit(HomeUIState.Error(result.message))
                    is Resource.Success -> _homeUiState.emit(HomeUIState.Success(result.data))
                }
            } catch (e: Exception) {
                _homeUiState.emit(HomeUIState.Error(e.message))
            }
        }
    }


}

sealed class HomeUIState {

    object Loading : HomeUIState()
    class Success(val list: List<Variable>?) : HomeUIState()
    class Error(val error: String?) : HomeUIState()
}
