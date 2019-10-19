package application;

public class QueueState implements State{

	StoreQueue storeQueue;
	
	public void Queue(StoreQueue storeQueue) {
		System.out.println("\nA customer in the line");
		storeQueue.setState(this);
	}
	
	public String toString() {
		return " people at the line";
	}

}
