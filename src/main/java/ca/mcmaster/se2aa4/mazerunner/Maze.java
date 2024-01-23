package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.Arrays;

public class Maze{

    private ArrayList<ArrayList<String>> maze= new ArrayList<ArrayList<String>>();

    public Maze(ArrayList<ArrayList<String>> userMaze){
        maze= new ArrayList<ArrayList<String>>(userMaze);

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