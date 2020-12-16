package day7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LuggageProcessing {
    ArrayList<BagRule> rules = new ArrayList<>();

    public static void main(String[] args) {
        LuggageProcessing processing = new LuggageProcessing();
    }

    public LuggageProcessing(){
        collectInput("./day7/input.txt");
        System.out.println(rules.get(rules.size()-1).getRawInput());
    }
    private void collectInput(String file){
        String strCurrentLine = "";
        try{
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        while((strCurrentLine = br.readLine()) != null){
            rules.add(new BagRule(strCurrentLine));
        }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
