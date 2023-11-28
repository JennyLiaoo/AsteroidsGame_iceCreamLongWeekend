import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent; // Corrected import
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GameOverScene extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage; // Use the passed primaryStage


        primaryStage.setTitle("Game_Over");

        Title titlePane = new Title("GAME OVER");
        AnchorPane anchorPane = new AnchorPane();

        ReturnButton returnButton = new ReturnButton(() -> switchBackToStart());


        // Set the position for the return button
        AnchorPane.setTopAnchor(returnButton.getButtonBox(), 280.0);
        AnchorPane.setLeftAnchor(returnButton.getButtonBox(), 280.0);


        // Set background using BackgroundManager
        BackgroundManager backgroundManager = new BackgroundManager("file:/Users/juliaqiu/Library/CloudStorage/OneDrive-AshburyCollege/Computer Science/AsteriodFinal/src/Images/userguide_background.png");
        anchorPane.setBackground(backgroundManager.getBackground());

        // Add components to the AnchorPane and set their positions
        AnchorPane.setTopAnchor(titlePane.getVBox(), 10.0);
        AnchorPane.setLeftAnchor(titlePane.getVBox(), 65.0);

        // Add components to the AnchorPane
        anchorPane.getChildren().addAll(titlePane.getVBox(), returnButton.getButtonBox());

        // Create Scene and set it on primaryStage
        Scene sceneStart = new Scene(anchorPane, 600, 400);
        primaryStage.setScene(sceneStart);
        primaryStage.show();
    }
    private void switchBackToStart() {
        // Create an instance of StartGameScene and set its scene
        StartGameScene startGameScene = new StartGameScene();
        primaryStage.setScene(startGameScene.createStartScene());
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}

