package taskManager.observers;

import taskManager.filter.DashboardFilter;

public class ProcessesTabFilterImpl implements DashboardFilter{
    
	/**  
	 * returns class descriptions
	 * @return description of the processes filter class 
	 */
	public String toString(){
		return "This is the Processes Tab filter implementation class";
	}

	/**  
	 * returns whether filter is of the processes type
	 * @param type type of filter to test
	 * @return bool representing whether it is of type processes 
	*/
    public boolean check(String type){
	return type.equals("Processes");
    }
}
