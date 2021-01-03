package slidingpuzzle;

import javax.swing.*;
import java.awt.*;

public class Cell extends JComponent {
    private static final int CELL_LENGTH = 50;
    private final int num;
    private final int xCoordinate;
    private final int yCoordinate;

    public Cell(int num, int xCoordinate, int yCoordinate) {
        this.num = num;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
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
