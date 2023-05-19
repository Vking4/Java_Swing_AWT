import java.util.TimeZone;

public class DateTime {
    
    public static void main(String[] args) {
        long currentTimeMillis = System.currentTimeMillis();
        
        // Convert to GMT time zone
        TimeZone gmtTimeZone = TimeZone.getTimeZone("GMT");
        long gmtOffsetMillis = gmtTimeZone.getOffset(currentTimeMillis);
        long gmtTimeMillis = currentTimeMillis - gmtOffsetMillis;
        
        // Extract hour, minute, and second components
        int gmtHour = (int) (gmtTimeMillis / (60 * 60 * 1000)) % 24;
        int gmtMinute = (int) (gmtTimeMillis / (60 * 1000)) % 60;
        int gmtSecond = (int) (gmtTimeMillis / 1000) % 60;
        
        // Display the time in the desired format
        System.out.println(gmtHour + ":" + gmtMinute + ":" + gmtSecond);
    }
}
