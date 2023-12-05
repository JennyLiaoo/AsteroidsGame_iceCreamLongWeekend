//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ResartGameButton {
    private HBox buttonBox;
    private Button restartGame = new Button("return");

    public ResartGameButton(Runnable returnOption) {
        String buttonStyle = "-fx-font: 22 arial; -fx-base: WHITE;";
        this.restartGame.setStyle(buttonStyle);
        this.buttonBox = new HBox(80.0, new Node[]{this.restartGame});
        this.buttonBox.setPadding(new Insets(60.0, 50.0, 0.0, 200.0));
    }

    public HBox getButtonBox() {
        return this.buttonBox;
    }
}
