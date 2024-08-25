package record.main.screen;

import java.io.File;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import record.main.config.AppConfig;

public class SettingScreen  extends A_Screen{

    VBox layout;

    Text txtLocation;
    TextField tfLocation;
    Button btnChangeLocation;

    Text txtFps;
    TextField tfFps;
    Button btnChangeFps;

    public SettingScreen(){
        layout = new VBox();

        txtLocation = new Text("Output location");
        btnChangeLocation  = new Button("Location");
        tfLocation = new TextField(AppConfig.gI().outputPath);
        tfLocation.setEditable(false);

        txtFps = new Text("Video Fps");
        btnChangeFps  = new Button("Change FPS");
        tfFps = new TextField(Integer.toString(AppConfig.gI().videoFps));
        tfFps.setEditable(false);


        layout.setAlignment(Pos.TOP_LEFT);
        layout.setPadding(new Insets(10,10,10,10));
        layout.setSpacing(10);

        setEvent();
        paint();
    }

    public void setEvent(){
        // on change location
        btnChangeLocation.setOnMouseClicked(e -> {
            DirectoryChooser directoryChooser = new DirectoryChooser();
            directoryChooser.setTitle("Chọn một thư mục");
            File selectedDirectory = directoryChooser.showDialog(layout.getScene().getWindow());

            if (selectedDirectory != null) {
                String newPath = selectedDirectory.getAbsolutePath();
                AppConfig.gI().outputPath = newPath;
                AppConfig.gI().saveConfing();
                tfLocation.setText(AppConfig.gI().readConfig().outputPath);
                System.out.println("Thư mục được chọn: " + newPath);
            } else {
                System.out.println("Không có thư mục nào được chọn.");
            }
        });
    
        // onchange fps
        btnChangeFps.setOnMouseClicked(e -> {
            
        });
    }

    @Override
    public void paint() {
        layout.getChildren().clear();

        VBox vBoxLocation = new VBox();
        HBox hBoxlocation = new HBox();
        hBoxlocation.getChildren().clear();
        hBoxlocation.getChildren().addAll(tfLocation, btnChangeLocation);
        vBoxLocation.getChildren().addAll(txtLocation, hBoxlocation);

        VBox vBoxFps = new VBox();
        HBox hBoxFps = new HBox();
        hBoxFps.getChildren().clear();
        hBoxFps.getChildren().addAll(tfFps, btnChangeFps);
        vBoxFps.getChildren().addAll(txtFps, hBoxFps);

        layout.getChildren().addAll(vBoxLocation, vBoxFps);
    }

    @Override
    public void loadPaint() {
    }

    @Override
    public Pane getLayout() {
        return layout;
    }
    
}
