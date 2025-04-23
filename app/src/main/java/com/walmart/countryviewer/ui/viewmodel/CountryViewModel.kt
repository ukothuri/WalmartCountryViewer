package com.walmart.countryviewer.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.walmart.countryviewer.data.model.Country
import com.walmart.countryviewer.data.model.ResultState
import com.walmart.countryviewer.repository.ICountryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CountryViewModel(private val repository: ICountryRepository) : ViewModel() {

    private val _state = MutableLiveData<ResultState<List<Country>>>()
    val state: LiveData<ResultState<List<Country>>> = _state

    fun loadCountries() {
        _state.value = ResultState.Loading
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = repository.getCountries()
                _state.postValue(ResultState.Success(result))
            } catch (e: Exception) {
                _state.postValue(ResultState.Error(e))
            }
        }
    }
}