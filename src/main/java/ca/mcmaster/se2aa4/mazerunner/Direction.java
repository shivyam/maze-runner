package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.Arrays;

public class Direction{

    public Maze dummyMaze;
    public int height;
    public int width;

    public String direction="east";

    public Direction(Maze maze){
        this.dummyMaze= maze;
        this.height= dummyMaze.getHeight();
        this.width= dummyMaze.getWidth();

    }

    public String getDirection(){
        return direction;
    }

    public void setDirection(String dir){
        this.direction=dir;
    }

    
    public int moveNorth(int row){
        if(row-1>=0){
            row-=1;
            return row;
        }
        return -1;
        
    }
    public int moveEast(int column){
        if(column+1<(width)){
            column+=1;
            return column;
        }
        return -1;
    }
    
    public int moveSouth(int row){
        if(row+1<height){
            row+=1;
            return row;
        }
        return -1;


    }
    public int moveWest(int column){
        if(column-1>=0){
            column-=1;
            return column;
        }
        return -1;
    }
    

    


    public String checkAround(int row, int column){
        return "";
    }





    //public void turnRight(){
    //     if(direction.equals("east")){
    //         direction="south";
    //     }
    //     else if(direction.equals("south")){
    //         direction="west";
    //     }
    //     else if(direction.equals("west")){
    //         direction="north";
    //     }
    //     else{
    //         direction="east";
    //     }
    // }


    // public void turnLeft(){
    //     if(direction.equals("east")){
    //         direction="north";
    //     }
    //     else if(direction.equals("south")){
    //         direction="east";
    //     }
    //     else if(direction.equals("west")){
    //         direction="south";
    //     }
    //     else{
    //         direction="west";
    //     }
    // }

}