package utilities;

public class LogGateway {
	public static void debug(String msg) {
		//TODO get real logging working
		if (isDebug()) {
			System.out.println(msg);
		}
	}

	public static void setCurrentLogLevel(int logLevelDebug) {
		// TODO Auto-generated method stub
		
	}

	public static boolean isDebug() {
		return true;
	}
}
