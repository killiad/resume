package resume_projects.sudoku;

/**
 * Square of length SIDELENGTH used to create a Sudoku Board
 *
 * Initialization Ensures: IGameBoard contains only EMPTY characters and is SIDELENGTH x SIDELENGTH in size
 *
 * Defines:
 * SIDELENGTH: Z, length of the board
 * EMPTY: int, empty space holder
 *
 * Constraints:
 * SIDELENTH = 9
 * EMPTY = 0
 */
public interface IGameBoard {
    int SIDELENTH = 9;
    int EMPTY = 0;

    /**
     * creates the gameboard
     * preconditions: getValueAtPos(pos) = EMPTY for all pos (x,y) with 0 <= x,y < SIDELENGTH
     * postcondition: IGameboard is a solvable, valid sudoku board
     */
    void createGame();

    /**
     * Retrieves the value at position pos
     * @param pos position to retrieve value from
     * precondition: 0 <= pos.getX() < SIDELENGTH
     *               0 <= pos.getY() < SIDELENGTH
     * postcondition: getValueAtPos = char at position pos
     * @return value at position pos
     */
    int getValueAtPos(BoardPosition pos);

    /**
     * sets the value of the cell at pos to val
     * @param pos position to change the value
     * @param val value to change the value at pos to
     * precondition: 0 < val < SIDELENGTH
     * postcondition: getValueAtPos(pos) = val
     */
    void placeNumber(BoardPosition pos, int val);

    /**
     * checks if a cell is allowed to be changed. In Sudoku, one cannot change
     * the cells that were given as part of the original puzzle
     * @param pos position of cell that will be checked
     * precondition: 0 <= pos.getX() < SIDELENGTH
     *               0 <= pos.getY() < SIDELENGTH
     * postcondition: return true if and only if getValueAtPos(pos) = EMPTY in original board
     * @return getValueAtPos(pos) = EMPTY in original board
     */
    boolean checkIfFree(BoardPosition pos);

    /**
     * returns the original board, before any new numbers were placed
     * postcondition: getOriginalBoard = oboard before any changes were made
     * @return the original board, before any changes were made
     */
    default IGameBoard getOriginalBoard(){
        IGameBoard output = new GameBoard();
        for(int x = 0; x < SIDELENTH; x++){
            for(int y = 0; y < SIDELENTH; y++){
                BoardPosition pos = new BoardPosition(x,y);
                if(!checkIfFree(pos)){
                    output.placeNumber(pos, getValueAtPos(pos));
                }
            }
        }
        return output;
    }

    /**
     * Creates the solution to the sudoku game, then returns the board
     * postcondition: generationSolution = board of the solution to the current game
     * @return board of the solution to the current game
     */
    default IGameBoard generateSolution(){

        IGameBoard solution = getOriginalBoard();
        return solution;

    }

    /**
     *
     * @param pos position to retrieve value from
     * @param val value to  compare to
     * precondition: 0 <= pos.getRow() < SIDELENGTH
     *               0 <= pos.getColumn() < SIDELENGTH
     * postcondition: isValueAtPos = true iff getValueAtPos(pos) == val
     * @return true if and only if val is the value of pos in IGameBoard
     */
    default boolean isValueAtPos(BoardPosition pos, int val){
        return getValueAtPos(pos) == val;
    }

/*     /**
     * checks to see if sudoku game is solved
     * postcondition: checkIfSolved = true iff this == generateSolution()
     * @return true if and only if the board is solved
     */
    //default boolean checkifSolved(){
    //    return this.equals(generateSolution());
    //}
}
