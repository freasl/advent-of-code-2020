package day3;
import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;

public class Traverse {

    public static void main(String[] args) {
        Traverse pathFinder = new Traverse();
        System.out.println("Part one: " + pathFinder.traverseMap("./day3/input.txt", 3, 1));
        System.out.println("Part two: " + pathFinder.partTwo("./day3/input.txt"));
    }

    public int traverseMap(String input, int xPlus, int yPlus){
        ArrayList<String> map = readFile(input);
        int treeCounter = 0;
        int xPos = 0;

        for(int y = 0; y < map.size(); y = y + yPlus){
            if(xPos > map.get(y).length()-1){
                xPos = xPos - map.get(y).length();
            }
            if(isTreePresent(map.get(y).charAt(xPos))){
                treeCounter++;
            }
            xPos = xPos + xPlus;
        }
        return treeCounter;
    }

    public BigInteger partTwo(String input){
        BigInteger one = BigInteger.valueOf(traverseMap(input, 1, 1));
        BigInteger two = BigInteger.valueOf(traverseMap(input, 3, 1));
        BigInteger three = BigInteger.valueOf(traverseMap(input, 5, 1));
        BigInteger four = BigInteger.valueOf(traverseMap(input, 7, 1));
        BigInteger five = BigInteger.valueOf(traverseMap(input, 1, 2));

        return one.multiply(two.multiply(three.multiply(four.multiply(five))));
    }

    public boolean isTreePresent(char input){
        return input == '#';
    }

    public ArrayList<String> readFile(String file){
        ArrayList<String> travelMap = new ArrayList<>();

        String strCurrentline;

        try{
            FileReader fr = new FileReader(file);
            BufferedReader objReader = new BufferedReader(fr);

            while((strCurrentline = objReader.readLine()) != null){
                travelMap.add(strCurrentline);
            }
            objReader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return travelMap;
    }
}
