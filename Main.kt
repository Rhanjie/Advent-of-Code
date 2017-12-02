import java.io.File
import java.io.InputStream

fun main(args: Array<String>){
    var sum = 0

    val inputStream: InputStream = File("res/input.txt").inputStream()
    val inputString = inputStream.bufferedReader().use { it.readText() }

    println(inputString)


    var secondPosition: Int
    var iterator = 0

    for(i in inputString.indices){
        if(inputString.length/2 + i <= inputString.length-1)
            secondPosition = inputString.length/2 + i

        else secondPosition = iterator++


        println("Iterator: $i ... ${inputString.length/2 + i} and $secondPosition")

        if (inputString[i] == inputString[secondPosition]){
            sum += (inputString[i].toString()).toInt()

            println(" ++ Added sum: $sum (${inputString[i]} and ${inputString[secondPosition]})")
        }
    }

    println("\nEnd! Sum is: $sum")
}