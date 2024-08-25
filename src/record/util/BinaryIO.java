package record.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BinaryIO {
    public static boolean writeObject(String filePath, Object object){

        try (FileOutputStream fos = new FileOutputStream(filePath)){
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(object);
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static <T> T readObject(String filePath, Class<T> clazz){
        T object = null;
        try (FileInputStream fileIn = new FileInputStream(filePath);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            object = clazz.cast(objectIn.readObject());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }
}
