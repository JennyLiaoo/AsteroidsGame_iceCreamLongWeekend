import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ControlButtons {
    private HBox buttonBox;
    private Button leftControl;
    private Button rightControl;

    public ControlButtons(Runnable onLeftClick, Runnable onRightClick) {
        // Create buttons for controls
        leftControl = new Button("<");
        rightControl = new Button(">");

        // Styling buttons
        String buttonStyle = "-fx-font: 22 arial; -fx-base: BLACK;";
        leftControl.setStyle(buttonStyle);
        rightControl.setStyle(buttonStyle);

        // Set up event handlers for buttons
        leftControl.setOnAction(e -> onLeftClick.run());
        rightControl.setOnAction(e -> onRightClick.run());

        // Positioning the buttons in HBox
        buttonBox = new HBox(90, leftControl, rightControl);
        buttonBox.setPadding(new Insets(70, 50, 0, 200)); // Adjust padding as needed
    }

    public HBox getButtonBox() {
        return buttonBox;
    }
}