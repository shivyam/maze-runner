package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.Arrays;
public class CheckPath{

    //Converts and returns user input path in canonical form, and strips all whitespace fro inputted apth

    public ArrayList<String> convertUserPath(String userPath){

        //strips whitespace from user input path
        String path = userPath.replaceAll("\\s", "");
        String[] path_arr= path.split("");
        ArrayList<String> canonicalPath= new ArrayList<>();
        int repetition=1;

        for(int i=0;i<path_arr.length;i++){
            if(!(path_arr[i].equals("F")) && !(path_arr[i].equals("L")) &&!(path_arr[i].equals("R"))){
                repetition= Integer.parseInt(path_arr[i]);
                continue;
            }

            else{
                for(int j=0;j<repetition;j++){
                    canonicalPath.add(path_arr[i]);
                }
                repetition=1;
            }
        }
        return canonicalPath;
    }

    //outputs string message verifying if user input path is correct or not
    public String checkPath(String userPath){

        //if no path is inputted
        if (userPath.equals("")){
            return "no input path";
        }

        ArrayList<String> path= convertUserPath(userPath);
        //flag is true 
        boolean flag= false;

        for (String item : path) {
            System.out.print(item);
        }

        

        if(flag){
            flag= true;
        }

        if(flag){
            return "correct path";
        }

        return "incorrect path";
        
    }
}