package application;

public class StoreQueue {
private State state;

public StoreQueue() {
	state = null;
}

public void setState(State state){
    this.state = state;		
 }

 public State getState(){
    return state;
 }
 
}
