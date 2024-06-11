package pe.edu.idat.ec1

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@Composable
fun formularioDNI(){
    Box(
        Modifier
            .fillMaxSize()
            .padding(top = 30.dp)){
        var año by rememberSaveable {
            mutableStateOf("")
        }

        var resultado by rememberSaveable {
            mutableStateOf("")
        }
        Column {
            Text(text = "DNI",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth())
            espacio(tamanio = 10)
            OutlinedTextField(
                value = año,
                onValueChange = { año = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingrese año de nacimiento") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            espacio(tamanio = 10)
            Button(onClick = {resultado = calcular(año.toInt())}, modifier = Modifier.fillMaxWidth()) {
                Text(text = "CALCULAR")
            }
            espacio(tamanio = 10)
            Text(text = resultado)
        }
    }
}
fun calcular(año : Int ): String {
    val añoActual = 2024
    var respuesta = ""
    val calculo = añoActual - año
    if (calculo > 18){
        respuesta =  "Puede sacar su DNI"
    }
    else
        respuesta = "No puede sacar su DNI"

    return respuesta
}

