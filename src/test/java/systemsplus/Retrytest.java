package systemsplus;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retrytest implements IRetryAnalyzer {
	private int count = 0;
	private final int maxrty = 3;

	@Override
	public boolean retry(ITestResult result) {

		if (count < maxrty) {
			count++;
			return true;
		}

		return false;
	}

}
