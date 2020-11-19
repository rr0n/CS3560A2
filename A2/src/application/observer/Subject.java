package application.observer;

public interface Subject{

	public abstract String getId();
	public abstract void attach(Observer observer);
	
	public abstract void detach(Observer observer);
	
	public abstract void notifyObservers();
}
