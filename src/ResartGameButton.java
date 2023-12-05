import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ResartGameButton {
    private HBox buttonBox;
    private Button restartGame;

    public ResartGameButton(Runnable returnOption){
        restartGame = new Button ("return");

        String buttonStyle = "-fx-font: 22 arial; -fx-base: WHITE;";
        restartGame.setStyle(buttonStyle);

        // Positioning the buttons in HBox
        buttonBox = new HBox(80, restartGame);
        buttonBox.setPadding(new Insets(60, 50, 0, 200)); // Adjust padding as needed
    }

    public HBox getButtonBox() {
        return buttonBox;
    }
}
