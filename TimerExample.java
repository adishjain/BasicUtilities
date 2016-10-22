import java.util.Timer;
import java.util.TimerTask;
 
public class TimerExample {
	Timer timer;
 
	public TimerExample(int seconds) {
		timer = new Timer();
		timer.schedule(new Reminder(), seconds * 1000);
	}
 
	class Reminder extends TimerTask {
		public void run() {
			System.out.format("Timer Task Finished..!%n");
			timer.cancel(); // Terminate the timer thread
		}
	}
 
	public static void main(String args[]) {
		new TimerExample(5);
		System.out.format("Task scheduled.. Now wait for 5 sec to see next message..%n");
	}
}