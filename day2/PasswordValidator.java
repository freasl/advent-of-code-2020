package day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PasswordValidator {

    public void validatePasswords(){
        var validCounter = 0;
        ArrayList<String> passList = readFile("day2/input.txt");

        for(int i = 0; i < passList.size(); i++){
            if(isValid(passList.get(i)) == true){
                validCounter++;
            }
        }
        System.out.println("1: There are " + validCounter + " valid passwords in the file.");
    }

    public void partTwo(){
        var validCounter = 0;
        ArrayList<String> passList = readFile("day2/input.txt");
        for(int i = 0; i < passList.size(); i++){
            if(secondValidator(passList.get(i)) == true){
                validCounter++;
            }
        }
        System.out.println("2: There are " + validCounter + " valid passwords in the file");
    }
    public boolean secondValidator(String input){
        var pair = input.split(":");
        var policy = pair[0];
        var password = pair[1];

        var bits = policy.split(" ");
        var digitsString = bits[0].split("-");
        int[] digits = new int[digitsString.length];

        for(int i = 0; i < digitsString.length; i++){
            digits[i] = Integer.valueOf(digitsString[i]);
        }
        char letter = bits[1].charAt(0);
        int counter = 0;
        //System.out.println(digits[0] + digits[1]);
        //System.out.println(letter);
        //System.out.println(password.length());

        if((password.charAt(digits[0]) == letter && password.charAt(digits[1]) != letter) || (password.charAt(digits[0]) != letter && password.charAt(digits[1]) == letter)){
                return true;
            }

        return false;
    }

    public boolean isValid(String input){
        var pair = input.split(":");
        var policy = pair[0];
        var password = pair[1];

        var bits = policy.split(" ");
        var digitsString = bits[0].split("-");
        int[] digits = new int[digitsString.length];

        for(int i = 0; i < digitsString.length; i++){
            digits[i] = Integer.valueOf(digitsString[i]);
        }
        char letter = bits[1].charAt(0);
        int counter = 0;
        //System.out.println(digits[0] + digits[1]);
        //System.out.println(letter);
        //System.out.println(password.length());

        for(int i = 0; i < password.length(); i++){
            if(password.charAt(i) == (letter)){
                counter++;
            }
        }
        //System.out.println(counter);
        if(counter >= digits[0] && counter <= digits[1]){
            //System.out.println("Password" + password + " contains " + counter + " " + letter + " and is valid.");
            return true;
        }
        //System.out.println("Password " + password + " contains " + counter + " " + letter + " and is not valid.");
        return false;
    }
    public ArrayList<String> readFile(String file){
        ArrayList<String> list = new ArrayList<>();
        String strCurrentLine;


        try{
            FileReader fr = new FileReader(file);
            BufferedReader objReader = new BufferedReader(fr);

            while ((strCurrentLine = objReader.readLine()) != null) {
                list.add(strCurrentLine);
            }
            objReader.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        PasswordValidator test = new PasswordValidator();
        //test.isValid("16-18 h: hhhhhhhhhhhhhhhhhh");
        //test.isValid("3-9 r: pplzctdrc");
        //test.isValid("4-14 d: lxdmddfddddddd");
        test.validatePasswords();
        test.partTwo();
    }
}
