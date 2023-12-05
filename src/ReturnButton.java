import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ReturnButton {
    private HBox buttonBox;
    private Button returnButton;

    public ReturnButton(Runnable returnOption){
        returnButton = new Button("Return");
        String buttonStyle = "-fx-font: 22 arial; -fx-base: WHITE;";
        returnButton.setStyle(buttonStyle);

        // Set the action for the button
        returnButton.setOnAction(e -> returnOption.run());

        // Positioning the buttons in HBox
        buttonBox = new HBox(80, returnButton);
        buttonBox.setPadding(new Insets(60, 50, 0, 200)); // Adjust padding as needed
    }

    public HBox getButtonBox() {
        return buttonBox;
    }
}
