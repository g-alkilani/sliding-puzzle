package slidingpuzzle;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class NewGameButtonListener implements MouseListener {
    private final Puzzle puzzle;

    public NewGameButtonListener(Puzzle puzzle) {
        this.puzzle = puzzle;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        puzzle.startNewGame();
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
