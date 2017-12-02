import java.io.File
import java.io.InputStream

fun main(args: Array<String>){
    var sum = 0

    val inputStream: InputStream = File("res/input.txt").inputStream()
    val inputString = inputStream.bufferedReader().use { it.readText() }

    println(inputString)

    loop@ for(i in inputString.indices){
        if(i < inputString.length-1) {
            if (inputString[i] == inputString[i + 1]){
                println("Iterator: $i ... ${inputString.length-1}")

                sum += (inputString[i].toString()).toInt()

                println(" ++ Added sum: $sum (${(inputString[i].toString()).toInt()} and ${(inputString[i+1].toString()).toInt()})")

                continue@loop
            }
        }
    }

    println("Iterator: ${inputString.length-1} ... 0")
    if (inputString[inputString.length-1] == inputString[0]){
        sum += (inputString[inputString.length-1].toString()).toInt()

        println(" ++ Added sum: $sum (${(inputString[inputString.length-1].toString()).toInt()} and ${(inputString[0].toString()).toInt()})")
    }

    println("\nEnd! Sum is: $sum")
}