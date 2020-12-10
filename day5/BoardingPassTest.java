package day5;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Advent of Code 2020, day 5
 * Tests for boardingpass...well, it's a start anyway :p
 *
 * @author Fredrik Åslund
 * @version 2020-12-10
 */
public class BoardingPassTest {


    @Test
    public void boardingPassReturnsCorrecRow(){
        // Arrange
        BoardingPass test = new BoardingPass("FBFBBFFRLR", 128, 8);
        // Act/Assert
        assertTrue(test.getRow() == 44);
    }
    @Test
    public void boardingPassReturnsCorrectColumn(){
        // Arrange
        BoardingPass test = new BoardingPass("FBFBBFFRLR", 128, 8);
        // Act/Assert
        assertTrue(test.getColumn() == 5);
    }
    @Test
    public void boardingPassReturnsCorrectSeatId(){
        // Arrange
        BoardingPass test = new BoardingPass("FBFBBFFRLR", 128, 8);
        // Act/Assert
        assertTrue(test.getSeatId() == 357);
    }
}