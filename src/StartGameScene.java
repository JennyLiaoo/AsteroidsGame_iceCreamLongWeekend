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
        this.initializeComponents();
    }

    private void initializeComponents() {
        this.titlePane = new TitlePane("ASTEROIDS");
        this.levelLabel = new LevelLabel();
        this.startGameButton = new StartGameButton(this::switchToGameScene);
        this.controlButtons = new ControlButtons(() -> this.levelLabel.updateLabel(false),
                () -> this.levelLabel.updateLabel(true));
        this.userGuideButton = new UserGuideButton(this::switchToUserGuide);
        this.backgroundManager = new BackgroundManager("file:src/Images/space_background.jpg");
    }

    public Scene createStartScene() {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setBackground(this.backgroundManager.getBackground());
        StartSceneLayoutManager layoutManager = new StartSceneLayoutManager(anchorPane);
        layoutManager.setupLayout(this.titlePane, this.startGameButton, this.controlButtons, this.levelLabel, this.userGuideButton);
        return new Scene(anchorPane, 600.0, 400.0);
    }

    public void returnBackToStart() {
        this.primaryStage.setScene(this.createStartScene());
        this.primaryStage.show();
    }

    private void switchToGameScene() {
        int currentLevel = this.levelLabel.getCurrentLevel();
        Main mainApp = (Main) this.primaryStage.getUserData();
        if (mainApp != null) {
            mainApp.startGame(currentLevel);
        } else {
            System.out.println("Main application reference not found.");
        }
    }

    private void switchToUserGuide() {
        new UserGuideScene(this.primaryStage).OpenUserGuide(this.primaryStage);
    }
}
