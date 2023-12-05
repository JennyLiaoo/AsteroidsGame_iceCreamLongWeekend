//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class LevelLabel implements IGuiComponent {
    private HBox labelBox;
    private Label levelLabel;
    private int currentLevel = 1;

    public LevelLabel() {
        this.levelLabel = new Label("Level " + this.currentLevel);
        this.levelLabel.setFont(Font.font("Verdana", 22.0));
        this.levelLabel.setTextFill(Color.WHITE);
        this.labelBox = new HBox(this.levelLabel);
        this.labelBox.setSpacing(10.0);
    }

    public void updateLabel(boolean moveRight) {
        this.currentLevel += moveRight ? 1 : -1;
        if (this.currentLevel < 1) this.currentLevel = 3;
        if (this.currentLevel > 3) this.currentLevel = 1;
        this.levelLabel.setText("Level " + this.currentLevel);
    }

    public int getCurrentLevel() {
        return this.currentLevel;
    }

    @Override
    public Node createNode() {
        return this.labelBox;
    }

    public Node getNode() {
        // Assuming you have a method that creates and returns the JavaFX Node for TitlePane
        return this.createNode();
    }

}
