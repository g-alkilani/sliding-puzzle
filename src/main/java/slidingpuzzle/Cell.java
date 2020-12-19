package slidingpuzzle;

import javax.swing.*;
import java.awt.*;

public class Cell extends JComponent {
    private static final int CELL_LENGTH = 50;
    private final int num;

    public Cell(Puzzle puzzle, int i, int j) {
        num = puzzle.grid[i][j];
        super.addMouseListener(new CellListener(puzzle, i, j));
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (num != -1) {
            g.setColor(Color.GREEN);
        } else {
            g.setColor(Color.lightGray);
        }
        g.fillRect(0, 0, CELL_LENGTH, CELL_LENGTH);
        g.setColor(Color.BLUE);
        g.drawRect(0, 0, CELL_LENGTH, CELL_LENGTH);
        if (num != -1) {
            g.drawString(String.valueOf(num), CELL_LENGTH / 2, CELL_LENGTH / 2);
        }
    }

}
