package taskManager.driver;

import taskManager.subject.Subject;
import taskManager.subject.DashBoardSubject;
import taskManager.observers.Observer;
import taskManager.observers.ProcessesTab;
import taskManager.observers.UsersTab;
import taskManager.observers.PerformanceTab;
import taskManager.observers.PerformanceTabFilterImpl;
import taskManager.observers.UsersTabFilterImpl;
import taskManager.observers.ProcessesTabFilterImpl;
import taskManager.filter.DashboardFilter;
import taskManager.logger.MyLogger;

public class Driver{
    public static void main(String[] args){
	Subject s = new DashBoardSubject();
	Observer processes = new ProcessesTab(args[1]);
	DashboardFilter processesFilter = new ProcessesTabFilterImpl();
	Observer users = new UsersTab(args[1]);
	DashboardFilter usersFilter = new UsersTabFilterImpl();
	Observer performance = new PerformanceTab(args[1]);
	DashboardFilter performanceFilter = new PerformanceTabFilterImpl();
	int loggerVal;
	try{
	    loggerVal = Integer.parseInt(args[2]);
	    MyLogger.setLoggerVal(loggerVal);
	}catch(NumberFormatException e){
	    System.err.println("Please provide valid a valid logger val argument");
	    System.err.println(e.getMessage());
	    System.exit(1);
	}
	MyLogger logger = MyLogger.getInstance();
	logger.printMessage(2,"New Observer Registered");
	s.registerObserver(processes, processesFilter);
	s.registerObserver(users, usersFilter);
	logger.printMessage(2,"New Observer Registered");
	s.registerObserver(performance, performanceFilter);
	logger.printMessage(2,"New Observer Registered");
	s.startProcessing(args[0], args[1]);
    }
}
