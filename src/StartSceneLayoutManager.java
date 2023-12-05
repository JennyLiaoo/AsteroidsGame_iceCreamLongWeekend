import javafx.scene.layout.AnchorPane;

public class StartSceneLayoutManager {
    private AnchorPane anchorPane;

    public StartSceneLayoutManager(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
    }

    public void setupLayout(TitlePane titlePane, StartGameButton startGameButton, ControlButtons controlButtons, LevelLabel levelLabel, UserGuideButton userGuideButton) {
        AnchorPane.setTopAnchor(titlePane.getNode(), 0.0);
        AnchorPane.setLeftAnchor(titlePane.getNode(), 100.0);
        AnchorPane.setTopAnchor(startGameButton.getNode(), 130.0);
        AnchorPane.setLeftAnchor(startGameButton.getNode(), 30.0);
        AnchorPane.setTopAnchor(controlButtons.getNode(), 200.0);
        AnchorPane.setLeftAnchor(controlButtons.getNode(), 20.0);
        AnchorPane.setTopAnchor(levelLabel.getNode(), 280.0);
        AnchorPane.setLeftAnchor(levelLabel.getNode(), 272.0);
        AnchorPane.setTopAnchor(userGuideButton.getNode(), -50.0);
        AnchorPane.setLeftAnchor(userGuideButton.getNode(), -180.0);

        this.anchorPane.getChildren().addAll(titlePane.getNode(), startGameButton.getNode(),
                controlButtons.getNode(), levelLabel.getNode(),
                userGuideButton.getNode());
    }
}
