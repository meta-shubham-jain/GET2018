/**
 * This class will store employee details
 * 
 * @author Shubham Jain
 *
 */
public class Employee implements Comparable<Employee> {
	private int employeeId;
	private String name;
	private String address;

	Employee(int employeeId, String name, String address) {
		this.employeeId = employeeId;
		this.name = name;
		this.address = address;
	}

	/**
	 * It will returns Employee Id
	 * 
	 * @return
	 */
	public int getEmployeeId() {
		return employeeId;
	}

	/**
	 * It will returns employee name
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * It will returns adress of employee
	 * 
	 * @return
	 */
	public String getAddress() {
		return address;
	}

    @Override
    public int compareTo(Employee employee) {
        return employeeId - employee.getEmployeeId();
    }
}