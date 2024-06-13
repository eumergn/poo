import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class GridDisplay {
    private static Grid grid;
    static TimeManager timeManager;
    private static ColorManager colorManager;
    private static JPanel gridPanel;
    private static boolean isAddingWord = false;
    private static List<Point> selectedCells = new ArrayList<>();

    public GridDisplay(Grid grid, TimeManager timeManager, ColorManager colorManager) {
        GridDisplay.grid = grid;
        GridDisplay.timeManager = timeManager;
        GridDisplay.colorManager = colorManager;
    }

    public static void displayGrid() {
        JFrame frame = new JFrame("Crossword Puzzle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        var topPanel = getjPanel();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        frame.add(topPanel, gbc);

        gridPanel = new JPanel();
        gridPanel.setPreferredSize(new Dimension(600, 600));
        gridPanel.setLayout(new GridLayout(grid.getSize(), grid.getSize()));

        refreshGrid();

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(gridPanel, gbc);

        var statusPanel = getPanel();

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        frame.add(statusPanel, gbc);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static JPanel getPanel() {
        JPanel statusPanel = new JPanel();
        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.Y_AXIS));
        JLabel statusLabel = new JLabel("Status: En cours...");
        statusLabel.setPreferredSize(new Dimension(400, 100));
        statusLabel.setForeground(Color.BLACK);
        JButton hintButton = new JButton(" Hint ");
        hintButton.setPreferredSize(new Dimension(400, 30));
        hintButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String hint = grid.getHint();
                statusLabel.setText("Hint -> " + "<<" + hint + ">>");
            }
        });

        var instructionsTable = getjTable();

        statusPanel.add(hintButton);
        statusPanel.add(statusLabel);
        statusPanel.add(new JScrollPane(instructionsTable));
        statusPanel.setPreferredSize(new Dimension(400, 600));
        return statusPanel;
    }

    private static JTable getjTable() {
        String[] columnNames = {"Instructions"};
        Object[][] data = {
                {"Cliquer sur Ajout Mot pour ajouter un mot vous avez trouve"},
                {"Cliquer sur les lettres successivement"},
                {"Cliquer sur Z apres P pour chosir ZIP"},
                {"Cliquer sur Applique pour appliquer le mot choisi"},
                {"Cliquer sur Hint pour avoir une indice"},
        };
        JTable instructionsTable = new JTable(data, columnNames);
        instructionsTable.setFont(new Font("sans-serif", Font.BOLD, 13));
        instructionsTable.setRowHeight(25);
        instructionsTable.setEnabled(false);
        return instructionsTable;
    }

    private static JPanel getjPanel() {
        JPanel topPanel = new JPanel();
        JButton addApplyButton = new JButton(" Ajouter mot ");
        addApplyButton.setBorder(null);
        addApplyButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (isAddingWord) {
                    addWordFromSelectedCells();
                    isAddingWord = false;
                    addApplyButton.setText("Ajouter mot");
                } else {
                    isAddingWord = true;
                    selectedCells.clear();
                    addApplyButton.setText("Terminer");
                }
            }
        });
        topPanel.add(addApplyButton);

        return topPanel;
    }

    private static void refreshGrid() {
        gridPanel.removeAll();

        Font font = new Font("Arial", Font.BOLD, 20);
        for (int i = 0; i < grid.getSize(); i++) {
            for (int j = 0; j < grid.getSize(); j++) {
                JLabel label = new JLabel(Character.toString(grid.getCharAt(i, j)), SwingConstants.CENTER);
                label.setFont(font);
                label.setForeground(colorManager.getGridColor());
                label.setPreferredSize(new Dimension(50, 50));
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                label.setOpaque(true); // Needed for background color to be visible

                final int row = i;
                final int col = j;
                label.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        if (isAddingWord) {
                            selectedCells.add(new Point(row, col));
                            label.setBackground(Color.YELLOW);
                        }
                    }
                });

                gridPanel.add(label);
            }
        }

        gridPanel.revalidate();
        gridPanel.repaint();
    }

    private static void addWordFromSelectedCells() {
        StringBuilder wordBuilder = new StringBuilder();
        for (Point cell : selectedCells) {
            wordBuilder.append(grid.getCharAt(cell.x, cell.y));
        }
        String word = wordBuilder.toString();
        specialRepaint(word);
        grid.addWord(word);
    }

    private static void specialRepaint(String word) {
        for (Point cell : selectedCells) {
            JLabel label = (JLabel) gridPanel.getComponent(cell.x * grid.getSize() + cell.y);
            label.setText(Character.toString(grid.getCharAt(cell.x, cell.y)));
            label.setBackground(colorManager.getWordColor(word));
        }
    }
}