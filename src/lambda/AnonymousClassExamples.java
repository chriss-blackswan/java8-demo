package lambda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JButton;

public class AnonymousClassExamples {
	private final JButton button = new JButton();
	private final List<Integer> list = Arrays.asList(6, 1, 3, 2, 5, 4);

	/**
	 * SWING event handler.
	 */
	public void eventHandler() {
		button.addActionListener(new ActionListener() {				// <-- business logic
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand());			// <-- business logic
			}
		});
	}

	/**
	 * Sorting with comparator.
	 */
	public void sort() {
		final Comparator<Integer> comparator = new Comparator<Integer>() {			
			@Override
			public int compare(Integer a, Integer b) {
				return a.compareTo(b);								// <-- business logic
			}
		};
		Collections.sort(list, comparator);							// <-- business logic
	}
	
	/**
	 * Execute-around.
	 */
	public void executeAround() throws FileNotFoundException, IOException {
		ParserUtil.executeAround("SomeFile.txt", new Parser() {			// <-- business logic
			@Override
			public void parse(String line) {
				System.out.println(line);							// <-- business logic
			}
		});
	}
}
