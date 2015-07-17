package taskManager.observers;

import java.util.ArrayList;
import taskManager.display.DisplayFile;
import taskManager.util.FileProcessor;
import taskManager.logger.MyLogger;

public class UsersTab implements Observer, DisplayFile{
    private ArrayList<String> names, statuses;
    private String outputFile;
 
    /**
	 * toString method of Users tab class
	 * @return string describing the class
    */
    public String toString(){
    	return "This is the UsersTab class which holds performance stats";
    }

    public UsersTab(String outputFileIn){
	names = new ArrayList<String>();
	statuses = new ArrayList<String>();
	outputFile = outputFileIn;
    }
    
    /**
     * adds all new users and their info
     * @param msg string containing all the users and info
    */
    public void update(String msg){
    MyLogger logger = MyLogger.getInstance();
    logger.printMessage(3,"Updating UsersTab");
	names.clear();
	statuses.clear();
	String[] users = msg.split("\\-");
	for(int i = 0; i < users.length; i++){
	    String[] fields = users[i].split("\\:");
	    names.add(fields[0]);
	    statuses.add(fields[1]);
	}
	writeToFile();
    }

    /** 
	 * writes the users info to file
    */
    public void writeToFile(){
	FileProcessor f = new FileProcessor(outputFile);
	MyLogger logger = MyLogger.getInstance();
	f.writeALine("---USERS---");
	logger.printMessage(1,"---USERS---");
	for(int i = 0; i < names.size(); i++){
	    f.writeALine("User: " + names.get(i) + "  Status: " + statuses.get(i));
	    logger.printMessage(1,"User: " + names.get(i) + "  Status: " + statuses.get(i));
	}
	f.writeALine("");
	logger.printMessage(1,"");
    }
}
