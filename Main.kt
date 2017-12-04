import java.io.File
import java.io.InputStream

fun main(args: Array<String>) {
    val inputStream: InputStream = File("res/input.txt").inputStream()
    val lineList = mutableListOf<String>()

    var words: List<String>

    (inputStream.bufferedReader()).useLines{
        lines -> lines.forEach{
            lineList.add(it)
        }
    }

    var counter = lineList.size

    lineList.forEach{
        words = it.split(" ").sorted()

        for(i in (0..words.size-2)){
            if(words[i] == words[i+1]) {
                counter--

                break
            }
        }
    }

    println("End! Counter: $counter")
}