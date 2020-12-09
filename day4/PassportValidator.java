package day4;

import day2.PasswordValidator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Day 4 of Advent of Code 2020!
 *
 * Part one returns the number of valid passports according to the rules:
 *  cid is optional, all other fields must be present.
 *
 * @author Fredrik Åslund
 * @version 2020-12-08
 *
 * @field requiredPassInfo The fields a passport must have.
 * @field passports ArrayList where all the passports from input file are stored
 */
public class PassportValidator {
    private ArrayList<String> requiredPassInfo = new ArrayList<>();
    private ArrayList<HashMap> passports = new ArrayList();

    /**
     * This method populates the list of passport fields.
     */
    public void populate(){
        requiredPassInfo.add("byr"); requiredPassInfo.add("iyr"); requiredPassInfo.add("eyr");
        requiredPassInfo.add("hgt");requiredPassInfo.add("hcl"); requiredPassInfo.add("ecl");
        requiredPassInfo.add("pid");
    }


    public int partOne(String file){
        populate();
        collectInput(file);
        int validCounter = 0;

        for(int i = 0; i < passports.size(); i++){
            if(passportIsValidPartOne(passports.get(i))){
                validCounter++;
            }
        }
        return validCounter;
    }

    public int partTwo(String file){
        populate();
        collectInput(file);
        int validCounter = 0;
        for(int i = 0; i < passports.size(); i++){
            if(passportIsValidPartTwo(passports.get(i))){
                validCounter++;
            }
        }
        return validCounter;
    }

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
    public boolean passportIsValidPartTwo(HashMap<String,String> input){
        return false;
    }
    public boolean passportIsValidPartOne(HashMap<String, String> input){
        var passport = true;
        for(int i = 0; i< requiredPassInfo.size(); i++){
            //String result = input.get(info);
            if(!input.containsKey(requiredPassInfo.get(i))){
                passport = false;
                }
        }
        return passport;
    }

    // Obs! Läser in tomma rader också. Nej, fixat, men varje rad i eget element i array.
    // Fixa: varje pass en egen hashmap, alla hashmaps i en array.

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
        System.out.println("Part one: " + test.partOne("./day4/input.txt"));
        System.out.println("Part two: ");
    }
}

/*
Collect data from input.txt
Each passport is represented in the form of key:value and pairs are separated by space or newline.
Passports are separated by blank lines.
 */
