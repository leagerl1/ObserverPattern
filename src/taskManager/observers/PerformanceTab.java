package taskManager.observers;

import java.util.ArrayList;
import taskManager.display.DisplayFile;
import taskManager.util.FileProcessor;
import taskManager.logger.MyLogger;

public class PerformanceTab implements Observer, DisplayFile  {
    private String memTotal, memUsed, memFree, memCached, cpuIdle, cpuUserLevel, cpuSystemLevel;
    private String outputFile;

    /**
	 * toString method of Performance tab class
	 * @return string describing the class
    */
    public String toString(){
    	return "This is the PerformanceTab class which holds performance stats";
    }

   	/**
	 * Constructor for PerformanceTab object
	 * @param outputFileIn name of output file
   	*/
    public PerformanceTab(String outputFileIn){
	outputFile = outputFileIn;
    }
    
    /**
     * sets all fields with new performance stats
     * @param msg string containing all the performance stats
    */
    public void update(String msg){
    MyLogger logger = MyLogger.getInstance();
    logger.printMessage(3,"Updating PerformanceTab");
	String[] fields = msg.split("\\:");
	memTotal = fields[0];
	memUsed = fields[1];
	memFree = fields[2];
	memCached = fields[3];
	cpuIdle = fields[4];
	cpuUserLevel = fields[5];
	cpuSystemLevel = fields[6];
	writeToFile();
    }
    
    /** 
	 * writes the performance stats to file
    */
    public void writeToFile(){
	FileProcessor f = new FileProcessor(outputFile);
	MyLogger logger = MyLogger.getInstance();
	f.writeALine("---PERFORMANCE---");
	logger.printMessage(1,"---PERFORMANCE---");
	f.writeALine("Memory Total: " + memTotal + "  Memory Used: " + memUsed + "  Memory  Free: " + memFree + "  Memory  Cached: " + memCached);
	logger.printMessage(1,"Memory Total: " + memTotal + "  Memory Used: " + memUsed + "  Memory  Free: " + memFree + "  Memory  Cached: " + memCached);
	f.writeALine("CPU Idle: " + cpuIdle + "  CPU User Level: " + cpuUserLevel + "  CPU System Level: " + cpuSystemLevel);
	logger.printMessage(1,"CPU Idle: " + cpuIdle + "  CPU User Level: " + cpuUserLevel + "  CPU System Level: " + cpuSystemLevel);
	f.writeALine("");
	logger.printMessage(1,"");
    }
}



