enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nomeCompleto: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
}

fun main() {
    val html = ConteudoEducacional("Html")
    val css = ConteudoEducacional("CSS")
    val js = ConteudoEducacional("JavaScript")

    val formacaoFrontend = Formacao(
        "Formação Frontend", 
        Nivel.BASICO, 
        listOf(html, css, js)
    )

    val tania = Usuario("Tania Silva")
    val claudio = Usuario("Claudio Duarte")

    formacaoFrontend.matricular(tania)
    formacaoFrontend.matricular(claudio)

    print("Formação deve ter 2 inscritos - ${formacaoFrontend.inscritos.count() == 2}")
}