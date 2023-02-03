package core;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.BeforeScenario;

public class Base {
	@BeforeScenario
	public void initialization() {
		Driver.init();
	}

	@AfterScenario
	public void cleanup() {
		Driver.tearDown();
	}
}
