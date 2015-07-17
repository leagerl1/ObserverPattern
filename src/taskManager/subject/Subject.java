package taskManager.subject;

import taskManager.observers.Observer;
import taskManager.filter.DashboardFilter;

public interface Subject{

	/** 
	 * method to add an observer 
	 * @param O observer to add
	 * @param F Filter to add
	*/
    public void registerObserver(Observer O, DashboardFilter F);

    /** 
     * method to remove an observer 
     * @param O Observer to remove
    */
    public void removeObserver(Observer O);

    /** 
     * method to update all observers 
     * @param msg string to update observers with
    */
    public void notifyObservers(String msg);

    /** 
     * method to start file processing for dashboard simulation 
     * @param inputFile input file for reading
     * @param ouputFil output file for writing
    */
    public void startProcessing(String inputFile, String outputFile);
}
