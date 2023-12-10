package selenium;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Test {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(getTimestamp());  
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public static String getTimestamp() {
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return timestamp.getTime() + "";
	}

}
