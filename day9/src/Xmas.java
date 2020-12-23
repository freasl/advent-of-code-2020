import java.io.*;
import java.util.*;

public class Xmas {
    ArrayList<Long> xmas = new ArrayList<>();



    public Xmas(){
        collectInput("./day9/src/input.txt");
        long number = finder(xmas, 25);
        partTwo(number, xmas);
    }

    public long partTwo(long number, ArrayList<Long> list){
        //int i = 0;
        long sum = 0;
        int answer = 0;
        ArrayList<Long> answerRange = new ArrayList<>();

        while (sum != number){
            if(sum < number){
                sum = number;
            }
        }

        for (int i = 0; i < list.size(); i++){
            sum = list.get(i);
            if (sum < number){
                for (int j = i+1; j <list.size(); j++){
                    sum += list.get(j);
                    if (sum == number){
                        //System.out.println("j: " + j + " i: " + i);
                        for (int z = i; z < j; z++) {
                            answerRange.add(list.get(z));
                        }
                            Collections.sort(answerRange);
                            System.out.println("Part two: " + (answerRange.get(0) + answerRange.get(answerRange.size()-1)));

                        //System.out.println("Part two: " + (list.get(i) + list.get(j)) + " length: " + String.valueOf((list.get(i) + list.get(j))).length());
                    }else if (sum>number){
                        sum = 0;
                        break;
                    }
                }
            }else if (sum == number){
                //System.out.println(i+j);
                break;
            }else if (sum > number){
                sum = 0;
            }
        }
       return answer;
    }
    public long finder(ArrayList<Long> input, int preamble) {
        long x = 0;
        long y = 0;
        int number = -1;
        boolean numberFound = false;
        for (int i = preamble; i < input.size(); i++){
            numberFound = false;
            for (int j =  i - preamble; j < i; j++){
                x = input.get(j);
                for (int k = j+1; k < i; k++){
                    //System.out.println("i: " + i + ", j: " + j + ", k: " + k);
                    y = input.get(k);
                    //System.out.println(x+"+"+y+"="+(x+y) + ", i ="+ input.get(i));
                    if (x + y == input.get(i)){
                        numberFound = true;
                        //System.out.println("brejk");
                        break;
                    }
                }

            }if (!numberFound){
                System.out.println("Part one: " + input.get(i));
                return input.get(i);}
        }
        /*
        while (!numberFound) {
            for (int j = i - 5; j < i; j++) {
                boolean foundMatch = false;
                x = input.get(j);
                for (int k = j + 1; k < i; k++) {
                    y = input.get(k);
                    if (x + y == input.get(i)) {
                        foundMatch = true;
                        break;
                    }
                }
                if (!foundMatch) return input.get(i);

            }
        }

         */
        return -1;
    }


    public void collectInput(String file){
        String strCurrentLine;
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            while ((strCurrentLine = br.readLine()) != null){
                xmas.add(Long.parseLong(strCurrentLine));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Xmas day9 = new Xmas();
    }
}
