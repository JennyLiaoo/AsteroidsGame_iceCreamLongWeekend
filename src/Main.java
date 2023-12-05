//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
    private Stage primaryStage;
    private GraphicsContext gc;
    private LvlHandler lvlHandler;
    private Canvas canvas;
    private Label scoreLabel;
    private Label playerLevelLabel;

    public Main() {
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setUserData(this);
        StartGameScene startScene = new StartGameScene(primaryStage);
        Scene startSceneInstance = startScene.createStartScene();
        primaryStage.setScene(startSceneInstance);
        primaryStage.setTitle("Asteroid_JennyEmi_Version");
        primaryStage.show();
    }

    public void startGame(int level) {
        Scene gameScene = this.createGameScene(level);
        this.primaryStage.setTitle("Asteroids");
        this.primaryStage.setScene(gameScene);
        this.primaryStage.show();
    }

    private Scene createGameScene(int level) {
        this.lvlHandler = new LvlHandler(level, this::switchToGameOverScene);
        StackPane gameRoot = new StackPane();
        gameRoot.setStyle("-fx-background-color: black;");
        this.canvas = new Canvas(800.0, 600.0);
        this.gc = this.canvas.getGraphicsContext2D();
        Label levelLabel = this.createLevelLabel(level);
        StackPane.setAlignment(levelLabel, Pos.TOP_RIGHT);
        StackPane.setMargin(levelLabel, new Insets(10.0));
        this.scoreLabel = this.createScoreKeeperLabel(this.lvlHandler.getPlayer().getScore());
        StackPane.setAlignment(this.scoreLabel, Pos.TOP_LEFT);
        StackPane.setMargin(this.scoreLabel, new Insets(10.0));
        this.playerLevelLabel = this.createPlayerLevelLabel(this.lvlHandler.getPlayer().getLevel());
        StackPane.setAlignment(this.playerLevelLabel, Pos.BOTTOM_CENTER);
        StackPane.setMargin(this.playerLevelLabel, new Insets(10.0, 0.0, 20.0, 0.0));
        gameRoot.getChildren().addAll(new Node[]{this.canvas, levelLabel, this.scoreLabel, this.playerLevelLabel});
        Scene gameScene = new Scene(gameRoot, 800.0, 600.0);
        this.setupKeyHandling(gameScene);
        this.setupGameLoop();
        return gameScene;
    }

    private void switchToGameOverScene() {
        Platform.runLater(() -> {
            int finalScore = this.lvlHandler.getPlayer().getScore();
            GameOverScene gameOverSceneObj = new GameOverScene(this.primaryStage, finalScore);
            Scene gameOverScene = gameOverSceneObj.createGameOverScene();
            this.primaryStage.setScene(gameOverScene);
            this.primaryStage.show();
        });
    }
    private Label createLevelLabel(int level) {
        Label levelLabel = new Label("Level: " + level);
        levelLabel.setTextFill(Color.WHITE);
        levelLabel.setFont(new Font("Arial", 20.0));
        return levelLabel;
    }

    private Label createScoreKeeperLabel(int score) {
        Label scoreKeeperLabel = new Label("CurrentScore: " + score);
        scoreKeeperLabel.setTextFill(Color.WHITE);
        scoreKeeperLabel.setFont(new Font("Arial", 20.0));
        return scoreKeeperLabel;
    }

    private void updateScoreDisplay() {
        Platform.runLater(() -> {
            this.scoreLabel.setText("Score: " + this.lvlHandler.getPlayer().getScore());
        });
    }

    private Label createPlayerLevelLabel(int level) {
        Label levelLabel = new Label("Life Remain: " + level);
        levelLabel.setTextFill(Color.WHITE);
        levelLabel.setFont(new Font("Arial", 20.0));
        return levelLabel;
    }

    private void updatePlayerLevelDisplay() {
        Platform.runLater(() -> {
            this.playerLevelLabel.setText("Life Remain: " + this.lvlHandler.getPlayer().getLevel());
        });
    }

    private void setupKeyHandling(Scene mainScene) {
        mainScene.setOnKeyPressed((event) -> {
            if (event.getCode() == KeyCode.W) {
                this.lvlHandler.getPlayer().accelerate();
            } else if (event.getCode() == KeyCode.D) {
                this.lvlHandler.getPlayer().turnRight();
            } else if (event.getCode() == KeyCode.A) {
                this.lvlHandler.getPlayer().turnLeft();
            } else if (event.getCode() == KeyCode.L) {
                this.lvlHandler.shoot();
            }

        });
    }

    private void setupGameLoop() {
        (new AnimationTimer() {
            public void handle(long now) {
                Main.this.gc.clearRect(0.0, 0.0, Main.this.canvas.getWidth(), Main.this.canvas.getHeight());
                Main.this.lvlHandler.draw(Main.this.gc);
                Main.this.gc.save();
                Main.this.gc.translate(Main.this.lvlHandler.getPlayer().getPos().getX(), Main.this.lvlHandler.getPlayer().getPos().getY());
                Main.this.gc.rotate(Main.this.lvlHandler.getPlayer().getAngle());
                Main.this.lvlHandler.drawPlayer(Main.this.gc);
                Main.this.gc.restore();
                Main.this.updateScoreDisplay();
                Main.this.updatePlayerLevelDisplay();
            }
        }).start();
    }
}
