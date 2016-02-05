package lambda;

@FunctionalInterface
public interface Parser {
	/**
	 * One abstract method --> functional interface.
	 */
	void parse(String line);
	
//	// Another method
//	void anotherMethod();
}
