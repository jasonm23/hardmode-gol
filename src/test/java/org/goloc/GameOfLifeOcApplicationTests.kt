package org.goloc

import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import org.assertj.core.api.Assertions.*

class GameOfLifeOcApplicationTests {

    var outContent = ByteArrayOutputStream()
    var errContent = ByteArrayOutputStream()

    @Before
    fun setUpStreams() {
        System.setOut(PrintStream(outContent))
        System.setErr(PrintStream(errContent))
    }

    @After
    fun cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    fun runs_an_iteration_of_life() {
        val goingToDie = "3 " +
                "000" +
                "010" +
                "000"

        val args = arrayOf(goingToDie)
        GameOfLifeOcApplication.main(args)

        val expectedOutput = "" +
                "000\n" +
                "000\n" +
                "000"

        assertThat(outContent.toString()).isEqualTo(expectedOutput)
    }

}
