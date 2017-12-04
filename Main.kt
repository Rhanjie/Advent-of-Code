enum class Direction {
    RIGHT, UP, LEFT, DOWN
}

fun main(args: Array<String>) {
    val input = 312051
    var steps = 0

    var direction: Direction
    direction = Direction.RIGHT


    /** Creating a map **/
    var length = 1
    var index = 1
    val list: MutableList<MutableList<Int>> = mutableListOf()
        list.add(mutableListOf())
        list.last().add(index) //first element

    while(true){
        when(direction){
            Direction.RIGHT -> {
                for (i in (0 until length))
                    (list.last()).add(++index)

                direction = Direction.UP
            }

            Direction.UP -> {
                list.add(0, mutableListOf())

                for (i in (list.size - 2 downTo 0))
                    list[i].add(++index)

                length++
                direction = Direction.LEFT
            }

            Direction.LEFT -> {
                for (i in (0 until length))
                    (list.first()).add(0, ++index)

                direction = Direction.DOWN
            }

            Direction.DOWN -> {
                list.add(mutableListOf())

                for (i in (1 until list.size))
                    list[i].add(0, ++index)

                length++
                direction = Direction.RIGHT
            }
        }

        if(index >= input)
            break
    }

    /** Searching position (Shitty code, I know :c) **/
    var firstX = 0
    var firstY = 0
    var secondX = 0
    var secondY = 0

    for (y in list.indices) {
        for (x in list[y].indices) {
            if (list[y][x] == 1) {
                firstX = x
                firstY = y
            }

            if (list[y][x] == input) {
                secondX = x
                secondY = y
            }

        }
    }

    /** Walking on the path **/
    val vertical = if(firstY < secondY) -1 else 1
    val horizontal = if(firstX < secondX) -1 else 1

    while(true){
        if(secondY != firstY){
            secondY += vertical

            steps++
        }

        if(secondX != firstX){
            secondX += horizontal

            steps++
        }

        if(firstX == secondX && firstY == secondY)
            break
    }

    println("End! Steps: $steps")
}

