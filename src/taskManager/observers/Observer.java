package taskManager.observers;

public interface Observer{

	/** 
	 * method for updating observer with given message
	 * @param msg string to update observers with
	*/
    public void update(String msg);
}
