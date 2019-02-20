public class DCP10{

	/**
	 * Runs the instance method object after n milliseconds.
	 * @param	toRun instance method object
	 * @param	milli milliseconds
	 */
	public static void jobScheduler(Runnable toRun, int milli){
		try{
			Thread.sleep(milli);
			toRun.run();
		}catch(Exception e){
			System.out.println("jobScheduler Exception Thrown");
		}
	}

	public static void sayHello(){
		System.out.println("Hello");
	}
	public static void main(String[] args){
		jobScheduler(DCP10::sayHello, 5000);
	}
}