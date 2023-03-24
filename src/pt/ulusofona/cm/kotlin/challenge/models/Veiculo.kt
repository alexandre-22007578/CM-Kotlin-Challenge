package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.text.SimpleDateFormat
import java.time.Instant
import java.util.*


abstract class Veiculo(val identificador: String):Movimentavel {

    val posicao: Posicao = Posicao(0,0)
    val dataDeAquisicao: Date = Date.from(Instant.now())

    abstract fun requerCarta():Boolean





}