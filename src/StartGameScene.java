import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class StartGameScene {
    private Stage primaryStage;
    private LevelLabel levelLabel;

    // Constructor to initialize with the primary stage.
    public StartGameScene(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public Scene createStartScene() {
        // Create components
        Title titlePane = new Title("ASTEROIDS");
        levelLabel = new LevelLabel();
        ControlButtons controlButtons = new ControlButtons(
                () -> levelLabel.updateLabel(false),
                () -> levelLabel.updateLabel(true));

        StartGameButton startGameButton = new StartGameButton(
                () -> switchToGameScene());

        UserGuidButton userGuideButton = new UserGuidButton(() ->
                switchToUserGuide());

        // Create AnchorPane for layout
        AnchorPane anchorPane = new AnchorPane();

        // Set background using BackgroundManager
        BackgroundManager backgroundManager = new BackgroundManager("file:/Users/juliaqiu/IdeaProjects/DatabaseUI/src/Images/space_background.jpg");
        anchorPane.setBackground(backgroundManager.getBackground());

        // Add components to the AnchorPane and set their positions
        AnchorPane.setTopAnchor(titlePane.getVBox(), 10.0);
        AnchorPane.setLeftAnchor(titlePane.getVBox(), 65.0);

        AnchorPane.setTopAnchor(startGameButton.getButtonBox(), 120.0);
        AnchorPane.setLeftAnchor(startGameButton.getButtonBox(), 0.0);

        AnchorPane.setTopAnchor(controlButtons.getButtonBox(), 200.0);
        AnchorPane.setLeftAnchor(controlButtons.getButtonBox(), 20.0);

        AnchorPane.setTopAnchor(levelLabel.getLabelBox(), 280.0);
        AnchorPane.setLeftAnchor(levelLabel.getLabelBox(), 272.0);

        AnchorPane.setTopAnchor(userGuideButton.getButtonBox(), -50.0);
        AnchorPane.setLeftAnchor(userGuideButton.getButtonBox(), -180.0);

        anchorPane.getChildren().addAll(titlePane.getVBox(), startGameButton.getButtonBox(), controlButtons.getButtonBox(), levelLabel.getLabelBox(), userGuideButton.getButtonBox());

        // Return Scene with AnchorPane as root
        return new Scene(anchorPane, 600, 400);
    }

    public void returnBackToStart() {
        primaryStage.setScene(createStartScene());
        primaryStage.show();
    }

    private void switchToGameScene() {
        int currentLevel = levelLabel.getCurrentLevel();

        Main game = (Main) primaryStage.getScene().getRoot().getUserData();
        game.startGame(currentLevel); // Now just passing the level.
    }


    private void switchToUserGuide() {
        // Switch to the User Guide scene
        new UserGuideScene(primaryStage).OpenUserGuide(primaryStage);
    }

}
