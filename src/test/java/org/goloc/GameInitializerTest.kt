package org.goloc

import org.junit.Assert.*
import org.assertj.core.api.Assertions.*
import org.junit.Test

class GameInitializerTest {
    @Test
    fun initializesColumns() {
        var columns = "2"
        var cells = "0110"

        val initializer = GameInitializer(columns, cells)

        assertThat(initializer.numberOfColumns).isEqualTo(2)
    }

    @Test
    fun initializesRows() {
        var columns = "2"
        var cells = "0110"

        val initializer = GameInitializer(columns, cells)

        val expectedFirstRow  = GameRow(listOf(GameCell(0), GameCell(1)))
        val expectedSecondRow = GameRow(listOf(GameCell(1), GameCell(0)))

        val expectedRows = listOf(expectedFirstRow, expectedSecondRow)

        assertThat(initializer.gameRows).isEqualTo(expectedRows)
    }
}

