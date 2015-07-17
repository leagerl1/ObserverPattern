package taskManager.subject;

import taskManager.observers.Observer;
import taskManager.filter.DashboardFilter;
import taskManager.util.FileProcessor;
import java.util.HashMap;
import taskManager.logger.MyLogger;

public class DashBoardSubject implements Subject{
    private HashMap<Observer, DashboardFilter> observers = new HashMap<Observer, DashboardFilter>();

    /**
	 * toString method of DashBoard subject
	 * @return string version of the observers hashmap
    */
    public String toString(){
	return observers.toString();
    }
    
    /**
	 * adds an observer to the observers HashMap
	 * @param O Observer object to register as key
	 * @param F Filter object to register as value
    */
    public void registerObserver(Observer O, DashboardFilter F){
	observers.put(O,F);
    }

     /**
	 * removes an observer from the observers HashMap
	 * @param O Observer object to use as key to remove
    */
    public void removeObserver(Observer O){
	observers.remove(O);
    }

    /**
	 * Calls updates all observers that match appropriate filter with given message
	 * @param msg message to update observers with
    */
    public void notifyObservers(String msg){
	for(Observer o : observers.keySet()){
	    int observerTypeIndex = msg.indexOf(":");
	    String observerType = msg.substring(0,observerTypeIndex);
	    if(observers.get(o).check(observerType)){
		MyLogger logger = MyLogger.getInstance();
		logger.printMessage(4, "Filter match found for " +observerType);
		o.update(msg.substring(observerTypeIndex+1));
	    }
	}
    }


	/**
	 * Starts file processing to simulate incoming updates in dashboard
	 * @param inputFile file to get input from
	 * @param outputFile file to write out to
    */
    public void startProcessing(String inputFile, String outputFile){
	FileProcessor fIn = new FileProcessor(inputFile);
	FileProcessor fOut = new FileProcessor(outputFile);
	MyLogger logger = MyLogger.getInstance();
	int lineCounter = 0;
	String line;  
	while(!(line = fIn.readALine(lineCounter)).equals("DONE")){
	    fOut.writeALine("---TAB(s) BEGIN---");
	    logger.printMessage(1, "---TAB(s) BEGIN---");
	    String[] instances = line.split("\\*");
	    for(int i = 0; i < instances.length; i++){
		notifyObservers(instances[i]);
	    }
	    fOut.writeALine("---TAB(s) END---");
	    logger.printMessage(1,"---TAB(s) END---");
	    lineCounter++;
	}
    }
}
