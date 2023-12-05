import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class UserGuideButton implements IGuiComponent {
    private HBox buttonBox;
    private Button userGuideButton = new Button("help?");

    public UserGuideButton(Runnable userGuide) {
        String buttonStyle = "-fx-font: 22 arial; -fx-base: WHITE;";
        this.userGuideButton.setStyle(buttonStyle);
        this.userGuideButton.setOnAction(e -> userGuide.run());
        this.buttonBox = new HBox(this.userGuideButton);
        this.buttonBox.setPadding(new Insets(70.0, 50.0, 0.0, 200.0));
    }

    @Override
    public Node createNode() {
        return this.buttonBox;
    }

    public Node getNode() {
        return this.createNode();
    }
}
