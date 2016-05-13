package org.goloc

import org.junit.Assert.*
import org.assertj.core.api.Assertions.*
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.*

class GameTest {
    @Test
    fun setsUpBoard() {
        val init = GameInitializer("2", "1001")
        val boardFactory = { width : Int, height : Int -> Board(width, height) }

        val game = Game(init, boardFactory)

        assertThat(game.isCellAlive(0,0)).isTrue()
    }

//    @Test
//    fun placesCellValues() {
//
//        val init = GameInitializer("2", "1001")
//        val boardFactory = { width : Int, height : Int -> Board(width, height) }
//        val board = mock(Board::class.java)
//
//        val game = Game(init, boardFactory)
//
//
//
//    }

//    @Test
//    fun mutatesToNextGeneration() {
//        val horizontalBlinkerInitializer = GameInitializer("3",
//                "000" +
//                "111" +
//                "000")
//
//        val game = Game(horizontalBlinkerInitializer, board)
//        game.nextGeneration()
//
//        assertThat(game.boardCellsData()).isEqualTo("010010010")
//    }
}


