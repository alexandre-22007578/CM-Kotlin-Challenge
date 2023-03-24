package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.util.*
import kotlin.collections.ArrayList

class Pessoa (val nome :String, val dataDeNascimento:Date):Movimentavel {

    var carta: Carta? = null
    var veiculos: ArrayList<Veiculo> = ArrayList()
    var posicao: Posicao = Posicao(0,0)


    fun comprarVeiculo(veiculo: Veiculo){
        veiculos.add(veiculo)
    }

    fun pesquisarVeiculo(identificador:String): Veiculo {
        for (i in veiculos){
            if (i.identificador == identificador){
                return  i
            }
        }
        return Bicicleta("ola")
    }

    fun venderVeiculo(identificador: String, comprador:Pessoa){
        for (i in veiculos){
            if (i.identificador == identificador){
                veiculos.remove(i)
                comprador.comprarVeiculo(i)
                return
            }
        }
    }

    fun moverVeiculoPara(identificador: String, x:Int,y:Int){
        for (i in veiculos){
            if (i.identificador == identificador){
                i.posicao.alterarPosicaoPara(x,y)
                return
            }
        }
    }

    fun temCarta():Boolean{

        return (carta!=null)

    }

    fun tirarCarta(){

        carta= Carta()
    }

    override fun moverPara(x: Int, y: Int) {
        posicao.alterarPosicaoPara(x, y)
    }

    override fun toString(): String {
        return "Pessoa | $nome | $dataDeNascimento | $posicao"
    }
}