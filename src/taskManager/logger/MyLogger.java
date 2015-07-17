package taskManager.logger;

public class MyLogger{
    private static int loggerVal;
    private static MyLogger logger = null;
    /**                                                                                                                                                                              
     * returns toString method of MyLogger                                                                                                                                              
     * @return Prints description of the class                                                                                                                                       
     */
    public String toString(){
	return "This is the MyLogger class which contains a print method to print debug messages based on value";
    }

    /** Static method to set the loggerVal */
    public static void setLoggerVal(int val){
	loggerVal = val;
    }

    /**                                                                                                                                                                              
     * Private constructor                                                                                                                                                           
     */
    private MyLogger(){
    }
    /**                                                                                                                                                                              
     * Static method returns an instance of MyLogger class. Creates instance if none exists otherwise returns already existing one                                                      
     * @return instance of Debug                                                                                                                                                     
     */
    public static MyLogger getInstance(){
	if(logger == null){
	    logger = new MyLogger();
	}
	return logger;
    }

    /**
     * Prints debug message if the argument matches the logVal
    */
    public void printMessage(int num, String message){
	if(num == loggerVal){
	    System.out.println(message);
	}
    }
}
