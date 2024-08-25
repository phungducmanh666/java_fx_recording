package record.main;

import javafx.application.Platform;
import record.core.BaseRecord;
import record.core.I_RecordStrategy;
import record.main.config.AppConfig;
import record.main.constance.RecordStatus;
import record.main.screen.HomeScreen;
import record.util.TimeFormatter;

public class RecordThread extends Thread{

    private long frame = 0;
    private long nextTime = 0;
    I_RecordStrategy recordStrategy;

    public RecordThread(){}
    
    @Override
    public void run() {

        frame = 0;
        int delay = 1000 / AppConfig.gI().videoFps;
        recordStrategy = new BaseRecord();
        recordStrategy.start();

        while (AppProperties.appRecordStatus != RecordStatus.NO_RECORD) {
            try {
                Thread.sleep(1);
            } catch (Exception e) {
            }
            
            // if(System.currentTimeMillis() < nextTime){
            //     continue;
            // }
            // nextTime = System.currentTimeMillis() + delay;

            if(AppProperties.appRecordStatus == RecordStatus.PAUSE){
                System.out.println("PAUSE");
                continue;
            }
            recordStrategy.saveFrame();
            // System.out.println("RECORDING");
            frame ++;
            Platform.runLater(() -> {
                HomeScreen.gI().txtRecordTime.setText(TimeFormatter.formatTime(getVideoTime()));
            });
        }
        System.out.println("STOP RECORD");
    }

    public long getVideoTime(){
        // return frame / 60 * 1000;
        return frame * 1000;
    }
}
