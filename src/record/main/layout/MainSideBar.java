package record.main.layout;

import java.awt.Color;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import record.main.screen.A_Screen;
import record.main.screen.HomeScreen;
import record.main.screen.SettingScreen;

public class MainSideBar extends A_Screen {

    VBox layout;

    Button btnHome;
    Button btnSetting;

    public MainSideBar(){
        layout = new VBox();
        btnHome = new Button("Home");
        btnSetting = new Button("Setting");

        btnHome.setPrefWidth(200);
        btnSetting.setPrefWidth(200);
        layout.setPrefWidth(200);
        layout.setPadding(new Insets(10,10,10,10));
        layout.setSpacing(10);

        setEvent();
        paint();
    }

    public void setEvent(){
        btnHome.setOnMouseClicked(e -> {
            MainLayout.gI().changeScreen(HomeScreen.gI());
        });

        btnSetting.setOnMouseClicked(e -> {
            MainLayout.gI().changeScreen(new SettingScreen());
        });
    }

    @Override
    public void paint() {
        layout.getChildren().clear();
        layout.getChildren().addAll(btnHome, btnSetting);
    }

    @Override
    public void loadPaint() {
    }

    @Override
    public Pane getLayout() {
        return layout;
    }
    
}
