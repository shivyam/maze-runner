package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.Arrays;
public class CheckPath{

    public Maze dummyMaze;
    public String userPath;

    public CheckPath(Maze maze, String userPath){
        this.dummyMaze= maze;
        this.userPath= userPath;
    }

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
    public String checkPath(){

        //if no path is inputted
        if (userPath.equals("")){
            return "no input path";
        }

        ArrayList<String> path= convertUserPath(userPath);
       

        int currColumn=0;
        int currRow= dummyMaze.findEntryTile();
        
        int endRow = dummyMaze.findExitTile();
        int width= dummyMaze.getWidth();

        int height = dummyMaze.getHeight();
        System.out.println(dummyMaze.getTile(currRow,currColumn));

        int index=0;
        while(currColumn<=(width-1) && currColumn>=0 && currRow>=0 && currRow<=(height-1) && index<path.size()){
                if(dummyMaze.getTile(currRow,currColumn)=="WALL "){
                    return "incorrect path";
                }
                if(path.get(index).equals("F")){
                    //System.out.println("im here");
                    currColumn+=1;
                    //System.out.println("Num: " +currColumn);
                }
                index+=1;
                
        }
        
        //System.out.println("Current Row: " + currRow + "End Row: " + (endRow) + "Current Column: " + currColumn + "    "  + "End Column: " + (width) );
        if(currRow==(endRow) && currColumn==(width)){
                return "correct path";
        }
        else{
            return "incorrect path";
        }
        
    }
}