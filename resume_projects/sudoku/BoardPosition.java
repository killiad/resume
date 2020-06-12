package resume_projects.sudoku;

public class BoardPosition {

    private int x;
    private int y;

    /**
     * Constructor for boardPosition class. Encapsulates row coordinate with column coordinate
     * @param x_pos = x value, or length of the BoardPosition. First coordinate
     * @param y_pos = y value, or height, of the BoardPosition. Second coordinate
     * postconditions:
     *  row = row_pos
     *  col = col_pos
     */
    public BoardPosition(int x_pos, int y_pos){
        x = x_pos;
        y = y_pos;
    }

    /**
     * returns the x coordinate (first coordinate)
     * postconditions:
     *  getX = X
     * @return
     *  the x coordinate
     */
    public int getX(){
        return x;
    }

    /**
     * returns the y coordinate (second coordinate)
     * postcondition:
     *  getY = y
     * @return
     *  the y coordinate
     */
    public int getY(){
        return y;
    }

    /**
     * checks to see if two BoardPositions have the same coordinates
     * @param obj = desired Object to compare to
     * postconditions:
     *  return true iff obj instanceOf BoardPosition AND obj.x == x AND obj.y == y
     * @return
     *  true if and only if this BoardPosition and obj have the same x and y coordinates and are the same object type
     */
    @Override
    public boolean equals(Object obj){

        if(!(obj instanceof BoardPosition)){
            return false;
        }

        return ((BoardPosition) obj).getY() == y && ((BoardPosition) obj).getX() == x;
    }

    /**
     * creates a string comprised of the row and the column
     * postconditions:
     *  return string "x,y"
     * @return
     *  string of the form "x,y"
     */
    @Override
    public String toString(){

        String separator = ", ";
        return x + separator + y;
    }
}
