import javax.swing.*;
import java.util.*;

public class Grid {
    private final char[][] grid;
    private final int size;
    private final char[] vowels = {'A', 'E', 'I', 'O', 'U'};
    private final Map<String, String> words = new HashMap<>() {{
        put("JAVA", "The programming language used to make this game");
        put("CROSSWORD", "The type of puzzle you're playing");
        put("GAME", "A fun activity");
        put("WORD", "A sequence of letters");
    }};
    private final List<Word> wordLocations = new ArrayList<>();

    public Grid(int size) {
        this.size = size;
        this.grid = new char[size][size];
    }

    public List<Word> getWordStartLocations() {
        return wordLocations;
    }


    public void generateGrid() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (Math.random() < 0.2) {
                    // 20% chance to add a random vowel
                    grid[i][j] = vowels[(int) (Math.random() * vowels.length)];
                } else {
                    grid[i][j] = (char) ('A' + Math.random() * ('Z' - 'A' + 1));
                }
            }
        }
        fillWords();
    }

    public void fillWords() {
        Random random = new Random();
        for (String word : words.keySet()) {
            int startRow, startCol;
            do {
                startRow = random.nextInt(size);
                startCol = random.nextInt(size);
            } while (!canPlaceWordToRight(word, startRow, startCol));

            for (int i = 0; i < word.length(); i++) {
                grid[startRow][startCol + i] = word.charAt(i);
            }
            int endRow = startRow;
            int endCol = startCol + word.length() - 1;
            wordLocations.add(new Word(startRow, startCol, endRow, endCol));
        }
    }

    private boolean canPlaceWordToRight(String word, int startRow, int startCol) {
        return startCol + word.length() <= size;
    }

    public boolean checkWordValidity(String word) {
        return words.containsKey(word.toUpperCase());
    }

    public boolean isGridCompleted() {
        return words.keySet().isEmpty();
    }

    public int getSize() {
        return size;
    }

    public char getCharAt(int i, int j) {
        return grid[i][j];
    }

    public void addWord(String word) {
        if (checkWordValidity(word)) {
            words.remove(word);
            if (isGridCompleted()) {
                GridDisplay.timeManager.stopTimer();
                CelebrationWindow celebrationWindow = new CelebrationWindow();
                celebrationWindow.displayCelebration();
            }
        }else {
            JOptionPane.showMessageDialog(null, "Invalid word");
        }
        System.out.println(words);
    }

    public String getHint() {
        if (words.isEmpty()) {
            return "No more words to guess";
        }
        int mapSize = words.size();
        int randomIndex = (int) (Math.random() * mapSize);
        String randomWord = words.keySet().toArray()[randomIndex].toString();
        return words.get(randomWord);
    }
}