package ca.mcmaster.se2aa4.mazerunner;
import java.util.ArrayList;
import java.util.Arrays;

public class Position{

    public static Maze dummyMaze;
    public static int currRow;
    public static int currColumn;
    public static Direction dir;
    public static int width;
    public static int height;

    public Position(Maze maze){
        this.dummyMaze= maze;
        this.dir= new Direction(dummyMaze);
        this.currRow= dummyMaze.findEntryTile();
        this.currColumn=0;
        this.width= dummyMaze.getWidth();
        this.height= dummyMaze.getHeight();
    }

    public int getWidth(){
        return width;
    }

    public int getCurrRow(){
        return currRow;
    }

    public int getCurrColumn(){
        return currColumn;
    }


    //checks if the tile to the right of current position is not a wall
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


    //checks if the tile to the left of current position is not a wall
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


    //turns user right by changing the direction they are facing based on their current direction
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


    //turns user left by changing the direction they are facing based on their current direction
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


    //checks if the tile ahead of current position is not a wall
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

    //moves user forward by updated their column or row value
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
}