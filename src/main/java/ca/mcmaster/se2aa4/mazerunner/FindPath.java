package ca.mcmaster.se2aa4.mazerunner;
import java.util.ArrayList;
import java.util.Arrays;

public class FindPath{

    public Maze dummyMaze;
    Direction dir;
    int currColumn=0;
    int currRow;


    public FindPath(Maze maze){
        this.dummyMaze= maze;
        this.dir= new Direction(dummyMaze);
    }



   
    // //finds path in the form "FFFRRFFLLF"
    // public String findCanonicalPath(){
        
        
    //     ArrayList<String> path= new ArrayList<String>();
        
        
    //     int end = dummyMaze.findExitTile();
    //     int width= dummyMaze.getWidth();
    //     int height = dummyMaze.getHeight();
    
    //     while(currColumn<=(width-1) && currColumn>=0 && currRow>=0 && currRow<=(height-1) && dummyMaze.getTile(currRow,currColumn)!="WALL "){
    //         if(dir.getDirection().equals("east")){
    //             if(dummyMaze.getTile(currRow+1, currColumn)=="WALL " && dummyMaze.getTile(currRow, currColumn+1)!="WALL "){
    //             currColumn+=1;
    //             path.add("F");
    //         }
    //             else if (dummyMaze.getTile(currRow, currColumn+1)=="WALL " && dummyMaze.getTile(currRow+1, currColumn)=="WALL "){
    //                 dir.turnLeft();
    //                 path.add("L");
    //                 moveForward();
    //                 path.add("F");
    //             }
    //             else{
    //                 dir.turnRight();
    //                 path.add("R");
    //                 moveForward();
    //                 path.add("F");
    //             }

    //         }
            

    //         else if(dir.getDirection().equals("north")){
    //             if(dummyMaze.getTile(currRow, currColumn+1)=="WALL " && dummyMaze.getTile(currRow-1, currColumn)!="WALL "){
    //             currRow-=1;
    //             path.add("F");
    //         }
    //             else if (dummyMaze.getTile(currRow-1, currColumn)=="WALL " && dummyMaze.getTile(currRow, currColumn+1)=="WALL "){
    //                 dir.turnLeft();
    //                 path.add("L");
    //                 moveForward();
    //                 path.add("F");
    //             }
    //             else{
    //                 dir.turnRight();
    //                 path.add("R");
    //                 moveForward();
    //                 path.add("F");
    //             }

    //         }

    //         else if(dir.getDirection().equals("south")){
    //             if(dummyMaze.getTile(currRow, currColumn-1)=="WALL " && dummyMaze.getTile(currRow+1, currColumn)!="WALL "){
    //             currRow+=1;
    //             path.add("F");
    //         }
    //             else if (dummyMaze.getTile(currRow+1, currColumn)=="WALL " && dummyMaze.getTile(currRow-1, currColumn)=="WALL "){
    //                 dir.turnLeft();
    //                 path.add("L");
    //                 moveForward();
    //                 path.add("F");
    //             }
    //             else{
    //                 dir.turnRight();
    //                 path.add("R");
    //                 moveForward();
    //                 path.add("F");
    //             }

    //         }

    //         else{
    //             if(dummyMaze.getTile(currRow-1, currColumn)=="WALL " && dummyMaze.getTile(currRow, currColumn-1)!="WALL "){
    //             currColumn-=1;
    //             path.add("F");
    //         }
    //             else if (dummyMaze.getTile(currRow-1, currColumn)=="WALL " && dummyMaze.getTile(currRow, currColumn-1)=="WALL "){
    //                 dir.turnLeft();
    //                 path.add("L");
    //                 moveForward();
    //                 path.add("F");
    //             }
    //             else{
    //                 dir.turnRight();
    //                 path.add("R");
    //                 moveForward();
    //                 path.add("F");
    //             }

    //         }   
            
            
    //     }
        
    //     String strPath = String.join("",path);

    //     return strPath;
    // }    
    



        //finds path in the form "FFFRRFFLLF"
    public String findCanonicalPath(){
        
        currRow= dummyMaze.findEntryTile();
        ArrayList<String> path= new ArrayList<String>();
        
        
        int end = dummyMaze.findExitTile();
        int width= dummyMaze.getWidth();
        int height = dummyMaze.getHeight();
    
        // while(currColumn<=(width-1) && currColumn>=0 && currRow>=0 && currRow<=(height-1) && dummyMaze.getTile(currRow,currColumn)!="WALL "){
            

        //     }
            

        // }
        
        String strPath = String.join("",path);

        return strPath;
    }    
    

    public void moveForward(){
        String direction= dir.getDirection();
        if(direction.equals("north")){
            currRow=dir.moveNorth(currRow);
        }
        else if(direction.equals("east")){
            currColumn=dir.moveEast(currColumn);
        }
        else if(direction.equals("south")){
            currRow=dir.moveSouth(currRow);
        }
        else{
            currColumn= dir.moveWest(currColumn);
        }
    }

    






















    //uses findCanonicalPath method to find maze path, then outputs path in the form "3F2R2F2LF"
    public String findFactorizedPath(){
        String path = findCanonicalPath();
        String[] path_arr= path.split("");

        if(path_arr.length==0){
            return "";
        }

        ArrayList<String> factorizedPath= new ArrayList<String>();
        int repetition=1;
        String track= path_arr[0];
        
        for(int i=1;i<path_arr.length;i++){
            if (path_arr[i].equals(track)){
                repetition+=1;
            }
            else{
                System.out.println("hello");
                factorizedPath.add(String.valueOf(repetition) + track);
                track= path_arr[i];
                repetition=1;
            }   
        }

        factorizedPath.add(repetition + path_arr[path_arr.length - 1]);
        String strFactorizedPath = String.join("", factorizedPath);
        return strFactorizedPath;
    }


}