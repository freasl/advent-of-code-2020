package day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Day 4 of Advent of Code 2020!
 *
 * Part one returns the number of valid passports according to the rules:
 *  cid is optional, all other fields must be present.
 *
 * Part Two extends rules to specified valid ranges and returns number of valid passports.
 * Somehow the output for part two is one too high. (output 115 if correct answer should be 114) Whyyyyyy?!?!
 *
 * @author Fredrik Åslund
 * @version 2020-12-08
 *
 * @var requiredPassInfo The fields a passport must have.
 * @var passports ArrayList where all the passports from input file are stored
 */
public class PassportValidator {
    private ArrayList<String> requiredPassInfo = new ArrayList<>();
    private ArrayList<HashMap> passports = new ArrayList();

    /**
     * This method populates the list of required information for passports.
     */
    // Gör om till HashMap istället.
    public void populate(){
        requiredPassInfo.add("byr"); requiredPassInfo.add("iyr"); requiredPassInfo.add("eyr");
        requiredPassInfo.add("hgt");requiredPassInfo.add("hcl"); requiredPassInfo.add("ecl");
        requiredPassInfo.add("pid");
    }

    /**
     * The method that runs the program and uses helper methods to count the number of valid pasports of the input.
     * @param file Path to the input textfile.
     * @return the number of valid passports
     */
    public void partOne(String file){
        populate();
        collectInput(file);
        int validCounter1 = 0;
        int validCounter2 = 0;

        for(int i = 0; i < passports.size(); i++){
            if(passportIsValidPartOne(passports.get(i), 1)){
                validCounter1++;
                if(passportIsValidPartOne(passports.get(i), 2)){
                    validCounter2++;
                }
            }

        }
        System.out.println("Total passports: "+ passports.size());
        System.out.println("Valid passports in part one: " + validCounter1);
        System.out.println("Valid passports in part two: " + validCounter2);
    }
/*
    public int partTwo(String file){
        populate();
        collectInput(file);
        int validCounter1 = 0;
        int validCounter2 = 0;
        int[] results = null;
        for(int i = 0; i < passports.size(); i++){
            if(passportIsValidPartTwo(passports.get(i))){
                validCounter1++;
            }
        }
        results[0] = validCounter1;
        results[1] = validCounter2;
        System.out.println(results);
        return validCounter1;
    }
 */

    // Gör om till validator för bägge parts på en gång. Kolla om vali innuti if-satsen!
    // Gör en for-each loop som kollar mor requiredPassInfos keyset istället för ArrayList.
    // kanske separat funktion för att kolla att värden stämmer (blir för lång annars)
     public boolean passportIsValidPartOne(HashMap<String, String> input, int part){
        var passport = true;
        if(part == 1) {
            for (int i = 0; i < requiredPassInfo.size(); i++) {
                //String result = input.get(info);
                if (!input.containsKey(requiredPassInfo.get(i))) {
                    passport = false;
                }
            }
        }
        if(part == 2){
//vilken value?!?!?
            //input.forEach((k,v) -> validValue(k,v));
            for(int i = 0; i < requiredPassInfo.size(); i++) {
                if(!validValue(requiredPassInfo.get(i),input.get(requiredPassInfo.get(i)))){
                    passport = false;
                }
            }

        }
        return passport;
     }

    /**
     * Checks if a passport value is within the allowed range.
      * @param key The "field" to check (e.g. "byr" (birth year).
     * @param value The value of the "field" of the passport.
     * @return returns true if the value is valid for the key.
     */
    public boolean validValue(String key, String value){
        var isValid = true;
        List<String> ecls = Arrays.asList("amb", "blu", "brn", "gry", "grn", "hzl", "oth");
// Funkar
        if(((key == "byr") && !((value.length() == 4) && (Integer.valueOf(value) > 1919) &&(Integer.valueOf(value) < 2003)))){
            // byr: four digits, 1920-2002
            isValid = false;
        }
// Funkar
        if(((key == "iyr") && !((value.length() == 4) && (Integer.valueOf(value) > 2009) &&(Integer.valueOf(value) < 2021)))){
            // iyr: four digits, 2010-2020
            isValid = false;
        }
// Funkar
        if(((key.equals("eyr")) && !((value.length() == 4) && (Integer.valueOf(value) > 2019) &&(Integer.valueOf(value) < 2031)))){
            // eyr: four digits, 2020-2030
        isValid = false;
        }
// Funkar
        if(key == "hgt"){
            var height = Integer.valueOf(value.substring(0,value.length()-2));
            System.out.println(height);
            var unit = value.substring(value.length()-2, value.length());
            System.out.println(unit);

            if((unit.equals("cm")) && (height < 150 || height > 193)){
                isValid = false;
            }
            if((unit.equals("in")) && ( height < 59 || height > 76)){
                isValid = false;
            }
            //hgt: either 150-193cm or 59-76in
        }
// Funkar!
        if(key.equals("hcl")){
            if(!(value.substring(0,1).equals("#")) || !(value.length() == 7)){
                isValid = false;
            }
            for(int i = 1; i < value.length(); i++){
                if(Integer.valueOf(value.charAt(i)) < 0 || 9 > Integer.valueOf(value.charAt(i))){
                    isValid = false;
                }
                if(value.charAt(i) > 'f'){
                    isValid = false;
                }
            }

            //hcl: # followed by six characters (0-9) or (a-f)
        }
// Funkar!
        if(key.equals("ecl") && (!ecls.contains(value))){
            isValid = false;
            //ecl: exactly one of amb blu brn gry grn hzl oth
        }
// Funkar!
        if((key.equals("pid")) && (!(value.length() == 9) || !(isNumeric(value)))){
            isValid = false;
            //pid: nine digit number, including leading zeroes
        }
        return isValid;
    }
    // Integer.valueOf(value) <= 999999999
// test plockat från nätet
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

  /**
     * Method to collect passport data from a textfile.
     * Parses the data and stores each passport as a HashMap inside the class ArrayList passports.
     *
     * @param file The textfile from which the passport data is collected ("./day4/input.txt")
     */
    public void collectInput(String file){
        String strCurrentLine;
        ArrayList<String[]> array = new ArrayList<>();

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            int spaceCounter = 0;

            while((strCurrentLine = br.readLine()) != null){
                if(strCurrentLine.length() != 0 ) {
                    array.add(strCurrentLine.split(" "));
                    }
                if(strCurrentLine.length() == 0){
                    spaceCounter++;
                    HashMap<String, String> pass = new HashMap<>();

                    for(int i = 0; i < array.size(); i++){
                        for(int j = 0; j < array.get(i).length; j++){
                            pass.put(array.get(i)[j].split(":")[0], array.get(i)[j].split(":")[1]);
                        }

                    }
                    array.clear();
                    passports.add(pass);

                }
            }
            br.close();
            fr.close();
            System.out.println("Number of spaces: " + spaceCounter);
        }catch (IOException e){
            e.printStackTrace();
        }
     }

    public static void main(String[] args) {
        PassportValidator test = new PassportValidator();
        test.partOne("./day4/input.txt");
    }
}