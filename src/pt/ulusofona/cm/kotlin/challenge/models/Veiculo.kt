package src.pt.ulusofona.cm.kotlin.challenge.models

import src.pt.ulusofona.cm.kotlin.challenge.Posicao
import java.util.Date


class Veiculo(val identificador: String, val posicao: Posicao, val dataDeAquisicao: Date) {

    fun Veiculo(identificador: String) {

    }
    fun requerCarta():Boolean{
        return  true
    }

}