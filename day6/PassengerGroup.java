package day6;

import java.util.ArrayList;

public class PassengerGroup {
    private ArrayList<CustomsForm> forms = new ArrayList<>();
    private ArrayList<Character> answers = new ArrayList<>();


    public PassengerGroup(ArrayList<String> input){
        for(int i = 0; i < input.size(); i++){
            forms.add(new CustomsForm(input.get(i)));
        }
        checkAnswers();
    }

    public ArrayList<CustomsForm> getForms() {
        return forms;
    }

    public ArrayList<Character> getAnswers() {
        return answers;
    }

    public int getSum(){
        int sum = 0;
        for(int i = 0; i < forms.size(); i++){
            for(int j = 0; j < forms.get(i).getAnswers().size(); j++){
                if(!answers.contains(forms.get(i).getAnswers().get(j))){
                    answers.add(forms.get(i).getAnswers().get(j));
                    sum++;
                }
            }
        }
        return sum;
    }
    public int getSumPartTwo(){
        int sum = 0;
        for(char c = 'a'; c <= 'z'; c++){
            if(isPresentInAll(c)){
                sum++;
            }

        }
        return sum;
    }
    private boolean isPresentInAll(char c){
        for(int i = 0; i < forms.size(); i++){
            if(!forms.get(i).answeredYes(c)){
                return false;
            }
        }
        return true;
    }

    public void checkAnswers(){
        int total = 0;
        for(int i = 0; i < forms.size(); i++){
            for(int j = 0; j < forms.get(i).getAnswers().size(); j++){
                if(!answers.contains(forms.get(i).getAnswers().get(j))){
                    answers.add(forms.get(i).getAnswers().get(j));
                }
            }
        }
    }
}

