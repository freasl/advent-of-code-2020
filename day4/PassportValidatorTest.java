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
     * Creates a valid and an invalid passport for testing.
     */

    public HashMap<String, String> setUp(String input){
        HashMap<String, String> validPassport = new HashMap<>();
        HashMap<String, String> invalidPassport = new HashMap<>();
        HashMap<String, String> invalidPassport2 = new HashMap<>();
/*
        Valid ranges
        byr: four digits, 1920-2002
        iyr: four digits, 2010-2020
        eyr: four digits, 2020-2030
        hgt: either 150-193cm or 59-76in
        hcl: # followed by six characters (0-9) or (a-f)
        ecl: exactly one of amb blu brn gry grn hzl oth
        pid: nine digit number, including leading zeroes
 */
        validPassport.put("byr", "1994"); validPassport.put("iyr", "2019"); validPassport.put("eyr", "2029");
        validPassport.put("hgt", "181cm"); validPassport.put("hcl", "#F103A0C"); validPassport.put("ecl", "blu");
        validPassport.put("pid", "000456789");

        invalidPassport2.put("byr", "2003"); invalidPassport2.put("iyr", "2009"); invalidPassport2.put("eyr", "2019");
        invalidPassport2.put("hgt", "58in"); invalidPassport2.put("hcl", "#12345"); invalidPassport2.put("ecl", "aus");
        invalidPassport2.put("pid", "00000678");

        invalidPassport.put("byr", "2003"); invalidPassport.put("iyr", "2009"); invalidPassport.put("eyr", "2019");
        invalidPassport.put("hgt", "58in"); invalidPassport.put("hcl", "#12345"); invalidPassport.put("ecl", "aus");


        if(input == "valid"){
        return validPassport;
        }else if(input == "invalid"){
            return invalidPassport;
        }else if(input == "invalid2")
            return invalidPassport2;
        return null;
    }

    /**
     * Assert that a valid passport returns true for part one.
     *
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
*/
    /**
     * Assert that an invalid passport returns false for part one.
     *
    @Test
    public void assertInvalidPassportIsInvalidInPartOne(){
        // Arrange
        PassportValidator test = new PassportValidator();
        HashMap<String, String> invalidPassport = setUp("invalid");
        test.populate();
        // Act/Assert
        assertFalse(test.passportIsValidPartOne(invalidPassport));
    }
*/
    /*
        Valid ranges
        byr: four digits, 1920-2002
        iyr: four digits, 2010-2020
        eyr: four digits, 2020-2030
        hgt: either 150-193cm or 59-76in
        hcl: # followed by six characters (0-9) or (a-f)
        ecl: exactly one of amb blu brn gry grn hzl oth
        pid: nine digit number, including leading zeroes
 */
    @Test
    public void testValidValueHGT() {
        PassportValidator test = new PassportValidator();
        assertFalse(test.validValue("hgt", "194cm"));
        assertFalse(test.validValue("hgt", "77in"));
        assertFalse(test.validValue("hgt", "149cm"));
        assertFalse(test.validValue("hgt", "58in"));
        assertTrue(test.validValue("hgt", "150cm"));
        assertTrue(test.validValue("hgt", "193cm"));
        assertTrue(test.validValue("hgt", "59in"));
        assertTrue(test.validValue("hgt", "76in"));
    }
    @Test
    public void testValidValueEYR() {
        PassportValidator test = new PassportValidator();
        assertFalse(test.validValue("eyr", "2019"));
        assertTrue(test.validValue("eyr", "2020"));
        assertTrue(test.validValue("eyr", "2030"));
        assertFalse(test.validValue("eyr", "2031"));
    }

    @Test
    public void testValidValueIYR() {
        PassportValidator test = new PassportValidator();
        assertFalse(test.validValue("iyr", "2009"));
        assertTrue(test.validValue("iyr", "2010"));
        assertTrue(test.validValue("iyr", "2020"));
        assertFalse(test.validValue("iyr", "2021"));
    }
    @Test
    public void testValidValueBYR(){
        PassportValidator test = new PassportValidator();
        assertFalse(test.validValue("byr", "1919"));
        assertTrue(test.validValue("byr", "1920"));
        assertTrue(test.validValue("byr", "2002"));
        assertFalse(test.validValue("byr", "2003"));

        //ecl: exactly one of amb blu brn gry grn hzl oth
    }
}