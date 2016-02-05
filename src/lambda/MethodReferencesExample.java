package lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MethodReferencesExample {
	public void sort() {
		// Lambda
		final List<Integer> list = Arrays.asList(3, 1, 2);
		Collections.sort(list, (a, b) -> a.compareTo(b));

		// Same using a method reference (instance or static)
		Collections.sort(list, Integer::compareTo);
		Collections.sort(list, Integer::compare);
		
		// Class instance method reference
		Collections.sort(list, this::compare);

		// Class static method reference
		Collections.sort(list, MethodReferencesExample::compareStatic);
	}

	public int compare(Integer a, Integer b) {
		return a.compareTo(b);
	}

	public static int compareStatic(Integer a, Integer b) {
		return a.compareTo(b);
	}
}
