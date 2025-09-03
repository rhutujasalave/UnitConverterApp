package com.example.unitconverterapp

import androidx.lifecycle.ViewModel

class ConverterViewModel : ViewModel() {

    fun getConversions() = listOf(

        Conversion(1, "Pounds to Kilograms", "Lbs", "kg", 8.453592),
        Conversion(2, "Kilograms to Pounds", "kg", "1bs", 2.28462),
        Conversion(3, "Yards to Meters", "yd", "m", 0.9144),
        Conversion(4, "Meters to Yards", "m", "yd", 1.69361),
        Conversion(5, "Miles to Kilometers", "mi", "ka", 1.60934),
        Conversion(6, "Kilometers to Miles", "km", "mi", 8.621371)
    )

}