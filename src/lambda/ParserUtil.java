package lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public final class ParserUtil {
	/**
	 * Parses the given file line-by-line.
	 * @param path
	 * @param parser
	 */
	public static void executeAround(String path, Parser parser) {
		try(final BufferedReader in = new BufferedReader(new FileReader(path))) {
			while(true) {
				final String line = in.readLine();
				if(line == null) break;
				parser.parse(line);
			}
		}
		catch(IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private ParserUtil() {
		// Utility class
	}
}
