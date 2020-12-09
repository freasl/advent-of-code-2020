package day1;

import java.io.*;
import java.util.ArrayList;

class Report {
    private ArrayList<Integer> numbers = new ArrayList<>();
    private int expected = 2020;

    public void readFile(String file){

        String strCurrentLine;
    
    
        try{
          FileReader fr = new FileReader(file);
          BufferedReader objReader = new BufferedReader(fr);
    
          while ((strCurrentLine = objReader.readLine()) != null) {
            numbers.add(Integer.valueOf(strCurrentLine));
            }
            objReader.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void solvePartOne(){
          int firstNumber;
          int secondNumber;
        //System.out.println(numbers);

        for(int i = 0; i < numbers.size(); i++){
            firstNumber = numbers.get(i);
            for(int j = i+1; j < numbers.size(); j++){
                secondNumber = numbers.get(j);
                if(firstNumber+secondNumber == expected){
                    System.out.println("Solution to part one: " + (firstNumber*secondNumber));
                }
            }
        }
    }

    public void solvePartTwo(){
        int firstNumber;
        int secondNumber;
        int thirdNumber;
      //System.out.println(numbers);

      for(int i = 0; i < numbers.size(); i++){
          firstNumber = numbers.get(i);
          for(int j = i+1; j < numbers.size(); j++){
              secondNumber = numbers.get(j);
              for(int k = j+1; k < numbers.size(); k++){
                    thirdNumber = numbers.get(k);
                    if(firstNumber+secondNumber+thirdNumber == expected){
                        System.out.println("Solution to part two: " + (firstNumber*secondNumber*thirdNumber));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Report report = new Report();
        report.readFile("input.txt");
        report.solvePartOne();
        report.solvePartTwo();
    }
}