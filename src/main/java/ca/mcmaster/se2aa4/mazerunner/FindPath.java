package ca.mcmaster.se2aa4.mazerunner;
import java.util.ArrayList;
import java.util.Arrays;

public class FindPath{

    public Maze dummyMaze;


    public FindPath(Maze maze){
        this.dummyMaze= maze;
    }



   //returns the row from the first column that the entry tile is located on
    //finds path in the form "FFFRRFFLLF"
    public String findCanonicalPath(){
        
        ArrayList<String> path= new ArrayList<String>();
        int currColumn=0;
        int currRow= dummyMaze.findEntryTile();
        
        int end = dummyMaze.findExitTile();
        int width= dummyMaze.getWidth();
        int height = dummyMaze.getHeight();
        System.out.println(dummyMaze.getTile(currRow,currColumn));
        while(currColumn<=(width-1) && currColumn>=0 && currRow>=0 && currRow<=(height-1) && dummyMaze.getTile(currRow,currColumn)!="WALL "){
                currColumn+=1;
                path.add("F");
        }
        String strPath = String.join("",path);

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