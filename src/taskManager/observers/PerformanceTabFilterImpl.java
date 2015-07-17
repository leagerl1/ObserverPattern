package taskManager.observers;

import taskManager.filter.DashboardFilter;

public class PerformanceTabFilterImpl implements DashboardFilter{
   	
	/**  
	 * returns class descriptions
	 * @return description of the performance filter class 
	 */
	public String toString(){
		return "This is the Performance Tab filter implementation class";
	}

	/**  
	 * returns whether filter is of the performance type
	 * @param type type of filter to test
	 * @return bool representing whether it is of type performance 
	*/
    public boolean check(String type){
	return type.equals("Performance");
    }
}
