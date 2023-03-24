package pt.ulusofona.cm.kotlin.challenge.models

class Pessoa (val nome :String, var veiculos: MutableList<Veicu lo>, val dataDeNascimento:Date, var posicao: Posicao) {

    var carta: Carta? = null

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
        return Veiculo("erro", Posicao(4,5), Date(2000))
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