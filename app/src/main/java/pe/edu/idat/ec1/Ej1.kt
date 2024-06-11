package pe.edu.idat.ec1

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
fun espacio(tamanio:Int){
    Spacer(modifier = Modifier.height(tamanio.dp))
}
@Composable
fun formularioCostoE() {
    Box(
        Modifier
            .fillMaxSize()
            .padding(top = 30.dp)){
        var hora by rememberSaveable {
            mutableStateOf("")
        }
        var minuto by rememberSaveable {
            mutableStateOf("")
        }
        var resultado by rememberSaveable {
            mutableStateOf("")
        }

        Column {
            Text(text = "Costo Estacionamiento",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth())
            espacio(tamanio = 10)
            OutlinedTextField(
                value = hora,
                onValueChange = { hora = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingrese numero de horas") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            espacio(tamanio = 10)
            OutlinedTextField(
                value = minuto  ,
                onValueChange = { minuto = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingrese numero de minutos") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            espacio(tamanio = 10)
            Button(onClick = { resultado = calcularCosto(hora.toInt(),minuto.toInt())
            }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "CALCULAR")
            }
            espacio(tamanio = 10)
            Text(text = resultado)
        }
    }
}
fun calcularCosto(hora: Int, minuto: Int): String {
    var minutos = (hora * 60) + minuto
    val horas = minutos / 60
    var costo = horas * 1500

    return "El costo es = $costo soles"
}