import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BackgroundAnimation {
    private BackgroundManager backgroundManager; // Assuming this manages the background
    private Pane animationPane;
    private List<ImageView> asteroids;
    private Random random;

    public BackgroundAnimation(BackgroundManager backgroundManager) {
        this.backgroundManager = backgroundManager;
        this.animationPane = new Pane();
        this.asteroids = new ArrayList<>();
        this.random = new Random();

        initializeAsteroids();
        //startAnimation();
    }

    private void initializeAsteroids() {
        // Load images and add them to the asteroids list
        String[] imagePaths = {
                "file:/Users/juliaqiu/IdeaProjects/DatabaseUI/src/Images/asteroid_level1.png",
                "file:/Users/juliaqiu/IdeaProjects/DatabaseUI/src/Images/asteroid_level2.png",
                "file:/Users/juliaqiu/IdeaProjects/DatabaseUI/src/Images/asteroid_level3.png",
        };

        for (String path : imagePaths) {
            ImageView imageView = new ImageView(new Image(path));
            imageView.setFitWidth(100); // Adjust size as needed
            imageView.setFitHeight(100);
            asteroids.add(imageView);
            animationPane.getChildren().add(imageView);
        }
    }

}
    /*

    private void startAnimation() {
        new AnimationTimer() {
            @Override
            public void handle(long now) {

            }


        public Pane getAnimationPane () {
            return animationPane;
        }
    }

     */