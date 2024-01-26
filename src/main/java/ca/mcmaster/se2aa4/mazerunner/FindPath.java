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

    public FindPath(Maze maze){
        this.dummyMaze= maze;
        this.dir= new Direction(dummyMaze);
        this.width= dummyMaze.getWidth();
        this.height= dummyMaze.getHeight();
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
        
        int end = dummyMaze.findExitTile();
        String strPath;
        int count=0;
        
        System.out.println("Curr Column:  " + currColumn);
        while(currColumn<=(width-1) && currColumn>=0 && currRow>=0 && currRow<=(height-1) && dummyMaze.getTile(currRow,currColumn)!="WALL " && count<20){
            System.out.println("entered while loop");
            if(canMoveForward()){
                System.out.println("hello");
                moveForward();
            }
            else{
                
                turnRight();
                if(canMoveForward()){
                    
                    path.add("R");
                    moveForward();
                }
                else{
                    turnLeft();
                    if(canMoveForward()){
                      
                        path.add("L");
                        moveForward();
                    }
                }
            }
         
    
            System.out.println("Row:  " + currRow +  "     End Row:   " + end +  "   Column:    " + currColumn + "      End Column: " +   (width-1));
            if(currRow==end && currColumn==(width-1)){
                strPath = String.join("",path);
                return strPath;
            }

            System.out.println("currColumn<=(width-1):  "+ (currColumn<=(width-1)));
            System.out.println("currColumn>=0:  " + (currColumn>=0));
            System.out.println("currRow>=0:  "+ (currRow>=0));
            System.out.println("currRow<=(height-1):  " + (currRow<=(height-1)));
            System.out.println("dummyMaze.getTile(currRow,currColumn)!=WALL:  " + (dummyMaze.getTile(currRow,currColumn)!="WALL "));

            count+=1;
        }
            strPath = String.join("",path);
            dummyMaze.printMaze();
            return strPath;

    }
        
        

   
      
    
    /*
    public boolean surrounded(){
        int num=0;
        if(dummyMaze.getTile(currRow+1,currColumn)=="WALL "){
            count+=1;
        }
        else if(dummyMaze.getTile(currRow-1,currColumn)=="WALL "){
            count+=1;
        }
        else if(dummyMaze.getTile(currRow,currColumn+1)=="WALL "){
            count+=1;
        }
        else if(dummyMaze.getTile(currRow,currColumn-1)=="WALL "){
            count+=1;
        }

        if count(==)
    }
*/
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
        System.out.println();
        System.out.println("Direction Update: " + dir.getDirection());
        System.out.println();
        
        
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

        System.out.println();
        System.out.println("Direction Update: " + dir.getDirection());
        System.out.println();
        
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
            System.out.println("IMH EHRHEHEHRHEEHRHEHE");
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