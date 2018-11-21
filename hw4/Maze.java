package hw4;


import java.util.ArrayList;

import hw4.PairInt;
//I Pledge My Honor that I have abided by the Stevens Honor System -Bsoong

/**
 * Class that solves maze problems with backtracking.
 * @author Koffman and Wolfgang
 **/
public class Maze implements GridColors {
    /** The maze */
    private TwoDimGrid maze;

    public Maze(TwoDimGrid m) {
        maze = m;
    }
    

    /** Wrapper method. */
    public boolean findMazePath() {
        return findMazePath(0, 0); // (0, 0) is the start point.
    }

    /**
     * Attempts to find a path through point (x, y).
     * @pre Possible path cells are in BACKGROUND color;
     *      barrier cells are in ABNORMAL color.
     * @post If a path is found, all cells on it are set to the
     *       PATH color; all cells that were visited but are
     *       not on the path are in the TEMPORARY color.
     * @param x The x-coordinate of current point
     * @param y The y-coordinate of current point
     * @return If a path through (x, y) is found, true;
     *         otherwise, false
     */
    public boolean findMazePath(int x, int y) {
    	//Base Cases which checks if there is anything outlying that would disrupt the code.
    	if((x<0 || y<0 || x>= maze.getNCols() || y>= maze.getNRows()) || (maze.getColor(x,y) == BACKGROUND || maze.getColor(x, y)==TEMPORARY)) {
    		return false;
    	}
    	//Checks if the current space is the end
    	if(x == maze.getNCols()-1 && y== maze.getNRows()-1) {
    		maze.recolor(x, y, PATH);
    		return true;
    	}
    	//Checks each direction
    	else {
    		maze.recolor(x, y, TEMPORARY);
    		if(findMazePath(x-1,y) || findMazePath(x+1, y) || findMazePath(x, y-1) || findMazePath(x, y+1)) {
    			maze.recolor(x, y, PATH);
    			return true;
    		}
    		else {
    			maze.recolor(x, y, TEMPORARY);
    			return false;
    			
    		}
    	}
        
    }
    public ArrayList<ArrayList<PairInt>> findAllMazePaths(int x, int y) {
    	//Using for loops it check each direction resulting in finding all of the options of paths. 
    	if(x<0 || y<0 || x>= maze.getNCols() || y>=maze.getNRows()) {
    		return  new ArrayList<ArrayList<PairInt>>();
    		}
    	else if(x==maze.getNCols()-1 && y==maze.getNRows() - 1 ) {
    		ArrayList<ArrayList<PairInt>> allS = new ArrayList<ArrayList<PairInt>>();
    		ArrayList<PairInt> route = new ArrayList<PairInt>();
    		route.add(0, new PairInt(x,y));
    		allS.add(route);
    		return allS;
    		}
    	else if(maze.getColor(x, y) != NON_BACKGROUND)
    		return new ArrayList<ArrayList<PairInt>>();
    	else {
    		ArrayList<ArrayList<PairInt>> fin = new ArrayList<ArrayList<PairInt>>();
    		maze.recolor(x, y, TEMPORARY);
    		ArrayList<ArrayList<PairInt>> Down = findAllMazePaths(x,y-1);
    		ArrayList<ArrayList<PairInt>> Up = findAllMazePaths(x,y+1);
    		ArrayList<ArrayList<PairInt>> Left = findAllMazePaths(x-1,y);
    		ArrayList<ArrayList<PairInt>> Right = findAllMazePaths(x+1,y);
    		
    		for(int i = 0; i < Up.size(); i++) {
    			Up.get(i).add(0, new PairInt(x,y));
    			fin.add(Up.get(i));
    		}
    		for(int i = 0; i < Down.size(); i++) {
    			Down.get(i).add(0, new PairInt(x,y));
    			fin.add(Down.get(i));
    		}
    		for(int i = 0; i < Left.size(); i++) {
    			Left.get(i).add(0, new PairInt(x,y));
    			fin.add(Left.get(i));
    		}
    		for(int i = 0; i < Right.size(); i++) {
    			Right.get(i).add(0, new PairInt(x,y));
    			fin.add(Right.get(i));
    		}
    		maze.recolor(x, y, NON_BACKGROUND);
    		return fin; 		
    	}
    }
    
    /**
     * 
     * @param x
     * @param y
     * @param visited
     * @return
     */
    public ArrayList<PairInt> findMazePathMin(int x, int y){
    	if(!findMazePath()) {
    		return null;
    	} else {
    		maze.recolor(TEMPORARY, NON_BACKGROUND);
    		maze.recolor(PATH, NON_BACKGROUND);
    		ArrayList<ArrayList<PairInt>> allS = findAllMazePaths(0,0);
    		ArrayList<PairInt> path = allS.get(0);
    	
    		for(int i = 1; i < allS.size(); i++) {
    			if(path.size() < allS.get(i).size()) {
    				path = allS.get(i);
    	}
    		}
    		return path; 
    		}
    }

    /*<exercise chapter="5" section="6" type="programming" number="2">*/
    public void resetTemp() {
        maze.recolor(TEMPORARY, BACKGROUND);
    }
    /*</exercise>*/

    /*<exercise chapter="5" section="6" type="programming" number="3">*/
    public void restore() {
        resetTemp();
        maze.recolor(PATH, BACKGROUND);
        maze.recolor(NON_BACKGROUND, BACKGROUND);
    }
    /*</exercise>*/
}
/*</listing>*/
