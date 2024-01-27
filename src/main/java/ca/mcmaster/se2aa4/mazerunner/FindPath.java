package ca.mcmaster.se2aa4.mazerunner;
import java.util.ArrayList;
import java.util.Arrays;

public class FindPath{

    public Maze dummyMaze;
    Direction dir;
    int currColumn=0;
    int currRow;
    ArrayList<String> path= new ArrayList<String>();
    int width;
    int height;
    int endRow;

    public FindPath(Maze maze){
        this.dummyMaze= maze;
        this.dir= new Direction(dummyMaze);
        this.width= dummyMaze.getWidth();
        this.height= dummyMaze.getHeight();
        this.endRow= dummyMaze.findExitTile();
        this.currRow= dummyMaze.findEntryTile();
    }


    //finds path in the form "FFFRRFFLLF"
    public String findCanonicalPath(){
        
        

        String strPath;
        int count=0;

        if(canMoveForward()){
                moveForward();
            }

        while(currRow!=endRow|| currColumn!=(width-1)){
            if(canTurnRight()){
                turnRight();
                path.add("R");
                moveForward();
            }

            else if(canMoveForward()){
                moveForward();
            }
            else if(canTurnLeft()){
                turnLeft();
                path.add("L");
                moveForward();
            }
            else{
                turnLeft();
                path.add("L");
                turnLeft();
                path.add("L");
                moveForward();
            }
            count+=1;
        }
    
            //System.out.println("Row:  " + currRow +  "     endRow Row:   " + endRow +  "   Column:    " + currColumn + "      endRow Column: " +   (width-1));
            if(currRow==endRow && currColumn==(width-1)){
                strPath = String.join("",path);
                return strPath;
            }

            strPath = String.join("",path);
            dummyMaze.printMaze();
            return strPath;
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
                if(repetition>1){
                    factorizedPath.add(String.valueOf(repetition) + track);
                }
                else{
                    factorizedPath.add(track);
                }
                track= path_arr[i];
                repetition=1;
            }   
        }

        if(repetition>1){
            factorizedPath.add(repetition + path_arr[path_arr.length - 1]);
        }
        else{
            factorizedPath.add(path_arr[path_arr.length - 1]);
        }
        
        String strFactorizedPath = String.join("", factorizedPath);
        return strFactorizedPath;
    }

        

    public boolean canTurnRight(){
        String direction= dir.getDirection();
        if(direction.equals("east")){
            if(!(dummyMaze.getTile(currRow+1,currColumn).equals("WALL "))){
                return true;
            }
        }
        else if(direction.equals("south")){
            if(!(dummyMaze.getTile(currRow,currColumn-1).equals("WALL "))){
                return true;
            }
        }
        else if(direction.equals("west")){
            if(!(dummyMaze.getTile(currRow-1,currColumn).equals("WALL "))){
                return true;
            }
        }
        else{
            if(!(dummyMaze.getTile(currRow,currColumn+1).equals("WALL "))){
                return true;
            }
        }
        return false;
    }



   

    public boolean canTurnLeft(){
        String direction= dir.getDirection();
        if(direction.equals("east")){
            if(!(dummyMaze.getTile(currRow-1,currColumn).equals("WALL "))){
                return true;
            }
        }
        else if(direction.equals("south")){
            if(!(dummyMaze.getTile(currRow,currColumn+1).equals("WALL "))){
                return true;
            }
        }
        else if(direction.equals("west")){
            if(!(dummyMaze.getTile(currRow+1,currColumn).equals("WALL "))){
                return true;
            }
        }
        else{
            if(!(dummyMaze.getTile(currRow,currColumn-1).equals("WALL "))){
                return true;
            }
        }
        return false;
    }



    public void turnRight(){
        String direction= dir.getDirection();
        if(direction.equals("east")){
            dir.setDirection("south");
        }
        else if(direction.equals("south")){
            dir.setDirection("west");
        }
        else if(direction.equals("west")){
            dir.setDirection("north");
        }
        else{
            dir.setDirection("east");
        }
        
    }


    public void turnLeft(){
        String direction= dir.getDirection();
        if(direction.equals("east")){
            dir.setDirection("north");
        }
        else if(direction.equals("south")){
            dir.setDirection("east");
        }
        else if(direction.equals("west")){
            dir.setDirection("south");
        }
        else{
            dir.setDirection("west");
        }  
    }

    public boolean canMoveForward(){
        String direction= dir.getDirection();
   
        if(direction.equals("north")){
            if(currRow-1>=0 && dummyMaze.getTile(currRow-1,currColumn)!="WALL "){
                return true;
            }
        }

        else if(direction.equals("east")){
            if(currColumn+1<=(width-1) && dummyMaze.getTile(currRow,currColumn+1)!="WALL "){
                return true;
            }
        }

        else if(direction.equals("south")){
            if(currRow+1<=(height-1) && dummyMaze.getTile(currRow+1,currColumn)!="WALL "){
                
                return true;
            }    
        }

        else if(direction.equals("west")){
            if(currColumn-1>=0 && dummyMaze.getTile(currRow,currColumn-1)!="WALL "){
                return true;
            }
        }
        return false;
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
        path.add("F");

    }



    


}