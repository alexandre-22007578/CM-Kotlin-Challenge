package pt.ulusofona.cm.kotlin.challenge.models

import src.pt.ulusofona.cm.kotlin.challenge.Posicao
import src.pt.ulusofona.cm.kotlin.challenge.models.Veiculo
import java.util.*
import kotlin.collections.ArrayList

class Pessoa (val nome :String, val dataDeNascimento:Date) {

    var carta: Carta? = null
    var veiculos: ArrayList<Veiculo> = ArrayList()
    var posicao:Posicao = Posicao(0,0)

    fun Pessoa(nome:String, dataDeNascimento: Date){

    }

    fun comprarVeiculo(veiculo: Veiculo){
        veiculos.add(veiculo)
    }

    fun pesquisarVeiculo(identificador:String):Veiculo{
        for (i in veiculos){
            if (i.identificador == identificador){
                return  i
            }
        }
        return Veiculo("erro")
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

        return (carta==null)

    }

    fun tirarCarta(){

        carta= Carta()
    }
}