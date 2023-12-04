import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Title {
    private VBox vbox;

    public Title(String titleText) {
        // Creating the title text with animation
        Text title = new Text(titleText);
        title.setFont(Font.font("Verdana", 75));
        title.setFill(Color.RED);

        // Timeline for color animation
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(title.fillProperty(), Color.DARKCYAN)),
                new KeyFrame(Duration.seconds(3), new KeyValue(title.fillProperty(), Color.WHITESMOKE))
        );
        timeline.setAutoReverse(true);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        // Creating VBox for title
        vbox = new VBox(title);
        vbox.setAlignment(Pos.CENTER);
        VBox.setMargin(title, new Insets(70, 0, 0, 0)); // Adjust title position
    }

    public VBox getVBox() {
        return vbox;
    }
}
