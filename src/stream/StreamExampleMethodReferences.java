package stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.function.Predicate;

public class StreamExampleMethodReferences {
	/**
	 * Retrieves invoices for the given MSISDN.
	 * @param invoices
	 * @param msisdn
	 * @param limit
	 * @return
	 */
	public List<InvoiceResponse> getInvoicesUsingMethodReferences(List<Invoice> invoices, String msisdn, int limit) {
		// Built-in functional interface used by filter()
		final Predicate<Invoice> matcher = inv -> inv.getId().equals(msisdn);

		return invoices.stream()
			.filter(Invoice::isNewco)
			.filter(matcher)
			.map(Invoice::getId)
			.map(InvoiceResponse::new)			// <-- (Slightly contrived) use of a constructor reference
			.limit(limit)
			.sorted(comparing(InvoiceResponse::getValue))
			.collect(toList());
	}
}
