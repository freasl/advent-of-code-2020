package day5;

import org.junit.Test;

import static org.junit.Assert.*;

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