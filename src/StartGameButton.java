import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class StartGameButton {

    private HBox buttonBox;
    private Button startButton;

    public StartGameButton (Runnable clickToStark){
        startButton = new Button ("CLICK TO START");

        String buttonStyle = "-fx-font: 22 arial; -fx-base: BLACK;";
        startButton.setStyle(buttonStyle);

        // Positioning the buttons in HBox
        buttonBox = new HBox(90, startButton);
        buttonBox.setPadding(new Insets(70, 50, 0, 200)); // Adjust padding as needed
    }

    public HBox getButtonBox() {
        return buttonBox;
    }

}
