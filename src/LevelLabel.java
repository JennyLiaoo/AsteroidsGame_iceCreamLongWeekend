import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class LevelLabel {
    private HBox labelBox;
    private Label levelLabel;
    private int currentLevel = 1; // Initialize with the first level

    public LevelLabel() {
        // Create label
        levelLabel = new Label("Level " + currentLevel);
        levelLabel.setFont(Font.font("Verdana", 22));
        levelLabel.setTextFill(Color.WHITE);

        // Create HBox to hold the label
        labelBox = new HBox(levelLabel);
        labelBox.setSpacing(10);

    }

    public HBox getNode() {
        return labelBox;
    }

    public void updateLabel(boolean moveRight) {
        if (moveRight) {
            currentLevel++;
        } else {
            currentLevel--;
        }
        if (currentLevel < 1) {
            currentLevel = 3; // Wrap around to the last level
        } else if (currentLevel > 3) {
            currentLevel = 1; // Wrap around to the first level
        }
        levelLabel.setText("Level " + currentLevel);
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setLabelPosition(int top, int right, int bottom, int left) {
        labelBox.setPadding(new Insets(top, right, bottom, left));
    }
}
