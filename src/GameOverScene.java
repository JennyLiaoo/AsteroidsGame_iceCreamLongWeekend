import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GameOverScene {

    private Stage primaryStage;
    private int finalScore;

    public GameOverScene(Stage primaryStage, int finalScore) {

        this.primaryStage = primaryStage;
        this.finalScore = finalScore;
    }

    public Scene createGameOverScene() {
        primaryStage.setTitle("Game_Over");

        Title titlePane = new Title("GAME OVER");
        AnchorPane anchorPane = new AnchorPane();

        ReturnButton returnButton = new ReturnButton(() -> switchBackToStart());

        Label scoreLabel = createScoreLabel(finalScore);

        // Position the score label in the center
        AnchorPane.setTopAnchor(scoreLabel, 200.0); // Adjust these values as needed for centering
        AnchorPane.setLeftAnchor(scoreLabel, 200.0);


        // Set the position for the return button
        AnchorPane.setTopAnchor(returnButton.getButtonBox(), 280.0);
        AnchorPane.setLeftAnchor(returnButton.getButtonBox(), 280.0);


        // Set background using BackgroundManager
        BackgroundManager backgroundManager = new BackgroundManager("file:src/Images/gameover_background.png");
        anchorPane.setBackground(backgroundManager.getBackground());

        // Add components to the AnchorPane and set their positions
        AnchorPane.setTopAnchor(titlePane.getVBox(), 10.0);
        AnchorPane.setLeftAnchor(titlePane.getVBox(), 65.0);

        anchorPane.getChildren().addAll(titlePane.getVBox(), returnButton.getButtonBox(), scoreLabel);

        return new Scene(anchorPane, 600, 400);
    }

    private Label createScoreLabel(int score) {
        Label scoreLabel = new Label("Final Score: " + score);
        scoreLabel.setFont(new Font("Arial", 24)); // Set the font size and style as needed
        scoreLabel.setTextFill(Color.WHITE); // Set the text color
        return scoreLabel;
    }

    // Method to switch back to the start scene.
    private void switchBackToStart() {
        // Make sure to pass the current primaryStage to the StartGameScene
        StartGameScene startGameScene = new StartGameScene(primaryStage);
        primaryStage.setScene(startGameScene.createStartScene());
        primaryStage.show();
    }
}

