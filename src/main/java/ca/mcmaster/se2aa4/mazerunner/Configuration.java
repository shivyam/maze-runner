package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;
import org.apache.commons.cli.ParseException;

public record Configuration(){

    private static final Logger logger = LogManager.getLogger();

    public static Configuration configure(String[] args) throws ParseException{
        logger.info("** Starting Maze Runner");
        Options options = new Options();
        options.addOption("i", true, "input maze filepath");
        options.addOption("p", true, "user path guess");

        ArrayList<ArrayList<String>> userMaze = new ArrayList<ArrayList<String>>();
        String userPath= "";

        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);
            String inputFilePath = cmd.getOptionValue("i");
            
            //checks if user uses -p flag
            if(cmd.hasOption("p")) {
                    userPath = cmd.getOptionValue("p");
            }
        }

        catch(ParseException pe){
            logger.error(pe.getMessage());
        }
        return new Configuration(inputFilePath, userPath);

    }
}