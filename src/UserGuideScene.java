import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class UserGuideScene extends Application {
    //private final StartGameScene startGameScene;
    private Stage primaryStage;

    public UserGuideScene(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        // Set the title of the primary stage
        primaryStage.setTitle("User Guide");

        // Create the user guide scene and set it to the primary stage
        primaryStage.setScene(createUserGuideScene(primaryStage));

        // Display the primary stage
        primaryStage.show();
        OpenUserGuide(primaryStage);
    }

    public void OpenUserGuide(Stage primaryStage){
        Scene userGuideScene = createUserGuideScene(primaryStage);
        primaryStage.setScene(userGuideScene);
        primaryStage.show();
    }

    public Scene createUserGuideScene(Stage primaryStage) {

        // Create an AnchorPane as the root for the scene layout
        AnchorPane anchorPane = new AnchorPane();

        // Assuming ReturnButton is a custom class that creates a button
        ReturnButton returnButton = new ReturnButton(() -> switchBackToStart(primaryStage));



        // Set the position for the return button
        AnchorPane.setTopAnchor(returnButton.getButtonBox(), 280.0);
        AnchorPane.setLeftAnchor(returnButton.getButtonBox(), 280.0);

        // Create and configure the background manager
        BackgroundManager backgroundManager = new BackgroundManager("file:/Users/juliaqiu/Library/CloudStorage/OneDrive-AshburyCollege/Computer Science/AsteriodFinal/src/Images/userguide_background.png");
        anchorPane.setBackground(backgroundManager.getBackground());

        // Create and configure the user guide image
        UserGuideImages userGuideImage = new UserGuideImages("file:/Users/juliaqiu/Library/CloudStorage/OneDrive-AshburyCollege/Computer Science/AsteriodFinal/src/Images/MicrosoftTeams-image.png");
        userGuideImage.setSize(230, 230);
        AnchorPane.setTopAnchor(userGuideImage.getImageView(), 80.0);
        AnchorPane.setLeftAnchor(userGuideImage.getImageView(), 50.0);

        // Add all components to the anchor pane
        anchorPane.getChildren().addAll(userGuideImage.getImageView(), returnButton.getButtonBox());

        // Create and return the scene with the configured anchor pane
        return new Scene(anchorPane, 600, 400);
    }

    /*
    private void switchBackToSceneHandler(Stage primaryStage) {
        // Switch back to the SceneHandler scene
        // This assumes that SceneHandler is set up to create and return its initial scene
        SceneHandler sceneHandler = new SceneHandler();
        primaryStage.setScene(sceneHandler.createInitialScene());
        primaryStage.show();
    }

     */
    private void switchBackToStart(Stage primaryStage) {
        StartGameScene startGameScene = new StartGameScene();
        primaryStage.setScene(startGameScene.createStartScene());
        primaryStage.show();
    }

    public static void main(String[] args) {
        // Launch the application
        Application.launch(args);
    }


}

