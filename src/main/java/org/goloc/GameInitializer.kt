package org.goloc

import java.util.*

class GameInitializer(numberOfColumns: String, cellData: String) {

    val columns: Int
    var rows: List<GameRow> = emptyList()

    init {
        columns = numberOfColumns.toInt()
        rows = parseCellData(cellData)
    }

    private fun parseCellData(cellData: String) : List<GameRow> {
        val chars = cellData.toCharArray()
        val partitionedCells = partition(chars.toList(), columns)
        return partitionedCells.map{ GameRow(it) }
    }

    private fun partition(list: List<Char>, n: Int): List<List<Char>> {

        var numberOfRows = list.size / n

        var partionedLists = ArrayList<List<Char>>()

        var range = 0..numberOfRows-1

        for(i in range)  {
            val startIndex = i * n;
            val endIndex = startIndex + n;
            val subList = list.subList(startIndex, endIndex)
            partionedLists.add(subList)
        }
        return partionedLists.toList()
    }
}

class GameCell {

    val life: Int

    constructor(life: Int) {
        this.life = life
    }

    constructor(lifeAsChar: Char) {
        life = lifeAsChar.toInt()
    }

    override fun equals(other: Any?): Boolean{
        if (this === other) return true
        if (other !is GameCell) return false

        if (life != other.life) return false

        return true
    }

    override fun hashCode(): Int{
        return life
    }


}

class GameRow {

    val cells: List<GameCell>

    // FIXME: I'm very sad ...
    constructor(duck: Int, listOf: List<GameCell>) {
        this.cells = listOf
    }

    constructor(listOf: List<Char>) {
        this.cells = listOf.map{ GameCell(it) }
    }

    override fun equals(other: Any?): Boolean{
        if (this === other) return true
        if (other !is GameRow) return false

        if (cells != other.cells) return false

        return true
    }

    override fun hashCode(): Int{
        return cells.hashCode()
    }


}
