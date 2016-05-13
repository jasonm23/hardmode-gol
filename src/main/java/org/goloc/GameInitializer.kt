package org.goloc

import java.util.*

fun Char.stringToInt(): Int {
    return toString().toInt()
}

fun String.toListOfParsedInts():List<Int> {
    return toCharArray().map{it.stringToInt()}
}

infix fun <T>Int.groupsFrom(list: List<T>): List<List<T>> {

    var numberOfRows = list.size / this
    var partionedLists = ArrayList<List<T>>()
    var range = 0..numberOfRows - 1

    for (i in range) {
        val startIndex = i * this;
        val endIndex = startIndex + this;
        val subList = list.subList(startIndex, endIndex)
        partionedLists.add(subList)
    }

    return partionedLists.toList()
}

class GameInitializer(columns: String, cellData: String) {
    val numberOfColumns: Int
    var gameRows: List<GameRow> = emptyList()

    init {
        numberOfColumns = columns.toInt()
        gameRows = parseCellData(cellData)
    }

    private fun parseCellData(cellData: String): List<GameRow> {
        val cellValues = cellData.toListOfParsedInts()
        return (numberOfColumns groupsFrom cellValues).map {
            GameRow.withCellValues(it)
        }
    }
}

class GameCell {

    val life: Int

    constructor(life: Int) {
        this.life = life
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is GameCell) return false

        if (life != other.life) return false

        return true
    }

    override fun hashCode(): Int {
        return life
    }
}

class GameRow(val cells: List<GameCell>) {

    companion object {
        fun withCellValues(values: List<Int>): GameRow {
            return GameRow(values.map(::GameCell))
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is GameRow) return false

        if (cells != other.cells) return false

        return true
    }

    override fun hashCode(): Int {
        return cells.hashCode()
    }
}
