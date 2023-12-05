import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class BackgroundManager {
    private Image backgroundImage;
    private Background background;

    public BackgroundManager(String imagePath) {
        loadImage(imagePath);
        createBackgroundCover();
    }

    private void loadImage(String imagePath) {
        backgroundImage = new Image(imagePath);
    }

    public void createBackgroundCover() {
        // Create a BackgroundSize object that covers the entire area
        BackgroundSize bgSize = new BackgroundSize(
                BackgroundSize.AUTO,
                BackgroundSize.AUTO,
                false,
                false,
                true,
                true); // The last 'true' is to cover the entire area

        BackgroundImage bgImage = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                bgSize);
        background = new Background(bgImage);
    }

    public Background getBackground() {
        return background;
    }
}
