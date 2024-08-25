package record.core;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import record.main.config.AppConfig;


public class BaseRecord implements I_RecordStrategy {

    Rectangle screenRect;
    Robot robot;

    @Override
    public void start() {
        screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {
    }

    @Override
    public void saveFrame() {
        if(robot == null){
            System.err.println("robot is null");
        }
        try {
            BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
            String fileName = String.format("%s/%d.png", AppConfig.gI().outputPath, System.currentTimeMillis());
            System.out.println(fileName);
            File file = new File(fileName);
            ImageIO.write(screenFullImage, "png", file); 
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
}
