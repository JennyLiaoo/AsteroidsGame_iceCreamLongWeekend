import javafx.scene.Node;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class TitlePane implements IGuiComponent {
    private String titleText;
    private VBox vbox; // Node to be returned

    public TitlePane(String titleText) {
        this.titleText = titleText;
        initializeNode(); // Create the node during construction
    }

    private void initializeNode() {
        Text title = new Text(titleText);
        title.setFont(Font.font("Verdana", 75.0));
        title.setFill(Color.RED);

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(title.fillProperty(), Color.DARKCYAN)),
                new KeyFrame(Duration.seconds(3.0), new KeyValue(title.fillProperty(), Color.WHITESMOKE))
        );
        timeline.setAutoReverse(true);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        this.vbox = new VBox(title);
        this.vbox.setAlignment(Pos.CENTER);
        VBox.setMargin(title, new Insets(70.0, 0.0, 0.0, 0.0));
    }

    @Override
    public Node createNode() {
        return this.vbox; // Return the already created node
    }

    public Node getNode() {
        return this.createNode();
    }
}
