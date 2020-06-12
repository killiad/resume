package resume_projects.sudoku;

import java.util.Random;

public class GameBoard extends AbsGameBoard implements IGameBoard{

    private int[][] board;

    public GameBoard(){
        board = new int[SIDELENTH][SIDELENTH];
    }

    @Override
    public void createGame() {
        Random rand = new Random();
        int seed = rand.nextInt(GameInfo.NUMBER_OF_GAMES);
        int[][] initial_game = GameInfo.getGame(seed);

        for(int[] cell_data : initial_game){
            board[cell_data[0]][cell_data[1]] = cell_data[2];
        }

    }

    @Override
    public int getValueAtPos(BoardPosition pos) {
        return board[pos.getX()][pos.getY()];
    }

    @Override
    public void placeNumber(BoardPosition pos, int val) {
        board[pos.getX()][pos.getY()] = val;
    }
}
