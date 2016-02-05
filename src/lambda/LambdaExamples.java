package lambda;

import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;

public class LambdaExamples {
	private final JButton button = new JButton();
	private final List<Integer> list = Arrays.asList(6, 1, 3, 2, 5, 4);

	/**
	 * SWING event handler.
	 */
	public void eventHandler() {
		button.addActionListener((ActionEvent e) -> System.out.println(e.getActionCommand()));
	}

	/**
	 * Sorting with comparator.
	 */
	public void sort() {
		Collections.sort(list, (Integer a, Integer b) -> a.compareTo(b));
	}
	
	/**
	 * Execute-around.
	 */
	public void executeAround() throws FileNotFoundException, IOException {
		ParserUtil.executeAround("SomeFile.txt", line -> System.out.println(line));
	}
}
