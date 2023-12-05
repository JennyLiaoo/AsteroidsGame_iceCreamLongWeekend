import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ControlButtons implements IGuiComponent {
    private HBox buttonBox;
    private Button leftControl = new Button("<");
    private Button rightControl = new Button(">");

    public ControlButtons(Runnable onLeftClick, Runnable onRightClick) {
        String buttonStyle = "-fx-font: 22 arial; -fx-base: BLACK;";
        this.leftControl.setStyle(buttonStyle);
        this.rightControl.setStyle(buttonStyle);
        this.leftControl.setOnAction(e -> onLeftClick.run());
        this.rightControl.setOnAction(e -> onRightClick.run());
        this.buttonBox = new HBox(90.0, this.leftControl, this.rightControl);
        this.buttonBox.setPadding(new Insets(70.0, 50.0, 0.0, 200.0));
    }

    @Override
    public Node createNode() {
        return this.buttonBox;
    }

    public Node getNode() {
        // Assuming you have a method that creates and returns the JavaFX Node for TitlePane
        return this.createNode();
    }

}
