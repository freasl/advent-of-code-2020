package day10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Jolt {
    ArrayList<Integer> adapters = new ArrayList<>();

    public static void main(String[] args) {
        Jolt jolt = new Jolt("./day10/test.txt");
    }

    public Jolt(String file){
        collectInput(file);
        System.out.println(adapters);
        Collections.sort(adapters);
        System.out.println(adapters);
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
