package day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Advent of Code 2020, day 5 - Binary Boarding
 *
 * @author Fredrik Åslund
 * @version 2020-12-10
 */
public class BoardingPassChecker {
    ArrayList<String> rawList = new ArrayList<>();
    ArrayList<BoardingPass> boardingPassList = new ArrayList<>();
    ArrayList<Integer> seatIdList = new ArrayList<>();
    int rowsOnPlane;
    int columnsOnPlane;
    int highestSeatId;

    /**
     * Constructor just runs the checks and prints output to console.
     * @param file path to the input
     * @param rows number of rows on the airplane
     * @param columns number of columns on the airplane
     */
    public BoardingPassChecker(String file, int rows, int columns){
        this.rowsOnPlane = rows;
        this.columnsOnPlane = columns;
        readFile(file);
        makeBoardingPasses(rawList);
        checkPassportsForHighestId();
        System.out.println("Advent of Code 2020, Day 5");
        System.out.println("**************************");
        System.out.println("Highest seat ID in list: " + highestSeatId);
        System.out.println("Your seat ID: " + findYourSeat(seatIdList));
    }

    /**
     * Finds your seat by checking the list of seats to search for missing element in sorted list.
     * @param list list of boardingpass seat IDs collected from the input
     * @return your seat (the one missing from the list)
     */
    public int findYourSeat(ArrayList<Integer> list){
        int yourSeat = 0;
        for(int i = 1; i < (list.size() -1); i++){
            if(list.get(i) - list.get(i-1) == 2){
                // -1 because it is missing from the list (e.g. [...100,102,...] means your seat is 100)
                yourSeat =  list.get(i)-1;
            }
        }
        return yourSeat;
    }

    /**
     * Uses the raw data that has been collected from input.txt to create BoardingPass objects,
     * stores them inside list boardingPassList, and finally sorts it for easy search.
     * @param input ArrayList containing the raw data from file. Each element is one row from the file.
     */
    public void makeBoardingPasses(ArrayList<String> input){
        for(String element: input){
            BoardingPass pass = new BoardingPass(element, this.rowsOnPlane, this.columnsOnPlane);
            boardingPassList.add(pass);
            seatIdList.add(pass.getSeatId());
        }
        Collections.sort(seatIdList);
    }

    /**
     * Loops through boardingPassList and returns the highest value for seat ID.
     */
    public void checkPassportsForHighestId(){
        for(BoardingPass pass: boardingPassList){
            var seatId = pass.getSeatId();
            if(seatId > highestSeatId){
                highestSeatId = seatId;
            }
        }
    }

    /**
     * Reads a textfile and stores each line in a list.
     * @param file path to the file
     */
    public void readFile(String file){

        String strCurrentLine;


        try{
            FileReader fr = new FileReader(file);
            BufferedReader objReader = new BufferedReader(fr);

            while ((strCurrentLine = objReader.readLine()) != null) {
                rawList.add(strCurrentLine);
            }
            objReader.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BoardingPassChecker checker = new BoardingPassChecker("./day5/input.txt", 128, 8);
    }

}
