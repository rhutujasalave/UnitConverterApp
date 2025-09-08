package com.example.unitconverterapp.compose.converter

import android.util.TypedValue
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import com.example.unitconverterapp.data.Conversion
import java.text.DecimalFormat
import java.math.RoundingMode

@Composable
fun TopScreen(
    list: List<Conversion>,
    selectedConversion: MutableState<Conversion?>,         //add 3 parameters for rotation
    inputText: MutableState<String>,
    typedValue: MutableState<String>,
    isLandscape : Boolean,
    save: (String, String) -> Unit
) {

    var toSave by remember {
        mutableStateOf(false)
    }


    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {

        ConversionMenu(list = list, isLandscape) {

            selectedConversion.value = it
            typedValue.value = "0.0"

        }

        selectedConversion.value?.let {
            InputBlock(conversion = it, inputText = inputText, isLandscape) { input ->
//            Log.i("Tag","user typed $input")
                typedValue.value = input
                toSave = true
            }
        }

        if (typedValue.value != "0.0") {
            val input = typedValue.value.toDouble()
            val multiply = selectedConversion.value!!.multiplyBy
            val result = input * multiply

            //rounding off the result to 4 decimal placess
            val df = DecimalFormat("#.####")
            df.roundingMode = RoundingMode.DOWN
            val roundedResult = df.format(result)

            val message1 =
                "${typedValue.value} ${selectedConversion.value!!.convertFrom} is equal to "
            val message2 = "$roundedResult ${selectedConversion.value!!.convertTo}"
            if (toSave) {
                save(message1, message2)
                toSave = false
            }
            ResultBlock(message1 = message1, message2 = message2)
        }
    }

}