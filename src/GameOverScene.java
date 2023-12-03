import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GameOverScene {

    private Stage primaryStage;

    public GameOverScene(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public Scene createGameOverScene() {
        primaryStage.setTitle("Game_Over");

        Title titlePane = new Title("GAME OVER");
        AnchorPane anchorPane = new AnchorPane();

        ReturnButton returnButton = new ReturnButton(() -> switchBackToStart());


        // Set the position for the return button
        AnchorPane.setTopAnchor(returnButton.getButtonBox(), 280.0);
        AnchorPane.setLeftAnchor(returnButton.getButtonBox(), 280.0);


        // Set background using BackgroundManager
        BackgroundManager backgroundManager = new BackgroundManager("file:src/Images/gameover_background.png");
        anchorPane.setBackground(backgroundManager.getBackground());

        // Add components to the AnchorPane and set their positions
        AnchorPane.setTopAnchor(titlePane.getVBox(), 10.0);
        AnchorPane.setLeftAnchor(titlePane.getVBox(), 65.0);

        // Add components to the AnchorPane
        anchorPane.getChildren().addAll(titlePane.getVBox(), returnButton.getButtonBox());

        return new Scene(anchorPane, 600, 400);
    }
    // Method to switch back to the start scene.
    private void switchBackToStart() {
        // Make sure to pass the current primaryStage to the StartGameScene
        StartGameScene startGameScene = new StartGameScene(primaryStage);
        primaryStage.setScene(startGameScene.createStartScene());
        primaryStage.show();
    }
}

