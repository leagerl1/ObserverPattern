package taskManager.filter;

public interface DashboardFilter{

	/** 
		* checks if filter type is same as given argument
		* @return true/false depending if type matches
		* @param filterType type to check
	*/
    public boolean check(String filterType);
}
