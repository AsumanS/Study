
public class Concurrency extends Thread{
	int x = 0;
	@Override
	public void run()
	{
	  for (int i = 0; i < 5; i++) {
	    x++;
	    
	  }
	  System.out.println(x);
	}

	public static void main(String[] args)
	{
		Concurrency c1 = new Concurrency();
		Concurrency d = new Concurrency();
		d.setDaemon(true);
		//Concurrency c2 = new Concurrency();
		
		d.start();
		c1.start();
		//c2.start();
		//System.out.println("-"+c1.x+"-"+c2.x);
	  for (int i = 0; i < 5; i++) {
		  System.out.println(c1.getState() +"-"+d.getState());
//		  Concurrency c1=new Concurrency();
		  c1.run();
		  
		  //System.out.println(i+"-"+c1.x);
		  
		  
		  //c2.run();
		  //System.out.println(i+"-"+c1.x+"-"+c2.x);
		  System.out.println(c1.getState()+"-"+d.getState());
	  }
	  
	  System.out.println(c1.getState()+"-"+d.getState());
	  
	}

}
