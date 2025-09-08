package com.example.unitconverterapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory
import androidx.room.Insert
import com.example.unitconverterapp.data.ConverterRepository



class ConverterViewModelFactory @Inject constructor(private val repository: ConverterRepository): NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T = ConverterViewModel(repository) as T

}