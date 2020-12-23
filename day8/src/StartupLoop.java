import java.io.*;
import java.util.ArrayList;

public class StartupLoop {

    public static void main(String[] args) {
        StartupLoop loop = new StartupLoop("./day8/src/input.txt");
    }

    public ArrayList<String> operations = new ArrayList<>();
    public ArrayList<Integer> visitedOperations = new ArrayList<>();
    public int i = 0;


    public StartupLoop(String file){
        collectInput(file);
        System.out.println("Part one: " + operationsProcessor());
        partTwo();

    }

    public int partTwo(){
        int num = 0;

        while (i != operations.size()-1) {
            String originalElement = operations.get(i);
            if (originalElement.split(" ")[0].equals("jmp")){
                operations.set(i, "nop" + originalElement.substring(3));
                visitedOperations.clear();
                num = operationsProcessor();

                operations.set(i, originalElement);
            }else if(originalElement.split(" ")[0].equals("nop")){
                operations.set(i, "jmp" + originalElement.substring(3));
                visitedOperations.clear();
                num = operationsProcessor();

                operations.set(i, originalElement);
            }

            i++;
            //System.out.println(i);
        }
        return num;
    }

    public int operationsProcessor(){
        int accumulator = 0;
        int i = 0;
        while (!visitedOperations.contains(i)){
                visitedOperations.add(i);
                if (operations.get(i).split(" ")[0].equals("acc")){
                    if (operations.get(i).split(" ")[1].charAt(0) == '+'){
                        accumulator += Integer.parseInt(operations.get(i).split(" ")[1].substring(1));
                    }else if (operations.get(i).split(" ")[1].charAt(0) == '-'){
                        accumulator -= Integer.parseInt(operations.get(i).split(" ")[1].substring(1));
                    }
                    i++;
                }else if (operations.get(i).split(" ")[0].equals("jmp")){
                    if (operations.get(i).split(" ")[1].charAt(0) == '+'){
                        i = i + Integer.parseInt(operations.get(i).split(" ")[1].substring(1));
                        //if (i >= operations.size()){
                          //  i = i - operations.size();
                     //   }
                    }else if (operations.get(i).split(" ")[1].charAt(0) == '-'){
                        i = i - Integer.parseInt(operations.get(i).split(" ")[1].substring(1));
                    }
                   // i += Integer.parseInt(operations.get(i).split(" ")[1]);
                  //  if (i >= operations.size()-1){
                    //    i -= operations.size();
                   // }
                }else if (operations.get(i).split(" ")[0].equals("nop")){
                    i++;
                }
           // }
            if (i == operations.size()-1){
                System.out.println("finito: " +accumulator);
                break;
            }
        }

        //System.out.println(accumulator);
        return accumulator;
    }

    public void collectInput(String file){
        String strCurrentLine;
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while ((strCurrentLine = br.readLine()) != null){
                operations.add(strCurrentLine);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
