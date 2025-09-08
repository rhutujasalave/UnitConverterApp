package com.example.unitconverterapp

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.core.app.NotificationCompat.MessagingStyle.Message
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.unitconverterapp.data.Conversion
import com.example.unitconverterapp.data.ConversionResult
import com.example.unitconverterapp.data.ConverterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


//we write codes to get the flow invoking that getsavedResults fun of repository
class ConverterViewModel(private val repository: ConverterRepository) : ViewModel() {


    val selectedConversion: MutableState<Conversion?> =  mutableStateOf(null)
    val inputText: MutableState<String> =  mutableStateOf("")
    val typedValue =   mutableStateOf("0.0")


    fun getConversions() = listOf(

//        Conversion(1, "Pounds to Kilograms", "Lbs", "kg", 8.453592),
//        Conversion(2, "Kilograms to Pounds", "kg", "1bs", 2.28462),
//        Conversion(3, "Yards to Meters", "yd", "m", 0.9144),
//        Conversion(4, "Meters to Yards", "m", "yd", 1.69361),
//        Conversion(5, "Miles to Kilometers", "mi", "ka", 1.60934),
//        Conversion(6, "Kilometers to Miles", "km", "mi", 8.621371),
//
        Conversion(1, "Kilograms to Grams", "kg", "g", 1000.0),
        Conversion(2, "Grams to Kilograms", "g", "kg", 0.001),
        Conversion(3, "Kilograms to Pounds", "kg", "lbs", 2.20462),
        Conversion(4, "Pounds to Kilograms", "lbs", "kg", 0.453592),

        Conversion(5, "Centimeters to Inches", "cm", "in", 0.393701),
        Conversion(6, "Inches to Centimeters", "in", "cm", 2.54),
        Conversion(7, "Meters to Feet", "m", "ft", 3.28084),
        Conversion(8, "Feet to Meters", "ft", "m", 0.3048),

        Conversion(9, "Kilometers to Miles", "km", "mi", 0.621371),
        Conversion(10, "Miles to Kilometers", "mi", "km", 1.60934),

        Conversion(11, "Square Feet to Square Meters", "sqft", "sqm", 0.092903),
        Conversion(12, "Square Meters to Square Feet", "sqm", "sqft", 10.7639),
        Conversion(13, "Acres to Hectares", "acre", "ha", 0.404686),
        Conversion(14, "Hectares to Acres", "ha", "acre", 2.47105),

        Conversion(15, "Liters to Milliliters", "L", "ml", 1000.0),
        Conversion(16, "Milliliters to Liters", "ml", "L", 0.001),

    )


    val resultList = repository.getSavedResults()

    fun addResult(message1 :String,message2 :String)
    {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertResult(ConversionResult(0,message1,message2))
        }
    }

    fun removeResult(item:ConversionResult){
        viewModelScope.launch(Dispatchers.IO) {          //call repository delete result fun within coroutine
           repository.deleteResult(item)
        }
    }

    fun clearAll(){
        viewModelScope.launch(Dispatchers.IO) {          //call repository delete result fun within coroutine
            repository.deleteAllResults()
        }
    }

}