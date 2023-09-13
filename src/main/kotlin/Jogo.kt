data class Jogo(val titulo:String, val capa:String) {

    val descricao = ""

    override fun toString(): String {
        return "Meu jogo (titulo='$titulo', capa='$capa', descricao='$descricao')"
    }


}