import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class GameOverLayoutManager {
    private AnchorPane anchorPane;

    public GameOverLayoutManager(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
    }

    public void setupLayout(TitlePane titlePane, Label scoreLabel, ReturnButton returnButton) {
        // Layout for TitlePane
        AnchorPane.setTopAnchor(titlePane.getNode(), 10.0);
        AnchorPane.setLeftAnchor(titlePane.getNode(), 65.0);

        // Layout for ScoreLabel
        AnchorPane.setTopAnchor(scoreLabel, 200.0); // Adjust these values as needed for centering
        AnchorPane.setLeftAnchor(scoreLabel, 200.0);

        // Layout for ReturnButton
        AnchorPane.setTopAnchor(returnButton.getButtonBox(), 280.0);
        AnchorPane.setLeftAnchor(returnButton.getButtonBox(), 280.0);

        // Adding components to the AnchorPane
        anchorPane.getChildren().addAll(titlePane.getNode(), returnButton.getButtonBox(), scoreLabel);
    }
}
