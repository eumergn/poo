import java.awt.Color;

public class ColorManager {
    private Color gridColor = Color.BLUE;

    public void changeColor(Color newColor) {
        gridColor = newColor;
    }

    public Color getGridColor() {
        return gridColor;
    }

    public Color getWordColor(String word) {
        return Color.ORANGE;
    }
}