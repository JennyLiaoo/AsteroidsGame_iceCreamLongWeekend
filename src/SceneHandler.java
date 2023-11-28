import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class SceneHandler extends Application {

    private LevelLabel levelLabel;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Initialize the Stage
        primaryStage.setTitle("Asteroid_JennyEmi_Version");

        // Create Title, ControlButtons, and LevelLabel components
        Title titlePane = new Title("ASTEROIDS");
        levelLabel = new LevelLabel();
        ControlButtons controlButtons = new ControlButtons(
                () -> levelLabel.updateLabel(false),
                () -> levelLabel.updateLabel(true));
        StartGameButton startGameButton = new StartGameButton(
                () -> System.out.println("Game Started!")); // Replace with actual game start logic
        UserGuidButton userGuideButton = new UserGuidButton(() -> {
            // User Guide logic here
        });


        // Set topBox to the top region of BorderPane
        BorderPane borderPane = new BorderPane();
        // borderPane.setTop(topBox); // Set the HBox (with title and user guide button) to the top


        // Create GridPane for layout
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10); // Horizontal gap between columns
        gridPane.setVgap(10); // Vertical gap between rows
        gridPane.setPadding(new Insets(10, 10, 10, 10)); // Padding around the grid

        // Add ControlButtons and LevelLabel to the GridPane
        gridPane.add(controlButtons.getButtonBox(), 0, 1); // ControlButtons in column 0, row 1
        gridPane.add(levelLabel.getLabelBox(), 1, 1); // LevelLabel in column 1, row 1
        gridPane.add(startGameButton.getButtonBox(), 0, 0, 3, 1); // StartGameButton in column 0, row 0 spanning 3 columns

        // Adjust label position if necessary
        levelLabel.setLabelPosition(0, 0, 0, 0);


        // Create BorderPane and set its components

        borderPane.setTop(titlePane.getVBox());
        borderPane.setCenter(gridPane); // Set GridPane in the center

        // Set background using BackgroundManager (assuming this class exists)
        BackgroundManager backgroundManager = new BackgroundManager("file:/Users/juliaqiu/IdeaProjects/DatabaseUI/src/Images/space_background.jpg");
        borderPane.setBackground(backgroundManager.getBackground());
        //BackgroundAnimation = new BackgroundAnimation(backgroundManager);
        //borderPane.setCenter(backgroundAnimation.getAnimationPane());


        // Create Scene with BorderPane as root
        Scene sceneStart = new Scene(borderPane, 600, 400);

        // Set up key event handlers for scene
        sceneStart.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.LEFT) {
                levelLabel.updateLabel(false);
            } else if (e.getCode() == KeyCode.RIGHT) {
                levelLabel.updateLabel(true);
            }
        });
        //borderPane.setTop(topBox);
        primaryStage.setScene(sceneStart);
        primaryStage.show();
    }
}
