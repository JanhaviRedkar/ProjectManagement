package dk.softwarehuset.projectmanagement.app;

import static org.junit.Assert.*;

import org.junit.Test;

import dk.softwarehuset.projectmanagement.util.SampleDataSetup;

public class TestCreateProject extends SampleDataSetup {
	@Test
	public void testCreateProject() throws WrongCredentialsException {
		// Check no projects exist
		assertEquals(0, app.getProjects().size());
		
		// Check nobody is signed in
		assertNull(app.getCurrentEmployee());
		
		// Sign in as employee
		app.SignIn("ABCD");
		
  	// Check employee is signed in and not admin
		assertNotNull(app.getCurrentEmployee());
		assertEquals(app.getCurrentEmployee().getId(), "ABCD");
		assertEquals(app.getCurrentEmployee().getName(), "Alpha Bravo Charlie Delta");
		assertFalse(app.getCurrentEmployee().isAdmin());
				
		// Add new project
		String name = "Hello World"; 
		Project project = new Project(name);
		app.addProject(project);
		
		// Check project exists
		assertEquals(1, app.getProjects().size());
		assertEquals(project, app.getProjects().get("120001"));
		
		// Sign out
		app.SignOut();
		
		// Check nobody is signed in
		assertNull(app.getCurrentEmployee());
	}
}