package resume_projects.sudoku;

public abstract class AbsGameBoard implements IGameBoard{

    /**
     * Turns the board into a string that looks like the grid
     * postconditions:
     *  for each BoardPosition cell in board, concatenate | + getValueAtPos(cell)
     * @return
     *  string version of the game board
     */
    @Override
    public String toString(){
        BoardPosition pos;
        int value;
        char empty_space = ' ';

        StringBuilder board = new StringBuilder();
        board.append(empty_space);
        board.append("||");

        //making column numbers on the top of the board
        for(int colNum = 0; colNum < SIDELENTH; colNum++){
            board.append(colNum);
            board.append("|");
        }
        board.append('\n');

        //creating main board
        for(int y = SIDELENTH - 1; y >= 0; y--){
            //creating row numbers on the side
            board.append(y);
            board.append("||");

            //getting values for main board then appending them to the string
            for(int x = 0; x < SIDELENTH; x++){
                pos = new BoardPosition(x,y);
                value = getValueAtPos(pos);

                if(value == 0){
                    board.append(empty_space);
                }
                else {
                    board.append(value);
                }
                board.append("|");

            }
            board.append('\n');
        }

        return board.toString();
    }

    /**
     * Checks to see if two game boards are equal
     * @param obj object to compare equality to
     * postcondition: true iff each cell in board contains the same value as the corresponding cell in obj
     * @return whether or not the two gamebaords have the same values in each cell
     */
    @Override
    public boolean equals(Object obj){
        BoardPosition pos;
        if(!(obj instanceof IGameBoard)){
            return false;
        }
        //if any of the cells differ, return false
        for(int x = 0; x < SIDELENTH; x++){
            for(int y = 0; y < SIDELENTH; y++){
                pos = new BoardPosition(x,y);
                if(!isValueAtPos(pos, ((IGameBoard) obj).getValueAtPos(pos))){
                    return false;
                }
            }
        }
        return true;
    }
}
