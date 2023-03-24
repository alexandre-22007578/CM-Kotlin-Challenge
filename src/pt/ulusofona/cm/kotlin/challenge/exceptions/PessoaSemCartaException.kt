package pt.ulusofona.cm.kotlin.challenge.exceptions

import java.lang.Exception

class PessoaSemCartaException(val nome:String): Exception() {
    override val message: String?
        get() = "$nome não tem carta para conduzir o veículo indicado"
}