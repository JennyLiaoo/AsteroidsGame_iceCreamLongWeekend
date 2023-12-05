import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class UserGuideImages {

    private ImageView imageView;

    public UserGuideImages(String imagePath) {
        Image image = new Image(imagePath);
        this.imageView = new ImageView(image);
    }

    public void setSize(double width, double height) {
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        imageView.setPreserveRatio(true);
    }

    public ImageView getImageView() {
        return imageView;
    }
}
