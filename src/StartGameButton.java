import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;

public class StartGameButton {

    private HBox buttonBox;
    private Button startButton;

    public StartGameButton (Runnable clickToStart) {
        startButton = new Button("CLICK TO START");
        String buttonStyle = "-fx-font: 22 arial; -fx-base: BLACK;";
        startButton.setStyle(buttonStyle);

        // Set the action event for the start button
        startButton.setOnAction(event -> clickToStart.run());

        // Positioning the buttons in HBox
        buttonBox = new HBox(90, startButton);
        buttonBox.setPadding(new Insets(70, 50, 0, 200)); // Adjust padding as needed
    }

    public HBox getButtonBox() {
        return buttonBox;
    }
}
