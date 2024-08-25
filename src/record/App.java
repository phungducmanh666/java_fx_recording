package record;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import record.main.layout.MainLayout;
import record.main.screen.A_Screen;

import java.awt.Desktop;

public class App extends Application {

    private static App instance;
    public static App gI(){
        return instance;
    }

    Stage primaryStage;
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        instance = this;
        this.primaryStage = primaryStage;
        changeScreen(primaryStage, MainLayout.gI());

    }

    public void changeScreen(Stage stage, A_Screen screen){
        Scene scene = new Scene(screen.getLayout(), 500, 200);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void rePaint(){
        changeScreen(primaryStage, MainLayout.gI());
    }
}
