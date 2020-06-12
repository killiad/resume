package resume_projects.sudoku;

public class GameInfo {

    public static final int NUMBER_OF_GAMES = 1;

    //not an actual game, but used for debugging
    public static final int [][] EMPTY_GAME = {{}};

    //{x,y,value} for the initial board
    public static final int[][] GAME_ZERO = {
            {1,0,7}, {3,0,5}, {4,0,6},
            {5,0,1}, {7,0,2}, {2,1,5},
            {5,1,9}, {6,1,3}, {8,1,7},
            {1,2,6}, {2,2,2}, {4,2,7},
            {8,2,4}, {1,3,9}, {2,3,6},
            {4,3,3}, {5,3,2}, {6,3,7},
            {7,3,5}, {0,4,2}, {2,4,8},
            {5,4,5}, {6,4,6}, {0,5,7},
            {1,5,5}, {5,5,6}, {1,6,2},
            {4,6,1}, {7,6,4}, {8,6,5},
            {1,7,4}, {2,7,9}, {3,7,2},
            {7,7,3}, {7,8,8}, {1,8,3},
            {2,8,1}, {8,8,6}
    };

    /**
     * Retrieves a sudoku game based off the corresponding seed
     * @param seed number used to generate the sudoku game
     * postcondition: getGame = corresponding game
     * @return collection of arrays of the form [x coordinate, y coordinate, value of cell]
     */
    public static int[][] getGame(int seed){
        if(seed == 0){
            return GAME_ZERO;
        }
        else{
            return EMPTY_GAME;
        }
    }

}
