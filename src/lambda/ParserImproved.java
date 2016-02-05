package lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@FunctionalInterface													// <-- Note still a functional interface
public interface ParserImproved {
	/**
	 * One abstract method.
	 */
	void parse(String line);

	/**
	 * @return Whether to skip first line of the file
	 */
	default boolean skipFirstLine() {									// <-- Default implementation, mainly for library authors
		return true;
	}

	/**
	 * Parses the given file line-by-line.
	 * @param path
	 * @param parser
	 */
	static void executeAround(String path, ParserImproved parser) {							// <-- Static interface method, handy for factories, helpers, utilities, etc
		try(final BufferedReader in = new BufferedReader(new FileReader(path))) {
			if(parser.skipFirstLine()) in.readLine();
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
}
