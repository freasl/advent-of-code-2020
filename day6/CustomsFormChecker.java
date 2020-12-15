package day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CustomsFormChecker {
    public static void main(String[] args) {
        CustomsFormChecker day6 = new CustomsFormChecker("./day6/input.txt");


    }


    ArrayList<PassengerGroup> groups = new ArrayList<>();

    public CustomsFormChecker(String file){
        collectInput(file);
        System.out.println("Part one: " + partOne());
        System.out.println("Part two: " +partTwo());
        System.out.println(groups.get(groups.size()-2).getAnswers());
        System.out.println(groups.get(groups.size()-1).getAnswers());
    }

    public int partOne(){
        int sum = 0;
        for(int i = 0; i < groups.size(); i++){
            sum = sum + groups.get(i).getAnswers().size();
        }
        return sum;
    }

    public int partTwo(){
        int sum = 0;
        for(int i = 0; i < groups.size(); i++){
            sum = sum + groups.get(i).getSumPartTwo();
        }
        return sum;
    }

    private void collectInput(String file){
        String strCurrentLine;
        ArrayList<String> lines = new ArrayList<>();

        try{
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);


            while((strCurrentLine = br.readLine()) != null){
                if(strCurrentLine.length() != 0){
                    lines.add(strCurrentLine);
                }
                if(strCurrentLine.length() == 0){
                    groups.add(new PassengerGroup(lines));
                    lines.clear();
                }
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        groups.add(new PassengerGroup(lines));
    }
}
