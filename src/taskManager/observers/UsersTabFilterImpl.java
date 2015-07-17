package taskManager.observers;

import taskManager.filter.DashboardFilter;

public class UsersTabFilterImpl implements DashboardFilter{

	/**  
	 * returns class descriptions
	 * @return description of the users filter class 
	 */
	public String toString(){
		return "This is the Users Tab filter implementation class";
	}

	/**  
	 * returns whether filter is of the users type
	 * @param type type of filter to test
	 * @return bool representing whether it is of type users 
	*/
    public boolean check(String type){
	return type.equals("Users");
    }
}
