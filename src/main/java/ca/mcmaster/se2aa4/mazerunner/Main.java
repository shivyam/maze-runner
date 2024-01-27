package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;


public class Main {

    private static final Logger logger = LogManager.getLogger();
    

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> userMaze = new ArrayList<ArrayList<String>>();
        Configuration config= Configuration.load(args);
        System.out.println(config);
        String inputFilePath= config.inputFilePath();
        String userPath= config.userPath();

        logger.info(userPath);
        try{

            
        
            logger.info("**** Reading the maze from file " + inputFilePath);
            BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
            String line;
            

            while ((line = reader.readLine()) != null) {
                ArrayList<String> row = new ArrayList<String>();

                for (int idx = 0; idx < line.length(); idx++) {
                
                    if (line.charAt(idx) == '#') {
                        System.out.print("WALL ");
                        row.add("WALL ");
                    } else if (line.charAt(idx) == ' ') {
                        System.out.print("PASS ");
                        row.add("PASS ");
                    }
                
                }
                System.out.print(System.lineSeparator());
                userMaze.add(row);
            }
        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\");
        }

        Maze mazeTest= new Maze(userMaze);
        FindPath path= new FindPath(mazeTest);
        CheckPath check= new CheckPath(mazeTest, userPath);
        
        
        logger.info("**** Computing path");
        logger.info("Path: " + path.findFactorizedPath());
        logger.info(mazeTest.findEntryTile());
        logger.info("Verify User Path: " + check.checkPath());
        logger.info("** End of MazeRunner");
        
        
    }
}