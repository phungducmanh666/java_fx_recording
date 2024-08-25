package record.main.service;

import javafx.application.Platform;
import record.App;
import record.main.AppProperties;
import record.main.constance.RecordStatus;

public class RecordService {

    private static RecordService instance;
    public static RecordService gI(){
        if(instance == null)
        instance = new RecordService();
        return instance;
    }

    private RecordService(){}

    public void startRecord(){
        if(AppProperties.appRecordStatus != RecordStatus.NO_RECORD)
            return;
        Platform.runLater(() -> {
            AppProperties.appRecordStatus = RecordStatus.RECODING;
        });
    }
    public void stopRecord(){
        if(AppProperties.appRecordStatus == RecordStatus.NO_RECORD)
            return;
        Platform.runLater(() -> {
            AppProperties.appRecordStatus = RecordStatus.NO_RECORD;

        });
    }
    public void pauseRecord(){
        if(AppProperties.appRecordStatus != RecordStatus.RECODING)
        return;
        Platform.runLater(() -> {
            AppProperties.appRecordStatus = RecordStatus.PAUSE;

        });
    }
    public void resumeRecord(){
        if(AppProperties.appRecordStatus != RecordStatus.PAUSE)
        return;
        Platform.runLater(() -> {
            AppProperties.appRecordStatus = RecordStatus.RECODING;

        });
    }
}
