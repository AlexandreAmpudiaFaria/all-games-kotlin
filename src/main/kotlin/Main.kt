import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.util.Scanner

fun main() {
    val leitura = Scanner(System.`in`)
    println("Digite um código de jogo para buscar: ")
    val busca = leitura.nextLine()

    val endereco = "https://www.cheapshark.com/api/1.0/games?id=$busca"

    val client: HttpClient = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create(endereco))
        .build()

    val response = client
        .send(request, HttpResponse.BodyHandlers.ofString())

    val json = response.body()
    println(json)

    val gson = Gson()
    val meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)

//    try{
//        val meuJogo = Jogo(meuInfoJogo.info.title, meuInfoJogo.info.thumb)
//        println(meuJogo)
//    }catch (ex: NullPointerException){
//        println("jogo id inexistente")
//    } exemplo usando try catch no kotlin

    val resultado = runCatching {
        val meuJogo = Jogo(meuInfoJogo.info.title, meuInfoJogo.info.thumb)
        println(meuJogo)
    }

    resultado.onFailure {
        println("jogo id inexistente")
    }

    resultado.onSuccess {
        println("Desenha inserir uma descrição personalizada? (s/n)")
        if ("y".equals(leitura.nextLine(), ignoreCase = true)){
            println("Insira a descrição personalizada: ")
            val descricaoPersonalizada = leitura.nextLine()
        } else {

        }
    }



}