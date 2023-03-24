package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.PessoaSemCartaException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoNaoEncontradoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.text.SimpleDateFormat
import java.time.Instant
import java.util.*
import kotlin.collections.ArrayList

val dataFormatada = SimpleDateFormat("dd-MM-yyyy", Locale.GERMANY)

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
      throw VeiculoNaoEncontradoException("Veiculo que pretende encontrar não pretence a esta pessoa com o nome $nome")
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


        val veiculo = pesquisarVeiculo(identificador)

        if (veiculo.requerCarta() && !temCarta()){
            throw PessoaSemCartaException(nome)
        }


        veiculo.posicao.alterarPosicaoPara(x,y)
        this.posicao.alterarPosicaoPara(x,y)

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
        return "Pessoa | $nome | ${dataFormatada.format(dataDeNascimento)} | $posicao"
    }


    fun maiorDeIdade():Boolean{

        val dataHoje:Date = Date.from(Instant.now())

        val idadeMS:Long = dataHoje.time-dataDeNascimento.time

        val dezoitoAnosEmMilisegundos:Double = 5.68024668 * 1011

        return dezoitoAnosEmMilisegundos <= idadeMS


    }
}