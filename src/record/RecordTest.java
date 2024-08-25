// package record;

// import org.jcodec.api.SequenceEncoder;
// import org.jcodec.common.model.ColorSpace;
// import org.jcodec.common.model.Picture;
// import org.jcodec.common.model.Size;

// import java.awt.Color;
// import java.awt.Graphics2D;
// import java.awt.image.BufferedImage;
// import java.io.File;
// import java.io.IOException;

// public class RecordTest {

//     public static void main(String[] args) {
//         try {
//             // Tạo đối tượng SequenceEncoder để ghi video
//             File file = new File("./video/output.mp4");
//             SequenceEncoder encoder = SequenceEncoder.createSequenceEncoder(file, 25); // 25 fps

//             // Thêm các khung hình vào video
//             for (int i = 0; i < 100; i++) {
//                 BufferedImage bufferedImage = new BufferedImage(640, 480, BufferedImage.TYPE_INT_RGB);
//                 Graphics2D g = bufferedImage.createGraphics();
//                 g.setColor(Color.RED);
//                 g.fillRect(i * 5, i * 5, 100, 100); // Vẽ một hình chữ nhật di chuyển
//                 g.dispose();

//                 // Chuyển đổi BufferedImage thành Picture
//                 Picture picture = BufferedImageToPicture(bufferedImage);
//                 encoder.encodeNativeFrame(picture);
//             }

//             // Đóng encoder
//             encoder.finish();
//             System.out.println("Video created successfully!");

//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }

//     private static Picture BufferedImageToPicture(BufferedImage bufferedImage) {
//         int width = bufferedImage.getWidth();
//         int height = bufferedImage.getHeight();
//         Picture picture = Picture.create(width, height, ColorSpace.RGB);

//         int[] rgbArray = bufferedImage.getRGB(0, 0, width, height, null, 0, width);

//         // Chuyển đổi dữ liệu RGB từ BufferedImage thành định dạng Picture
//         byte[] redPlane = picture.getPlaneData(0);
//         byte[] greenPlane = picture.getPlaneData(1);
//         byte[] bluePlane = picture.getPlaneData(2);

//         for (int y = 0; y < height; y++) {
//             for (int x = 0; x < width; x++) {
//                 int rgb = rgbArray[y * width + x];
//                 redPlane[y * width + x] = (byte) ((rgb >> 16) & 0xFF);   // Red
//                 greenPlane[y * width + x] = (byte) ((rgb >> 8) & 0xFF);   // Green
//                 bluePlane[y * width + x] = (byte) (rgb & 0xFF);          // Blue
//             }
//         }
//         return picture;
//     }
// }
