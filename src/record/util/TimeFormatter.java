package record.util;

public class TimeFormatter {
    public static String formatTime(long milliseconds) {
        long totalSeconds = milliseconds / 1000;
        long ms = milliseconds % 1000;
        long hours = totalSeconds / 3600;
        long minutes = (totalSeconds % 3600) / 60;
        long seconds = totalSeconds % 60;

        // Định dạng thời gian dưới dạng hh:mm:ss:ms
        return String.format("%02d:%02d:%02d:%03d", hours, minutes, seconds, ms);
    }
}
