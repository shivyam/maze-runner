package ca.mcmaster.se2aa4.mazerunner;
import java.util.ArrayList;
import java.util.Arrays;

public class FindPath{

    public Maze dummyMaze;
    Direction dir;
    int endRow;
    String path="";
    Position pos;

    public FindPath(Maze maze){
        this.dummyMaze= maze;
        this.dir= new Direction(dummyMaze);
        this.pos= new Position(dummyMaze);
        this.endRow= dummyMaze.findExitTile();
    }


    //finds path in the form "FFFRRFFLLF"
    public String findCanonicalPath(){
        if(pos.canMoveForward()){
                pos.moveForward();
                path+="F";
            }

        while(pos.getCurrRow()!=endRow|| pos.getCurrColumn()!=(pos.getWidth()-1)){

            if(pos.canTurnRight()){
                pos.turnRight();
                path+="R";
                pos.moveForward();
                path+="F";
            }
            else if(pos.canMoveForward()){
                pos.moveForward();
                path+="F";
            }
            else if(pos.canTurnLeft()){
                pos.turnLeft();
                path+="L";
                pos.moveForward();
                path+="F";
            }
            else{
                pos.turnLeft();
                path+="L";
                pos.turnLeft();
                path+="L";
                pos.moveForward();
                path+="F";
            }
        }
            dummyMaze.printMaze();
            return path;
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

    
}