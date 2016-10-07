
public class Container {
	private boolean contains = false;
	
	synchronized
	public void put() throws InterruptedException 
	{
		while(contains)
		{
			this.wait();
		}
		Thread.sleep(500);
		System.out.println("PUT");
		contains = true;
		this.notify();
	}
	
	synchronized
	public void get() throws InterruptedException
	{
		while(!contains)
		{
			this.wait();
		}
		Thread.sleep(500);
		System.out.println("GET");
		contains = false;
		this.notify();
	}
}
