package dk.softwarehuset.projectmanagement.ui;

import java.io.PrintWriter;

public class StartScreen extends MenuListScreen {
	private static String[] OPTIONS = new String[] {
		"Exit",
		"Sign In"
	};

	public StartScreen(ApplicationUI appUI) {
		super(appUI, OPTIONS);
	}

	@Override
	public boolean optionSelected(String option, PrintWriter out) {
		if (option.equals("Exit")) {
			out.println("Exited.");
			return true;
		} else if (option.equals("Sign In")) {
			appUI.setScreen(new SignInScreen(appUI));
		}

		return false;
	}
}