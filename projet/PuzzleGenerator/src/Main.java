import java.io.File;

public class Main {
    public static void main(String[] args) {
        GridLoader gridLoader = new GridLoader();
        Grid grid = gridLoader.loadGrid(new File("grid.txt"));
        TimeManager timeManager = new TimeManager();
        ColorManager colorManager = new ColorManager();
        GridDisplay gridDisplay = new GridDisplay(grid,timeManager,colorManager);
        CelebrationWindow celebrationWindow = new CelebrationWindow();

        GridDisplay.displayGrid();
        timeManager.startTimer();
        timeManager.getElapsedTime();

        // Add your game logic here

        if (grid.isGridCompleted()) {
            timeManager.stopTimer();
            celebrationWindow.displayCelebration();
        }
    }
}