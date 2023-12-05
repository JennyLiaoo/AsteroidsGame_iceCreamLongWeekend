//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

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
        this.primaryStage.setTitle("Game Over");
        TitlePane titlePane = new TitlePane("GAME OVER");
        AnchorPane anchorPane = new AnchorPane();
        ReturnButton returnButton = new ReturnButton(this::switchBackToStart);
        Label scoreLabel = this.createScoreLabel(this.finalScore);
        BackgroundManager backgroundManager = new BackgroundManager("file:src/Images/gameover_background.png");
        anchorPane.setBackground(backgroundManager.getBackground());
        GameOverLayoutManager layoutManager = new GameOverLayoutManager(anchorPane);
        layoutManager.setupLayout(titlePane, scoreLabel, returnButton);
        return new Scene(anchorPane, 600.0, 400.0);
    }

    private Label createScoreLabel(int score) {
        Label scoreLabel = new Label("Final Score: " + score);
        scoreLabel.setFont(new Font("Arial", 24.0));
        scoreLabel.setTextFill(Color.WHITE);
        return scoreLabel;
    }

    private void switchBackToStart() {
        StartGameScene startGameScene = new StartGameScene(this.primaryStage);
        this.primaryStage.setScene(startGameScene.createStartScene());
        this.primaryStage.show();
    }
}
