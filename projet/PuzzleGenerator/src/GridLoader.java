import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GridLoader {
    public Grid loadGrid(File file) {
        try {
            Scanner scanner = new Scanner(file);
            int size = Integer.parseInt(scanner.nextLine()); // Read the size from the file
            //modify the size to be random +_ 5
            size = (int) (Math.random() * 5) + size;
            Grid grid = new Grid(size);
            grid.generateGrid();
            return grid;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}