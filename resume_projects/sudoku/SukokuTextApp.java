package resume_projects.sudoku;

public class SukokuTextApp {

    private static IGameBoard board;

    public static void main(String[] args){
        board = new GameBoard();
        board.createGame();
        System.out.println(board.toString());
    }
}
