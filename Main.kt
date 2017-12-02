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
        val intList = it.split(" , ")

        for(x1 in intList.indices){
            loop@for(x2 in (x1+1 until intList.size)){
                if(intList[x1].toInt() >= intList[x2].toInt()) {
                    if(intList[x1].toInt() % intList[x2].toInt() == 0){
                        println("Added value ${intList[x1].toInt() / intList[x2].toInt()} to sum")

                        sum += intList[x1].toInt() / intList[x2].toInt()

                        continue@loop
                    }
                }

                if(intList[x2].toInt() % intList[x1].toInt() == 0){ //SWAP
                    println("Added value ${intList[x2].toInt() / intList[x1].toInt()} to sum")

                    sum += intList[x2].toInt() / intList[x1].toInt()
                }
            }
        }
    }

    println("\nEnd! Sum is: $sum")
}