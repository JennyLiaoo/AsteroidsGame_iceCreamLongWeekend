import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Insets;

import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Scanner;
public class Main extends Application {     //contains graphics, inputs and game loop. Will call on LvlHandler and SceneHandler to set up the game after choices completed
    private GraphicsContext gc;
    private LvlHandler lvlHandler;
    public static void main(String[] args) {
        launch(args); //auto call start
    }
    public void start(Stage primaryStage) { //like a new main
        primaryStage.setTitle("Asteroids");//can have scene + can change scenes
        BorderPane root = new BorderPane();
        Scene mainScene = new Scene(root);
        primaryStage.setScene(mainScene);
        Canvas canvas = new Canvas(800, 600); //800, 600
        gc = canvas.getGraphicsContext2D();
        root.setCenter(canvas);
        lvlHandler = new LvlHandler(1);

// Create an ImageView and set its size
        //ImageView player = new ImageView(image);
        //player.setFitWidth(100);
        //player.setFitHeight(100);
        // player.setPreserveRatio(true);

// Add the ImageView to the layout
        //StackPane stackPane = new StackPane();
        //stackPane.getChildren().add(player);
        //root.setTop(stackPane);
        mainScene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.W) {
                // Move up
                lvlHandler.getPlayer().accelerate();
            }
            else if (event.getCode() == KeyCode.D) {
                // Rotate right
                lvlHandler.getPlayer().turnRight();
            } else if (event.getCode() == KeyCode.A) {
                // Rotate left
                lvlHandler.getPlayer().turnLeft();
            }
            else if (event.getCode() == KeyCode.M) {
                //testing in progress
                lvlHandler.replaceAsteroid();
            }
            else if (event.getCode() == KeyCode.N) {
                //testing in progress
                lvlHandler.enhanceAsteroid();
            }
            if (event.getCode() == KeyCode.L) {
                lvlHandler.getPlayer().shoot();
            }
            else if (event.getCode() == KeyCode.K) {
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
//creating the game loop
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                // Clear the canvas
                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                lvlHandler.draw(gc);
                // Update player's position and rotation based on key inputs
                gc.save();
                gc.translate(lvlHandler.getPlayer().getPos().getX(), lvlHandler.getPlayer().getPos().getY());
                gc.rotate(lvlHandler.getPlayer().getAngle());
                // Draw the image with its center at the origin (the new translated and rotated point)
                //gc.drawImage(image, -100 / 2, -100 / 2, 100, 100); // Use hardcoded size since ImageView is no longer used
                lvlHandler.drawPlayer(gc);
                gc.restore();
            }
        }.start();
        primaryStage.show();
    }
}