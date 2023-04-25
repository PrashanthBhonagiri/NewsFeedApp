import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class TimeAgo {

    public static String toRelative(Date date) {
        return toRelative(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
    }

    public static String toRelative(LocalDateTime dateTime) {
        LocalDateTime now = LocalDateTime.now();
        Duration duration = Duration.between(dateTime, now);
        long seconds = duration.getSeconds();
        if (seconds < 60) {
            return seconds + "s ago";
        } else if (seconds < 3600) {
            long minutes = seconds / 60;
            return minutes + "m ago";
        } else if (seconds < 86400) {
            long hours = seconds / 3600;
            return hours + "h ago";
        } else {
            long days = seconds / 86400;
            return days + "d ago";
        }
    }

}