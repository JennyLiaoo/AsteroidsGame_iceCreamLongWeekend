import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class StartGameScene extends Application {
    private Stage primaryStage;
    private LevelLabel levelLabel;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Asteroid_JennyEmi_Version");
        primaryStage.setScene(createStartScene());
        primaryStage.show();
    }

    Scene createStartScene() {
        this.primaryStage = primaryStage; // Set the primaryStage field

        // Create components
        Title titlePane = new Title("ASTEROIDS");
        levelLabel = new LevelLabel();
        ControlButtons controlButtons = new ControlButtons(
                () -> levelLabel.updateLabel(false),
                () -> levelLabel.updateLabel(true));

        StartGameButton startGameButton = new StartGameButton(
                () -> switchToGameScene());
        UserGuidButton userGuideButton = new UserGuidButton( () ->
                switchToUserGuide());

        // Create AnchorPane for layout
        AnchorPane anchorPane = new AnchorPane();

        // Set up mouse click event handler to print coordinates
        anchorPane.setOnMouseClicked(this::handleMouseClick);

        // Set background using BackgroundManager
        BackgroundManager backgroundManager = new BackgroundManager("file:/Users/juliaqiu/IdeaProjects/DatabaseUI/src/Images/space_background.jpg");
        anchorPane.setBackground(backgroundManager.getBackground());

        // Add components to the AnchorPane and set their positions
        AnchorPane.setTopAnchor(titlePane.getVBox(), 10.0);
        AnchorPane.setLeftAnchor(titlePane.getVBox(), 65.0);

        AnchorPane.setTopAnchor(startGameButton.getButtonBox(), 120.0);
        AnchorPane.setLeftAnchor(startGameButton.getButtonBox(), 0.0);

        AnchorPane.setTopAnchor(controlButtons.getButtonBox(), 200.0);
        AnchorPane.setLeftAnchor(controlButtons.getButtonBox(), 20.0);

        AnchorPane.setTopAnchor(levelLabel.getLabelBox(), 280.0);
        AnchorPane.setLeftAnchor(levelLabel.getLabelBox(), 272.0);

        AnchorPane.setTopAnchor(userGuideButton.getButtonBox(), -50.0);
        AnchorPane.setLeftAnchor(userGuideButton.getButtonBox(), -180.0);

        anchorPane.getChildren().addAll(titlePane.getVBox(), startGameButton.getButtonBox(), controlButtons.getButtonBox(), levelLabel.getLabelBox(), userGuideButton.getButtonBox());

        // Return Scene with AnchorPane as root
        return new Scene(anchorPane, 600, 400);
    }

    public void returnBackToStart() {
        primaryStage.setScene(createStartScene());
        primaryStage.show();
    }

    private void switchToGameScene() {
        // Switch to the game scene in Main class
        new Main().startGame(primaryStage);
    }

    private void switchToUserGuide() {
        // Switch to the User Guide scene
        new UserGuideScene(primaryStage).OpenUserGuide(primaryStage);
    }

    private void handleMouseClick(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();
        System.out.println("Mouse clicked at: X=" + x + ", Y=" + y);
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
