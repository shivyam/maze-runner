package ca.mcmaster.se2aa4.mazerunner;

public class Path{

    public String findPath(){
            return "4F";
    }

    //checks if user input path is correct
    public String checkPath(String userPath){
        String rightPath= findPath();
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

}