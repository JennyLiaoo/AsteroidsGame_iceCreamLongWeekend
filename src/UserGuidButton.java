import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class UserGuidButton {


        private HBox buttonBox;
        private Button userGuideButton;

        public UserGuidButton (Runnable userGuide){
            userGuideButton = new Button ("help?");

            String buttonStyle = "-fx-font: 22 arial; -fx-base: WHITE;";
            userGuideButton.setStyle(buttonStyle);

            // Positioning the buttons in HBox
            buttonBox = new HBox(90, userGuideButton);
            buttonBox.setPadding(new Insets(70, 50, 0, 200)); // Adjust padding as needed
        }

        public HBox getButtonBox() {
            return buttonBox;
        }



}
