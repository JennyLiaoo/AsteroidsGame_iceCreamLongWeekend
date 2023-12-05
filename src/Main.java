/**
 * Main class
 *
 * @author
 * @version 4.0
 * @since   2023-12-4
 */
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class Main extends Application {
    private Stage primaryStage;
    private GraphicsContext gc;
    private LvlHandler lvlHandler;
    private Canvas canvas;
    private Label scoreLabel;
    private Label playerLevelLabel;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
// In your Main class
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setUserData(this); // Set the Main instance as user data
        StartGameScene startScene = new StartGameScene(primaryStage);
        Scene startSceneInstance = startScene.createStartScene();
        primaryStage.setScene(startSceneInstance);
        primaryStage.setTitle("Asteroid_JennyEmi_Version");
        primaryStage.show();
    }

    public void startGame(int level) {
        //resetGameState(level);
        Scene gameScene = createGameScene(level);
        primaryStage.setTitle("Asteroids");
        primaryStage.setScene(gameScene);
        primaryStage.show();
    }

    private Scene createGameScene(int level) {
        this.lvlHandler = new LvlHandler(level, this::switchToGameOverScene);

        StackPane gameRoot = new StackPane();
        gameRoot.setStyle("-fx-background-color: black;");

        canvas = new Canvas(800, 600);
        gc = canvas.getGraphicsContext2D();

        Label levelLabel = createLevelLabel(level);
        StackPane.setAlignment(levelLabel, Pos.TOP_RIGHT);
        StackPane.setMargin(levelLabel, new Insets(10));

        this.scoreLabel = createScoreKeeperLabel(lvlHandler.getPlayer().getScore()); // Initialize score label
        StackPane.setAlignment(scoreLabel, Pos.TOP_LEFT);
        StackPane.setMargin(scoreLabel, new Insets(10));

        this.playerLevelLabel = createPlayerLevelLabel(lvlHandler.getPlayer().getLevel()); // Initialize player level label
        StackPane.setAlignment(playerLevelLabel, Pos.BOTTOM_CENTER);
        StackPane.setMargin(playerLevelLabel, new Insets(10, 0, 20, 0)); // Adjust margins as needed

        gameRoot.getChildren().addAll(canvas, levelLabel, scoreLabel, playerLevelLabel); // Add player level label to the root

        Scene gameScene = new Scene(gameRoot, 800, 600);
        setupKeyHandling(gameScene);
        setupGameLoop();

        return gameScene;
    }


    private void switchToGameOverScene() {
        int finalScore = lvlHandler.getPlayer().getScore(); // Get the final score from the player

        GameOverScene gameOverSceneObj = new GameOverScene(primaryStage, finalScore); // Create a GameOverScene object
        Scene gameOverScene = gameOverSceneObj.createGameOverScene(); // Create the scene

        primaryStage.setScene(gameOverScene);
        primaryStage.show();
    }

    private Label createLevelLabel(int level) {
        Label levelLabel = new Label("Level: " + level);
        levelLabel.setTextFill(Color.WHITE);
        levelLabel.setFont(new Font("Arial", 20));
        return levelLabel;
    }

    private Label createScoreKeeperLabel(int score) {
        Label scoreKeeperLabel = new Label("CurrentScore: " + score);
        scoreKeeperLabel.setTextFill(Color.WHITE);
        scoreKeeperLabel.setFont(new Font("Arial", 20));
        return scoreKeeperLabel;
    }
    private void updateScoreDisplay() {
        Platform.runLater(() -> {
            scoreLabel.setText("Score: " + lvlHandler.getPlayer().getScore());
        });
    }
    private Label createPlayerLevelLabel(int level) {
        Label levelLabel = new Label("Life Remain: " + level);
        levelLabel.setTextFill(Color.WHITE); // Set the text color
        levelLabel.setFont(new Font("Arial", 20)); // Set the font size and style as needed
        return levelLabel;
    }

    private void updatePlayerLevelDisplay() {
        Platform.runLater(() -> {
            playerLevelLabel.setText("Life Remain: " + lvlHandler.getPlayer().getLevel());
        });
    }



    private void setupKeyHandling(Scene mainScene) {
        mainScene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.W) {
                lvlHandler.getPlayer().accelerate();
            } else if (event.getCode() == KeyCode.D) {
                lvlHandler.getPlayer().turnRight();
            } else if (event.getCode() == KeyCode.A) {
                lvlHandler.getPlayer().turnLeft();
            } else if (event.getCode() == KeyCode.L) {
                lvlHandler.shoot();
            }
        });
    }

    /*
    private void resetGameState(int level) {
        final int playerLevel = 5;
        if (lvlHandler != null) {
            lvlHandler.reset(playerLevel);
        } else {
            // If lvlHandler is null, you may need to initialize it again
            lvlHandler = new LvlHandler(playerLevel, this::switchToGameOverScene);
        }

        if (gc != null) {
            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        }
    }

     */

    private void setupGameLoop() {

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                lvlHandler.draw(gc);

                gc.save();
                gc.translate(lvlHandler.getPlayer().getPos().getX(), lvlHandler.getPlayer().getPos().getY());
                gc.rotate(lvlHandler.getPlayer().getAngle());
                lvlHandler.drawPlayer(gc);
                gc.restore();
                updateScoreDisplay(); // Update the score display
                updatePlayerLevelDisplay();
            }
        }.start();
    }
}
