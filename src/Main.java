import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.geometry.Insets;

public class Main extends Application {     //contains graphics, inputs and game loop. Will call on LvlHandler and SceneHandler to set up the game after choices completed
    private GraphicsContext gc;
    private LvlHandler lvlHandler;
    private Canvas canvas;
    public static void main(String[] args) {
        launch(args); //auto call start
    }

    @Override
    public void start(Stage primaryStage) {
        // Set the title for the window
        primaryStage.setTitle("Asteroids");

        // Initialize the game with a default level, e.g., level 1
        startGame(primaryStage, 1);
    }

    public void startGame(Stage primaryStage, int level) {
        System.out.println("Starting game at Level: " + level);

        StackPane gameRoot = new StackPane(); // Use StackPane for overlay
        gameRoot.setStyle("-fx-background-color: black;"); // Set background color to black

        canvas = new Canvas(800, 600); // Use the member variable
        gc = canvas.getGraphicsContext2D(); // Use the member variable

        Label levelLabel = createLevelLabel(level);
        StackPane.setAlignment(levelLabel, Pos.TOP_RIGHT); // Align label to top right
        StackPane.setMargin(levelLabel, new Insets(10)); // Margin for the label

        gameRoot.getChildren().addAll(canvas, levelLabel); // Add both canvas and label to StackPane

        lvlHandler = new LvlHandler(level); // Make sure LvlHandler is correctly implemented

        Scene gameScene = new Scene(gameRoot, 800, 600);
        setupKeyHandling(gameScene);
        setupGameLoop();

        primaryStage.setScene(gameScene);
        primaryStage.show();
    }


    private Label createLevelLabel(int level) {
        Label levelLabel = new Label("Level: " + level);
        levelLabel.setTextFill(Color.WHITE);
        levelLabel.setFont(new Font("Arial", 20));
        return levelLabel;
    }
// Create an ImageView and set its size
    //ImageView player = new ImageView(image);
    //player.setFitWidth(100);
    //player.setFitHeight(100);
    // player.setPreserveRatio(true);

    // Add the ImageView to the layout
    //StackPane stackPane = new StackPane();
    //stackPane.getChildren().add(player);
    //root.setTop(stackPane);
    //
    private void setupKeyHandling(Scene mainScene){
        mainScene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.W) {
                // Move up
                lvlHandler.getPlayer().accelerate();
            } else if (event.getCode() == KeyCode.D) {
                // Rotate right
                lvlHandler.getPlayer().turnRight();
            } else if (event.getCode() == KeyCode.A) {
                // Rotate left
                lvlHandler.getPlayer().turnLeft();
            } else if (event.getCode() == KeyCode.M) {
                //testing in progress
                lvlHandler.replaceAsteroid();
            } else if (event.getCode() == KeyCode.N) {
                //testing in progress
                lvlHandler.enhanceAsteroid();
            }
            if (event.getCode() == KeyCode.L) {
                lvlHandler.getPlayer().shoot();
            } else if (event.getCode() == KeyCode.K) {
                //would be same button as L but would call method that checks if player collided with powerUp already. if true, uses enhanced shoot
                lvlHandler.getPlayer().shootEnhanced();
            }
            //level change testing
            if (event.getCode() == KeyCode.I) { //level change test
                lvlHandler = new LvlHandler(1);
                System.out.println("Level 1");
            }
            if (event.getCode() == KeyCode.O) { //level change test
                lvlHandler = new LvlHandler(2);
                System.out.println("Level 2");
            }
            if (event.getCode() == KeyCode.P) { //level change test
                lvlHandler = new LvlHandler(3);
                System.out.println("Level 3");
            }
        });
    }
    //creating the game loop
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
            }
        }.start();
    }


}