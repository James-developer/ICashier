package application;

public class NoQueueState  implements State{

	StoreQueue storeQueue;
			
	public void Queue(StoreQueue storeQueue) {
			System.out.println("\nNo customer in the line");
			storeQueue.setState(this);
		}

	public String toString() {
			return "Nobody at the line";
		}
	

}
