import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class UserGuideButton {

    private HBox buttonBox;
    private Button userGuideButton;

    public UserGuideButton(Runnable userGuide) {
        userGuideButton = new Button("help?");
        String buttonStyle = "-fx-font: 22 arial; -fx-base: WHITE;";
        userGuideButton.setStyle(buttonStyle);

        // Assign the action to the button
        userGuideButton.setOnAction(e -> userGuide.run());

        // Positioning the buttons in HBox
        buttonBox = new HBox(90, userGuideButton);
        buttonBox.setPadding(new Insets(70, 50, 0, 200)); // Adjust padding as needed
        buttonBox.setPadding(new Insets(70, 50, 0, 200)); // Adjust padding as needed
    }

    public HBox getNode() {
        return buttonBox;
    }
}
