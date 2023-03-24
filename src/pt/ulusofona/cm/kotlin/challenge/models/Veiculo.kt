package src.pt.ulusofona.cm.kotlin.challenge.models

import src.pt.ulusofona.cm.kotlin.challenge.Posicao
import java.time.Instant
import java.util.Date


class Veiculo(val identificador: String) {

    val posicao: Posicao = Posicao(0,0)
    val dataDeAquisicao: Date = Date.from(Instant.now())

    fun Veiculo(identificador: String) {

    }
    fun requerCarta():Boolean{
        return  true
    }

}