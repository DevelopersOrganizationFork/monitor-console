package monitorconsole;


public class ConsoleRunnable implements Runnable {
	
	static Integer i = 0;
	
	public void run() {
					
		//	i++;
		//System.out.print("" + i.toString() + " host1\r");
		
		try
		{
			for (int j = 0; j < 10; j++) {
	            System.out.print("\rThinking... " + j);
	            System.out.flush();
	            Thread.sleep(100);
	        }
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		
		//System.out.print("" + i.toString() + " host2\r\n");
		//System.out.print("" + i.toString() + " host3\r\n");
		//System.out.print("" + i.toString() + " host4\r\n");
		
	}

}