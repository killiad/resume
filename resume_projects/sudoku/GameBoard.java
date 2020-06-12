package resume_projects.sudoku;

import java.util.Random;

public class GameBoard extends AbsGameBoard implements IGameBoard{

    private int[][] current_board;
    private int[][] original_board;

    public GameBoard(){
        current_board = new int[SIDELENTH][SIDELENTH];
        original_board = new int[SIDELENTH][SIDELENTH];
    }

    @Override
    public void createGame() {
        Random rand = new Random();
        int seed = rand.nextInt(GameInfo.NUMBER_OF_GAMES);
        int[][] initial_game = GameInfo.getGame(seed);

        for(int[] cell_data : initial_game){
            current_board[cell_data[0]][cell_data[1]] = cell_data[2];
            original_board[cell_data[0]][cell_data[1]] = cell_data[2];
        }

    }

    @Override
    public int getValueAtPos(BoardPosition pos) {
        return current_board[pos.getX()][pos.getY()];
    }

    @Override
    public void placeNumber(BoardPosition pos, int val) {
        current_board[pos.getX()][pos.getY()] = val;
    }

    @Override
    public boolean checkIfFree(BoardPosition pos) {
        return original_board[pos.getX()][pos.getY()] == IGameBoard.EMPTY;
    }
}
