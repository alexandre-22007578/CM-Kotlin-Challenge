package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel

class Carro ( indentificador:String, val motor: Motor):Veiculo(indentificador),Ligavel{
    override fun requerCarta(): Boolean {
        return true
    }

    override fun moverPara(x: Int, y: Int) {

        if (estaLigado()){
            posicao.alterarPosicaoPara(x,y)
            desligar()
        }else{
            ligar()
            posicao.alterarPosicaoPara(x,y)
            desligar()
        }


    }

    override fun ligar() {
        motor.ligar()
    }

    override fun desligar() {
        motor.desligar()
    }

    override fun estaLigado(): Boolean {
        return motor.estaLigado()
    }

    override fun toString(): String {
        return "Carro | $identificador | ${dataFormatada.format(dataDeAquisicao)} | $posicao"
    }


}