package org.goloc

object GameOfLifeOcApplication {

    @JvmStatic fun main(args: Array<String>) {

        val columns = args[0]
        val cells = args[1]
        val initializer = GameInitializer(columns, cells)

        println("hello world")
    }
}
