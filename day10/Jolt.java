package day10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Jolt {
    ArrayList<Integer> adapters = new ArrayList<>();

    public static void main(String[] args) {
        Jolt jolt = new Jolt("./day10/input.txt");
    }

    public Jolt(String file){
        collectInput(file);
        System.out.println("Part one: " + partOne(adapters));
        System.out.println("Part two: " + partTwo(adapters));
    }
    public int partTwo(ArrayList<Integer> input){
        int sum = 0;


        for (int i = 1; i < input.size(); i++){
            ArrayList<Integer> temp = new ArrayList<>(input);
            temp.remove(i);
            if (partOne(temp) != -1){
                sum++;

            }
        }

        return sum;
    }

    public int partOne(ArrayList<Integer> input){
        int one = 1;
        int three = 1;

        ArrayList<Integer> list = new ArrayList(input);
        Collections.sort(list);
        //System.out.println(list);

        for (int i = 1; i < list.size(); i++){
            if (list.get(i) - list.get(i-1) == 1){
                one++;
            }else if (list.get(i) - list.get(i-1) == 3){
                three++;
            }else if(list.get(i) - list.get(i-1) > 3){
                return -1;
            }
        }
        //System.out.println(one);
        //System.out.println(three);
        return one*three;
    }

    public void collectInput(String file){
        String strCurrentLine;
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            while ((strCurrentLine = br.readLine()) != null){
                adapters.add(Integer.valueOf(strCurrentLine));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
