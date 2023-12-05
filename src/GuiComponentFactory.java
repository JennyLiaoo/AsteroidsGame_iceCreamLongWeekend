public class GuiComponentFactory {

    public IGuiComponent createTitlePane(String titleText) {
        return new TitlePane(titleText);
    }

    public IGuiComponent createStartGameButton(Runnable action) {
        return new StartGameButton(action);
    }

    public IGuiComponent createControlButtons(Runnable decreaseAction, Runnable increaseAction) {
        return new ControlButtons(decreaseAction, increaseAction);
    }

    public IGuiComponent createLevelLabel() {
        return new LevelLabel();
    }

    public IGuiComponent createUserGuideButton(Runnable userGuideAction) {
        return new UserGuideButton(userGuideAction);
    }

    // Add other methods for additional components as needed
}
