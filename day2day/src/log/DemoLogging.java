package log;

import org.apache.log4j.Logger;

public class DemoLogging {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Logger l = Logger.getLogger(DemoLogging.class);

		// Priority Order : tdiwef
		// trace;
		// debug;
		// info;
		// warn;
		// error;
		// fatal;

		if (l.isDebugEnabled()) {
			l.info("this is Debug message");
		}

		if (l.isInfoEnabled()) {
			l.info("this is info message");

		}

	}
}
