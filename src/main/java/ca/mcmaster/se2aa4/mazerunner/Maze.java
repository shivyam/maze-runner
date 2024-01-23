package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.Arrays;
public class Maze{

    private ArrayList<ArrayList<String>> maze= new ArrayList<ArrayList<String>>();

    public Maze(ArrayList<ArrayList<String>> userMaze){
        maze= new ArrayList<ArrayList<String>>(userMaze);

    }


    public ArrayList<String> convertUserPath(String userPath){
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

    //outputs string message verifying if user input path is correct
    public String checkPath(String userPath){
        if (userPath.equals("")){
            return "no input path";
        }

        ArrayList<String> path= convertUserPath(userPath);
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


    //to verify maze ArrayList correctly contained maze
    // public void printMaze(){
    //     for (int i=0; i<maze.size(); i++) {
    //         ArrayList<String> row = new ArrayList<String>(maze.get(i));
    //         for (int j=0; j<row.size(); j++) {
    //             System.out.print(row.get(j)); 
    //         }
    //         System.out.println("");
    //     }
        
    // }

}