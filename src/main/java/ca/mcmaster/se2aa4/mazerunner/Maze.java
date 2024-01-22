package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

public class Maze{

    private ArrayList<ArrayList<String>> maze= new ArrayList<ArrayList<String>>();

    public Maze(ArrayList<ArrayList<String>> userMaze){
        maze= new ArrayList<ArrayList<String>>(userMaze);

    }

    //returns the row from the first column that the entry tile is located on
    public int findEntryTile(){
        for (int i=0;i<maze.size();i++){
            ArrayList<String> row = new ArrayList<String>(maze.get(i));

            if (row.get(0).equals("PASS ")){
                return i;
            }
        }
        return 0;
    }


    //finds path in the form "FFFRRFFLLF"
    public String findCanonicalPath(){
        String path="";
        return "FFFF";
    }

    //outputs path in the form "3F2R2F2LF"
    public String findFactorizedPath(){
        return "4F";
    }


    //outputs string message verifying if user input path is correct
    public String checkPath(String userPath){
        String rightPath= findCanonicalPath();
        boolean flag= false;

        //implement to check if user path is valid
        if(userPath==rightPath){
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