package taskManager.observers;

import java.util.ArrayList;
import taskManager.display.DisplayFile;
import taskManager.util.FileProcessor;
import taskManager.logger.MyLogger;

public class ProcessesTab implements Observer, DisplayFile{
    private ArrayList<String> commands, users, PIDs, CPUs, MEMs;
    private String outputFile;
    
 	/**
	 * toString method of Processes tab class
	 * @return string describing the class
    */
    public String toString(){
    	return "This is the ProcessesTab class which holds performance stats";
    }

    public ProcessesTab(String outputFileIn){
	PIDs = new ArrayList<String>();
	commands = new ArrayList<String>();
	users = new ArrayList<String>();
	CPUs = new ArrayList<String>();
	MEMs = new ArrayList<String>();
	outputFile = outputFileIn;
    }
    
    /**
     * adds all the new processes and their info
     * @param msg string containing all the process info
    */
    public void update(String msg){
    MyLogger logger = MyLogger.getInstance();
    logger.printMessage(3,"Updating ProcessesTab");
	PIDs.clear();
	commands.clear();
	users.clear();
	CPUs.clear();
	MEMs.clear();
	String[] people = msg.split("\\-");
	for(int i = 0; i < people.length; i++){
	    String[] fields = people[i].split("\\:");
	    PIDs.add(fields[0]);
	    commands.add(fields[1]);
	    users.add(fields[2]);
	    CPUs.add(fields[3]);
	    MEMs.add(fields[4]);
	}
	writeToFile();
    }

    /** 
	 * writes the processes info to file
    */
    public void writeToFile(){
	FileProcessor f = new FileProcessor(outputFile);
	MyLogger logger = MyLogger.getInstance();	
	f.writeALine("---PROCESSES---");
	f.writeALine("  PID COMMAND         USER     %CPU %MEM");
	logger.printMessage(1,"---PROCESSES---");
	logger.printMessage(1,"  PID COMMAND         USER     %CPU %MEM");
	for(int i = 0; i < PIDs.size(); i++){
	    String line = "";
	    if(PIDs.get(i).length() < 5){
		line += " " + PIDs.get(i);
	    }
	    else{
		line += PIDs.get(i);
	    }
	    line += " " + commands.get(i);
	    int length = line.length();
	    for(int j = 0; j < (22 - length); j++){
		line += " ";
	    }
	    line += users.get(i);
	    length = line.length();
	    for(int j = 0; j < (32 - length); j++){
		line += " ";
	    }
	    line += CPUs.get(i) + "  " + MEMs.get(i);
	    f.writeALine(line);
	    logger.printMessage(1,line);
	}
	f.writeALine("");
	logger.printMessage(1,"");
    }
}
