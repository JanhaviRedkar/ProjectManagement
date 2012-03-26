package dk.softwarehuset.projectmanagement.util;

import org.junit.Before;

import dk.softwarehuset.projectmanagement.app.Application;
import dk.softwarehuset.projectmanagement.app.Employee;
import dk.softwarehuset.projectmanagement.app.NonUniqueIdentifierException;
import dk.softwarehuset.projectmanagement.app.PermissionDeniedException;
import dk.softwarehuset.projectmanagement.app.WrongCredentialsException;

public class SampleDataSetup {
	protected Application app = new Application();
	
	@Before
	public void setup() throws WrongCredentialsException, PermissionDeniedException, NonUniqueIdentifierException {
		// Sign in as administrator
		app.SignIn("zzzz");
		
		// Add employees
		Employee employee1 = new Employee("ABCD", "Alpha Bravo Charlie Delta");
		Employee employee2 = new Employee("EFGH", "Echo Foxtrot Golf Hotel");
		Employee employee3 = new Employee("IJKL", "India Juliet Kilo Lima");
		app.addEmployee(employee1);
		app.addEmployee(employee2);
		app.addEmployee(employee3);
		
		// Sign out
		app.SignOut();
	}
}