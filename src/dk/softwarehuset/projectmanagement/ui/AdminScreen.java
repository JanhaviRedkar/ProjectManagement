package dk.softwarehuset.projectmanagement.ui;

import java.io.PrintWriter;

public class AdminScreen extends MenuListScreen {
	private static String[] OPTIONS = new String[] {
		"Sign Out",
		"Create Employee"
	};

	public AdminScreen(ApplicationUI appUI) {
		super(appUI, OPTIONS);
	}

	@Override
	public boolean optionSelected(String option, PrintWriter out) {
		if (option.equals("Sign Out")) {
			appUI.getApplication().SignOut();
			out.println("You signed out.");
			appUI.setScreen(new StartScreen(appUI));
		} else if (option.equals("Create Employee")) {
			appUI.setScreen(new CreateEmployeeIdScreen(appUI));
		}

		return false;
	}
}