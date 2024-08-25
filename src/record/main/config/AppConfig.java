package record.main.config;

import java.io.Serializable;

import record.util.BinaryIO;

public class AppConfig implements Serializable {
    private static AppConfig instance;
    public static AppConfig gI(){
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }

    public static String defaultRelitiveConfigFile = "./src/record/res/applicationConfig.dat";
    public static String defaultOutputPath = "D://dede";

    public String outputPath = defaultOutputPath;
    public int videoFps = 60;

    private AppConfig(){
        AppConfig appConfig = readConfig();
        if(appConfig != null){
            this.outputPath = appConfig.outputPath;
        }
        else{
            outputPath = defaultOutputPath;
        }
    }

    @Override
    public String toString() {
        return String.format("{outputPath: %s, videoFps: %d}", outputPath, videoFps);
    }

    public void saveConfing(){
        BinaryIO.writeObject(defaultRelitiveConfigFile, this);
    }

    public AppConfig readConfig(){
        return BinaryIO.readObject(defaultRelitiveConfigFile, AppConfig.class);
    }
}
