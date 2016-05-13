package org.goloc

class Game(initializer: GameInitializer, boardFactory: (Int, Int) -> Board) {

    var board : Board

    init {
        val height = initializer.gameRows.size
        val width = initializer.numberOfColumns
        board = boardFactory(width, height)
        initializer.gameRows.mapIndexed { y, gameRow ->
            gameRow.cells.mapIndexed { x, gameCell ->
                board.placeValue(BoardLocation(x, y), gameCell)
            }
        }
    }

    fun nextGeneration(): Unit {
    }

    fun boardCellsData(): String {
        return ""
    }

    fun isCellAlive(x : Int, y: Int): Boolean {
        return board.isCellAlive(x, y)
    }



}

interface IBoard {
    fun placeValue(location: BoardLocation, value: Any) : Unit
}

class Board (width : Int, height : Int) {

    val internalMap : MutableMap<BoardLocation, GameCell> = mutableMapOf<BoardLocation, GameCell>()

    fun placeValue(location: BoardLocation, value: GameCell) {
        internalMap.put(location, value)
    }

    fun isCellAlive(x:Int,y:Int) : Boolean {
        return internalMap.getOrElse(BoardLocation(x,y), { GameCell(0) }).life == 1
    }
}

class BoardLocation(x: Int, y: Int) {

}
