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
fun formularioNotas(){
    Box(
        Modifier
            .fillMaxSize()
            .padding(top = 30.dp)){
        var n1 by rememberSaveable {
            mutableStateOf("")
        }
        var n2 by rememberSaveable {
            mutableStateOf("")
        }
        var n3 by rememberSaveable {
            mutableStateOf("")
        }
        var n4 by rememberSaveable {
            mutableStateOf("")
        }
        var resultado by rememberSaveable {
            mutableStateOf("")
        }
        Column {
            Text(text = "Notas",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth())
            espacio(tamanio = 10)
            OutlinedTextField(
                value = n1,
                onValueChange = { n1 = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingrese la nota 1") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            espacio(tamanio = 10)
            OutlinedTextField(
                value = n2,
                onValueChange = { n2 = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingrese la nota 2") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            espacio(tamanio = 10)
            OutlinedTextField(
                value = n3,
                onValueChange = { n3 = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingrese la nota 3") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            espacio(tamanio = 10)
            OutlinedTextField(
                value = n4,
                onValueChange = { n4 = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingrese la nota 4") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            espacio(tamanio = 10)
            Button(onClick = {resultado = calcular(n1.toDouble(),n2.toDouble(),n3.toDouble(),n4.toDouble())}, modifier = Modifier.fillMaxWidth()) {
                Text(text = "CALCULAR")
            }
            espacio(tamanio = 10)
            Text(text = resultado)
        }
    }
}
fun calcular(n1: Double, n2: Double, n3: Double, n4: Double ): String {
    var notaM = n1
    val promedio = n1 * 0.2 + n2 * 0.3 + n3*0.5

    if (n2<notaM){
        notaM = n2
    }
    else if (n3 < notaM){
        notaM = n3
    }
    else if (n4 < notaM){
        notaM = n4
    }

    return "La nota menor es= $notaM y el promedio es $promedio "
}
