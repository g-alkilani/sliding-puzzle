package slidingpuzzle;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CellListener implements MouseListener {
    private final Puzzle puzzle;

    public CellListener(Puzzle puzzle) {
        this.puzzle = puzzle;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (puzzle.isGameOver()) {
            return;
        }

        Cell source = (Cell) e.getSource();
        int x = source.getXCoordinate();
        int y = source.getYCoordinate();

        puzzle.updateState(x, y);
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
