package kof;

public class Log {

	public static void println(Object msg) {
		System.out.println(msg);
	}
	public static void print(Object msg) {
		System.out.println(msg);
	}
	
	public static void warning(Object msg) {
		System.out.println("경고 : ***" + msg + "***");
	}
}
