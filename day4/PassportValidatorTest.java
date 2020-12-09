package day4;

import org.junit.*;
import static org.junit.Assert.*;
import org.hamcrest.*;

import java.util.HashMap;

/**
 * Test class for PassortValidator.
 * Day 4 of Advent of Code 2020
 *
 * @author Fredrik Åslund
 * @version 2020-12-08
 */
public class PassportValidatorTest {

    /**
     * Set up variables to be available for each test case.
     */

    public HashMap<String, String> setUp(String input){
        HashMap<String, String> validPassport = new HashMap<>();
        HashMap<String, String> invalidPassport = new HashMap<>();


        validPassport.put("byr", "present"); validPassport.put("iyr", "present"); validPassport.put("eyr", "present");
        validPassport.put("hgt", "present"); validPassport.put("hcl", "present"); validPassport.put("ecl", "present");
        validPassport.put("pid", "present");

        invalidPassport.put("byr", "present"); invalidPassport.put("iyr", "present"); invalidPassport.put("eyr", "present");
        invalidPassport.put("hgt", "present"); invalidPassport.put("hcl", "present"); invalidPassport.put("ecl", "present");
        if(input == "valid"){
        return validPassport;
        }else if(input == "invalid"){
            return invalidPassport;
        }
        return null;
    }

    /**
     * Assert that a passport is valid.
     */
    @Test
    public void assertValidPassportIsValidInPartOne(){
        // Arrange
        PassportValidator test = new PassportValidator();
        HashMap<String, String> validPassport = setUp("valid");
        test.populate();
        // Act/Assert
        test.passportIsValidPartOne(validPassport);
        assertTrue(test.passportIsValidPartOne(validPassport));
    }

    @Test
    public void assertInvalidPassportIsInvalidInPartOne(){
        // Arrange
        PassportValidator test = new PassportValidator();
        HashMap<String, String> invalidPassport = setUp("invalid");
        test.populate();
        // Act/Assert
        assertFalse(test.passportIsValidPartOne(invalidPassport));
    }


}