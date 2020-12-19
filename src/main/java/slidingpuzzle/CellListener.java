package slidingpuzzle;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CellListener implements MouseListener {
    private final Puzzle puzzle;
    private final int x;
    private final int y;

    public CellListener(Puzzle puzzle, int x, int y) {
        this.x = x;
        this.y = y;
        this.puzzle = puzzle;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (puzzle.isGameOver()) {
            return;
        }

        if (x == puzzle.xEmptyCell && y == puzzle.yEmptyCell) {
            return;
        }

        if ((x == puzzle.xEmptyCell && Math.abs(y - puzzle.yEmptyCell) == 1) ||
                (y == puzzle.yEmptyCell && Math.abs(x - puzzle.xEmptyCell) == 1)) {
            int temp = puzzle.grid[x][y];
            puzzle.grid[x][y] = -1;
            puzzle.grid[puzzle.xEmptyCell][puzzle.yEmptyCell] = temp;

            puzzle.xEmptyCell = x;
            puzzle.yEmptyCell = y;

            if (puzzle.isGameOver()) {
                puzzle.endTheGame();
                return;
            }
            puzzle.updatePuzzle();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
