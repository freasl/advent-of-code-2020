package day6;

import java.util.ArrayList;

public class CustomsForm {
    private ArrayList<Character> answers = new ArrayList<>();
     public CustomsForm(String input){
         for(int i = 0; i < input.length(); i++){
             answers.add(input.charAt(i));
         }
    }

    public ArrayList<Character> getAnswers() {
        return answers;
    }

    public boolean answeredYes(char c){
         if(answers.contains(c)){
             return true;
         }
         return false;
    }
}
