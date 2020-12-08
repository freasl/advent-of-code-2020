package day4;

import day2.PasswordValidator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Day 4 of Advent of Code 2020!
 *
 * Passports are collected and parsed from input.txt
 *
 * Part one returns the number of valid passports according to the rules:
 *  cid is optional, all other fields must be present.
 */
public class PassportValidator {
    private int byr;    // Birth year
    private int iyr;    // Issue year
    private int eyr;    // Expiration year
    private String hgt; // Height
    private String hcl; // Hair color
    private String ecl; // Eye color
    private String pid; // Passport ID
    private String cid; // Country ID (optional!)

    // Obs! Läser in tomma rader också.
    public void collectInput(String file){
        String strCurrentLine;
        ArrayList<String[]> array = new ArrayList<>();
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            while((strCurrentLine = br.readLine()) != null){
                array.add(strCurrentLine.split(" "));
            }
            br.close();
            fr.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(array.get(2)[0]);
        System.out.println(array.get(2)[1]);
        System.out.println(array.get(0)[2]);
    }

    public static void main(String[] args) {
        PassportValidator test = new PassportValidator();
        test.collectInput("./day4/input.txt");
    }
}

/*
Collect data from input.txt
Each passport is represented in the form of key:value and pairs are separated by space or newline.
Passports are separated by blank lines.
 */
