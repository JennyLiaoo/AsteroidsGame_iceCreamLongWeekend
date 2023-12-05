//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class UserGuideScene extends Application {
    private Stage primaryStage;

    public UserGuideScene(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("User Guide");
        primaryStage.setScene(this.createUserGuideScene(primaryStage));
        primaryStage.show();
        this.OpenUserGuide(primaryStage);
    }

    public void OpenUserGuide(Stage primaryStage) {
        Scene userGuideScene = this.createUserGuideScene(primaryStage);
        primaryStage.setScene(userGuideScene);
        primaryStage.show();
    }

    public Scene createUserGuideScene(Stage primaryStage) {
        AnchorPane anchorPane = new AnchorPane();
        ReturnButton returnButton = new ReturnButton(() -> {
            this.switchBackToStart();
        });
        AnchorPane.setTopAnchor(returnButton.getButtonBox(), 280.0);
        AnchorPane.setLeftAnchor(returnButton.getButtonBox(), 280.0);
        BackgroundManager backgroundManager = new BackgroundManager("file:src/Images/userguide_background.png");
        anchorPane.setBackground(backgroundManager.getBackground());
        UserGuideImages userGuideImage = new UserGuideImages("file:src/Images/userguide_text.png");
        userGuideImage.setSize(700.0, 700.0);
        AnchorPane.setTopAnchor(userGuideImage.getImageView(), 0.0);
        AnchorPane.setLeftAnchor(userGuideImage.getImageView(), -110.0);
        UserGuideImages spaceship = new UserGuideImages("file:src/Images/spaceship.png");
        spaceship.setSize(230.0, 230.0);
        AnchorPane.setTopAnchor(spaceship.getImageView(), 80.0);
        AnchorPane.setLeftAnchor(spaceship.getImageView(), -10.0);
        anchorPane.getChildren().addAll(new Node[]{userGuideImage.getImageView(), spaceship.getImageView(), returnButton.getButtonBox()});
        return new Scene(anchorPane, 600.0, 400.0);
    }

    private void switchBackToStart() {
        StartGameScene startGameScene = new StartGameScene(this.primaryStage);
        this.primaryStage.setScene(startGameScene.createStartScene());
        this.primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
