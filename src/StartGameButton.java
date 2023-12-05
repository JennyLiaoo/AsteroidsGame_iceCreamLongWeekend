import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;

public class StartGameButton implements IGuiComponent {
    private Runnable clickToStart;
    private Button startButton = new Button("Click to Start");
    private HBox buttonBox;

    public StartGameButton(Runnable clickToStart) {
        this.clickToStart = clickToStart;

        if (this.clickToStart == null) {
            throw new IllegalArgumentException("clickToStart action must not be null");
        }

        this.startButton.setStyle("-fx-font: 22 arial; -fx-base: BLACK;");
        this.startButton.setOnAction(event -> this.clickToStart.run());

        this.buttonBox = new HBox(this.startButton);
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
