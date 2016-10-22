import java.lang.Thread;
import java.lang.Thread.*;
class multi extends Thread
{
	public void run()
	{
		for(int i=0;i<10;i++)
		{
			try{if(i==2)
				sleep(1000);
			}
			catch(Exception e){}
			System.out.println("thread 1  "+i);
		}
	}
}
class multi1 implements Runnable
{
	public void run()
	{
		for(int i=0;i<10;i++)
			System.out.println("thread 2  "+i);
	}
}
class multi2
{
	public static void main(String[] ar)
	{
		multi ob=new multi();
		multi1 ob1=new multi1();
		//Thread t1=new Thread(ob);
		Thread t2=new Thread(ob1);
		ob.setPriority(1);
		t2.setPriority(10);
		ob.start();
		t2.start();
		System.out.println(ob.isAlive());
		
	}
}
