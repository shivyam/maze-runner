package ca.mcmaster.se2aa4.mazerunner;
import java.util.ArrayList;
import java.util.Arrays;

public class Position{

    public Maze dummyMaze;
    public int currRow;

    public Position(Maze maze){
        this.dummyMaze= maze;
        this.currRow= dummyMaze.findEntryTile();

    }
}