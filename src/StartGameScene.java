import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class StartGameScene {
    private Stage primaryStage;
    private TitlePane titlePane;
    private StartGameButton startGameButton;
    private ControlButtons controlButtons;
    private LevelLabel levelLabel;
    private UserGuideButton userGuideButton;
    private BackgroundManager backgroundManager;

    public StartGameScene(Stage primaryStage) {
        this.primaryStage = primaryStage;
        initializeComponents();
    }

    private void initializeComponents() {
        titlePane = new TitlePane("ASTEROIDS");
        levelLabel = new LevelLabel();
        startGameButton = new StartGameButton(this::switchToGameScene);
        controlButtons = new ControlButtons(
                () -> levelLabel.updateLabel(false),
                () -> levelLabel.updateLabel(true));
        userGuideButton = new UserGuideButton(() -> switchToUserGuide());
        backgroundManager = new BackgroundManager("file:src/Images/space_background.jpg");
    }

    public Scene createStartScene() {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setBackground(backgroundManager.getBackground());

        StartSceneLayoutManager layoutManager = new StartSceneLayoutManager(anchorPane);
        layoutManager.setupLayout(titlePane, startGameButton, controlButtons, levelLabel, userGuideButton);

        return new Scene(anchorPane, 600, 400);
    }

    public void returnBackToStart() {
        primaryStage.setScene(createStartScene());
        primaryStage.show();
    }

    private void switchToGameScene() {
        int currentLevel = levelLabel.getCurrentLevel();
        Main mainApp = (Main) primaryStage.getUserData();
        if (mainApp != null) {
            mainApp.startGame(currentLevel);
        } else {
            System.out.println("Main application reference not found.");
        }
    }

    private void switchToUserGuide() {
        new UserGuideScene(primaryStage).OpenUserGuide(primaryStage);
    }
}