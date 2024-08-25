package record.main.layout;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import record.main.screen.A_Screen;
import record.main.screen.HomeScreen;

public class MainLayout extends A_Screen {

    private static MainLayout instance;
    public static MainLayout gI(){
        if (instance == null) {
            instance = new MainLayout();
        }
        return instance;
    }

    A_Screen sideBar;
    A_Screen currentScreen;

    BorderPane layout;

    private MainLayout(){
        layout = new BorderPane();
        sideBar = new MainSideBar();
        currentScreen = HomeScreen.gI();

        paint();
    }

    @Override
    public void paint() {
        layout.getChildren().clear();
        layout.setLeft(sideBar.getLayout());
        layout.setCenter(currentScreen.getLayout());
    }

    @Override
    public void loadPaint() {
    }

    @Override
    public Pane getLayout() {
        return layout;
    }

    public void changeScreen(A_Screen screen){
        this.currentScreen = screen;
        paint();
    }
}
