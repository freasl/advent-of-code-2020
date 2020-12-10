package day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class BoardingPassChecker {
    ArrayList<String> rawList = new ArrayList<>();
    ArrayList<BoardingPass> boardingPassList = new ArrayList<>();
    ArrayList<Integer> seatIdList = new ArrayList<Integer>();
    int rowsOnPlane;
    int columnsOnPlane;
    int highestSeatId;

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
    public int findYourSeat(ArrayList<Integer> list){
        int yourSeat = 0;
        for(int i = 1; i < (list.size() -1); i++){
            if(list.get(i) - list.get(i-1) == 2){
                yourSeat =  list.get(i)-1;
            }
        }
        return yourSeat;
    }

    public void makeBoardingPasses(ArrayList<String> input){
        for(String element: input){
            BoardingPass pass = new BoardingPass(element, this.rowsOnPlane, this.columnsOnPlane);
            boardingPassList.add(pass);
            seatIdList.add(pass.getSeatId());
        }
        Collections.sort(seatIdList);
    }
    public void checkPassportsForHighestId(){
        for(BoardingPass pass: boardingPassList){
            var seatId = pass.getSeatId();
            if(seatId > highestSeatId){
                highestSeatId = seatId;
            }
        }
    }
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
