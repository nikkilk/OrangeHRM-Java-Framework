package utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {
	
	public static String getDate() {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern("DD-MM-yyyy HH-mm-ss"));
	}

}
