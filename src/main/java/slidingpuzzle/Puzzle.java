package slidingpuzzle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Puzzle extends JPanel {
    private static final int SIZE = 4;

    volatile int xEmptyCell = -1;
    volatile int yEmptyCell = -1;
    volatile int[][] grid;
    private final Random random = new Random();
    private final JFrame frame;
    private JPanel rootPanel;

    public Puzzle() {
        prepareGrid();
        frame = new JFrame("Sliding Puzzle");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void display() {
        rootPanel = new JPanel(null);
        rootPanel.add(createSquare());
        rootPanel.add(createNewGameButton());
        frame.setResizable(false);
        frame.add(rootPanel);
        frame.setVisible(true);
    }

    private void prepareGrid() {
        grid = finalArrangement();
        shuffleGrid();
    }

    private int[][] finalArrangement() {
        int[][] grid = new int[SIZE][SIZE];
        int lastCellNumber = SIZE * SIZE;
        for (int i = 0, k = 1; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = k;
                if (k == lastCellNumber) {
                    grid[i][j] = -1;
                }
                k++;
            }
        }
        return grid;
    }

    private void shuffleGrid() {
        int xEmpty = SIZE - 1;
        int yEmpty = SIZE - 1;
        int[][] shifts = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        List<Integer> validShifts = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < shifts.length; j++) {
                int[] shift = shifts[j];
                if (isWithinGrid(xEmpty + shift[0]) && isWithinGrid(yEmpty + shift[1])) {
                    validShifts.add(j);
                }
            }
            int randomIndex = random.nextInt(validShifts.size());
            int[] randomShift = shifts[validShifts.get(randomIndex)];

            int temp = grid[xEmpty + randomShift[0]][yEmpty + randomShift[1]];
            grid[xEmpty + randomShift[0]][yEmpty + randomShift[1]] = -1;
            grid[xEmpty][yEmpty] = temp;

            xEmpty += randomShift[0];
            yEmpty += randomShift[1];

            validShifts.clear();
        }
        xEmptyCell = xEmpty;
        yEmptyCell = yEmpty;
    }

    private boolean isWithinGrid(int i) {
        return i >= 0 && i < SIZE;
    }

    boolean isGameOver() {
        int lastCellNumber = SIZE * SIZE;
        for (int i = 0, k = 1; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j] != k) {
                    return false;
                }
                k++;
                if (k == lastCellNumber) {
                    return true;
                }
            }
        }
        return true;
    }

    void startNewGame() {
        prepareGrid();
        updatePuzzle();
    }

    void updatePuzzle() {
        rootPanel.removeAll();
        rootPanel.add(createSquare());
        rootPanel.add(createNewGameButton());
        rootPanel.revalidate();
        rootPanel.repaint();
    }

    void endTheGame() {
        rootPanel.removeAll();
        rootPanel.add(createSquare());
        JLabel jLabel = new JLabel("Congratulations!");
        jLabel.setBounds(250, 420, 100, 100);
        rootPanel.add(jLabel);
        rootPanel.add(createNewGameButton());
        rootPanel.revalidate();
        rootPanel.repaint();
    }

    Component createNewGameButton() {
        JButton jButton = new JButton("New game");
        jButton.setBounds(450, 450, 100, 30);
        jButton.addMouseListener(new NewGameButtonListener(this));
        return jButton;
    }

    JPanel createSquare() {
        JPanel innerPanel = new JPanel();
        innerPanel.setLayout(new GridLayout(SIZE, SIZE));

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                Cell cell = new Cell(this, i, j);
                innerPanel.add(cell);
            }
        }
        innerPanel.setBounds(200, 100, 210, 210);
        return innerPanel;
    }

}
