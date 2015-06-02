package monitorconsole;
import java.util.*;
public class ConsoleRunnable implements Runnable {
	
	static Integer counter = 0;
	private ConsoleUI ui;
	Random generator = new Random();
	 
	public ConsoleRunnable(ConsoleUI ui) {
		this.ui = ui;
	}
	
	public void run() {
					
		counter++;
		ui.print
		(
			"Machine" + "\t" + "step" + "\t" + "CPU" + "\t" + "Mem" + "\n" +
			"host1" + "\t" + counter.toString() + "\t" + generator.nextInt(100) +"%" + "\t" + generator.nextInt(100) + "%" + "\n" +
			"host2" + "\t" + counter.toString() + "\t" + generator.nextInt(100) +"%" + "\t" + generator.nextInt(100) + "%" + "\n" +
			"host3" + "\t" + counter.toString() + "\t" + generator.nextInt(100) +"%" + "\t" + generator.nextInt(100) + "%" + "\n" +
			"host4" + "\t" + counter.toString() + "\t" + generator.nextInt(100) +"%" + "\t" + generator.nextInt(100) + "%" + "\n" +
			"host5" + "\t" + counter.toString() + "\t" + generator.nextInt(100) +"%" + "\t" + generator.nextInt(100) + "%" + "\n" +
			"host6" + "\t" + counter.toString() + "\t" + generator.nextInt(100) +"%" + "\t" + generator.nextInt(100) + "%" + "\n" +
			"host7" + "\t" + counter.toString() + "\t" + generator.nextInt(100) +"%" + "\t" + generator.nextInt(100) + "%" + "\n" +
			"host8" + "\t" + counter.toString() + "\t" + generator.nextInt(100) +"%" + "\t" + generator.nextInt(100) + "%" + "\n" +
			"host9" + "\t" + counter.toString() + "\t" + generator.nextInt(100) +"%" + "\t" + generator.nextInt(100) + "%" + "\n" +
			"host10" + "\t" + counter.toString() + "\t" + generator.nextInt(100) +"%" + "\t" + generator.nextInt(100) + "%" + "\n"
		);
	}
}