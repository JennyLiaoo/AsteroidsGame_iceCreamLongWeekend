//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ReturnButton {
    private HBox buttonBox;
    private Button returnButton = new Button("Return");

    public ReturnButton(Runnable returnOption) {
        String buttonStyle = "-fx-font: 22 arial; -fx-base: WHITE;";
        this.returnButton.setStyle(buttonStyle);
        this.returnButton.setOnAction((e) -> {
            returnOption.run();
        });
        this.buttonBox = new HBox(80.0, new Node[]{this.returnButton});
        this.buttonBox.setPadding(new Insets(60.0, 50.0, 0.0, 200.0));
    }

    public HBox getButtonBox() {
        return this.buttonBox;
    }
}
