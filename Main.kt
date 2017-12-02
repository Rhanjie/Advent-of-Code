import java.io.File
import java.io.InputStream

fun main(args: Array<String>){
    var sum = 0

    val inputStream: InputStream = File("res/input.txt").inputStream()
    val lineList = mutableListOf<String>()

    (inputStream.bufferedReader()).useLines{
        lines -> lines.forEach{
            lineList.add(it)
        }
    }

    lineList.forEach{
        var small = 10000
        var big = 0

        it.split(" , ").forEach {
            if(it.toInt() < small)
                small = it.toInt()

            if(it.toInt() > big)
                big = it.toInt()
        }

        sum += (big - small)

        println("Difference: ${big - small} : $big - $small")
    }

    println("\nEnd! Sum is: $sum")
}