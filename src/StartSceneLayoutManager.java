import javafx.scene.layout.AnchorPane;

public class StartSceneLayoutManager {
    private AnchorPane anchorPane;

    public StartSceneLayoutManager(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
    }

    public void setupLayout(TitlePane titlePane, StartGameButton startGameButton,
                            ControlButtons controlButtons, LevelLabel levelLabel,
                            UserGuideButton userGuideButton) {
        // Layout for TitlePane
        AnchorPane.setTopAnchor(titlePane.getNode(), 10.0);
        AnchorPane.setLeftAnchor(titlePane.getNode(), 75.0);

        // Layout for StartGameButton
        AnchorPane.setTopAnchor(startGameButton.getNode(), 120.0);
        AnchorPane.setLeftAnchor(startGameButton.getNode(), 0.0); // Adjusted positioning

        // Layout for ControlButtons
        AnchorPane.setTopAnchor(controlButtons.getNode(), 200.0);
        AnchorPane.setLeftAnchor(controlButtons.getNode(), 20.0);

        // Layout for LevelLabel
        AnchorPane.setTopAnchor(levelLabel.getNode(), 280.0);
        AnchorPane.setLeftAnchor(levelLabel.getNode(), 272.0);

        // Layout for UserGuideButton
        AnchorPane.setTopAnchor(userGuideButton.getNode(), -50.0); // Adjusted positioning
        AnchorPane.setLeftAnchor(userGuideButton.getNode(), -180.0); // Adjusted positioning

        // Adding components to the AnchorPane
        anchorPane.getChildren().addAll(
                titlePane.getNode(),
                startGameButton.getNode(),
                controlButtons.getNode(),
                levelLabel.getNode(),
                userGuideButton.getNode());
    }
}
