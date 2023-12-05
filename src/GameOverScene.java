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
        primaryStage.setTitle("Game Over");

        TitlePane titlePane = new TitlePane("GAME OVER");
        AnchorPane anchorPane = new AnchorPane();
        ReturnButton returnButton = new ReturnButton(this::switchBackToStart);
        Label scoreLabel = createScoreLabel(finalScore);

        // Set background
        BackgroundManager backgroundManager = new BackgroundManager("file:src/Images/gameover_background.png");
        anchorPane.setBackground(backgroundManager.getBackground());

        // Using LayoutManager to arrange components
        GameOverLayoutManager layoutManager = new GameOverLayoutManager(anchorPane);
        layoutManager.setupLayout(titlePane, scoreLabel, returnButton);

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

