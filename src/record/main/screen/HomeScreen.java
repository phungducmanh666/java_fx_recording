package record.main.screen;

import java.awt.Color;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import record.main.AppProperties;
import record.main.RecordThread;
import record.main.constance.RecordStatus;
import record.util.TimeFormatter;

public class HomeScreen extends A_Screen {

    private static HomeScreen instance;
    public static HomeScreen gI(){
        if(instance == null)
        instance = new HomeScreen();
        return instance;
    }

    VBox layout;
    Button btnRecord;
    Button btnPause;
    public Text txtRecordTime;

    private HomeScreen(){
        layout = new VBox();
        btnRecord = new Button("Record");
        btnPause = new Button("Pause");
        txtRecordTime = new Text(TimeFormatter.formatTime(0));
        txtRecordTime.setFont(new Font(24));

        layout.setPadding(new Insets(10,10,10,10));

        setEvent();
        paint();
    }

    public void setEvent(){
        btnRecord.setOnMouseClicked(e -> {
            if(AppProperties.appRecordStatus == RecordStatus.NO_RECORD){
                // start record
                AppProperties.appRecordStatus = RecordStatus.RECODING;
                startRecord();
            }else if(AppProperties.appRecordStatus != RecordStatus.NO_RECORD){
                // stop record
                AppProperties.appRecordStatus = RecordStatus.NO_RECORD;
            }
            paint();
        });

        btnPause.setOnMouseClicked(e -> {
            if(AppProperties.appRecordStatus == RecordStatus.RECODING){
                AppProperties.appRecordStatus = RecordStatus.PAUSE;
            }else if(AppProperties.appRecordStatus == RecordStatus.PAUSE){
                AppProperties.appRecordStatus = RecordStatus.RECODING;
            }
            paint();
        });
    }

    @Override
    public void paint() {

        if(AppProperties.appRecordStatus == RecordStatus.NO_RECORD){
            btnRecord.setText("Record");
            btnPause.setText("Pause");
            btnPause.setDisable(true);
        }else if(AppProperties.appRecordStatus == RecordStatus.RECODING){
            btnRecord.setText("Stop");
            btnPause.setText("Pause");
            btnPause.setDisable(false);
        }else if(AppProperties.appRecordStatus == RecordStatus.PAUSE){
            btnRecord.setText("Stop");
            btnPause.setText("Resume");
            btnPause.setDisable(false);
        }

        HBox hBox = new HBox();

        hBox.getChildren().addAll(btnRecord, btnPause);
        hBox.setSpacing(10);

        layout.getChildren().clear();
        layout.getChildren().addAll(hBox, txtRecordTime);
    }

    @Override
    public void loadPaint() {
    }

    @Override
    public Pane getLayout() {
        return layout;
    }

    public void startRecord(){
        new RecordThread().start();
    }
    public void stopRecord(){
    }
}
