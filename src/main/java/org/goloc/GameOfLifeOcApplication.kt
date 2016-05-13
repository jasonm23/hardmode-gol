package org.goloc

object GameOfLifeOcApplication {

    @JvmStatic fun main(args: Array<String>) {

        val columns = args[0]
        val cells = args[1]
        val initializer = GameInitializer(columns, cells)
//        val nextBoard = Board(initializer).nextGeneration()
//        ConsoleRenderer.render(nextBoard)

        println("hello world")
    }
}
