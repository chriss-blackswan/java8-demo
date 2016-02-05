package stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionExample {
	/**
	 * Retrieves invoices for the given MSISDN.
	 * @param invoices <-- would come from a service or DAO or something
	 * @param msisdn
	 * @param limit
	 * @return
	 */
	public List<InvoiceResponse> getInvoices(List<Invoice> invoices, String msisdn, int limit) {
		final List<InvoiceResponse> responses = new ArrayList<>();
		for(Invoice invoice : invoices) {
			// Omit non-newco invoices
			if(!invoice.isNewco()) {														// <-- logic
				continue;
			}
			
			// Omit invoices for others
			if(!invoice.getMsisdn().equals(msisdn)) {										// <-- logic
				continue;
			}
			
			// Convert to DTO
			final InvoiceResponse res = new InvoiceResponse(invoice.getId());				// <-- logic
			responses.add(res);
			
			// Limit number of responses
			if(responses.size() >= limit) {													// <-- logic
				break;
			}
		}
		
		// Sort by value
		Collections.sort(responses, new Comparator<InvoiceResponse>() {						// <-- logic
			@Override
			public int compare(InvoiceResponse a, InvoiceResponse b) {
				return a.getValue().compareTo(b.getValue());								// <-- logic
			}
		});
		
		return responses;
	}
}
