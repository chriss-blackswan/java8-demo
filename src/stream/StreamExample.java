package stream;

import static java.util.stream.Collectors.toList;

import java.util.List;

public class StreamExample {
	/**
	 * Retrieves invoices for the given MSISDN.
	 * @param invoices
	 * @param msisdn
	 * @param limit
	 * @return
	 */
	public List<InvoiceResponse> getInvoices(List<Invoice> invoices, String msisdn, int limit) {
		return invoices.stream()												// Stream source
			.filter(invoice -> invoice.isNewco())								// Apply a predicate filter
			.filter(inv -> inv.getMsisdn().equals(msisdn))						// Another filter
			.map(invoice -> new InvoiceResponse(invoice.getId()))				// Convert to another object
			.limit(limit)														// Limit number of responses
			.sorted((a, b) -> a.getValue().compareTo(b.getValue()))				// Sort by value
			.collect(toList());													// Terminal operation
	}
}
