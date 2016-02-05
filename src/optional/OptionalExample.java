package optional;

import java.util.Optional;

public class OptionalExample {
	class Subscription {
		public String getName() {
			return "name";
		}
		
		public boolean isSuspended() {
			return false;
		}
	}
	
	/**
	 * @return Subscription that could be NULL?
	 */
	private Subscription daoGetSubscription(String id) {
		return new Subscription();
	}

	/**
	 * Controller with NULL handling.
	 */
	public String controllerGetSubscriptionNameWithNullChecking(String id) {
		final Subscription sub = daoGetSubscription(id);
		if((sub == null) || sub.isSuspended()) {
			return "Unknown subscription";
		}
		else {
			return sub.getName();
		}
	}

	/**
	 * @return Explicitly documents and enforces an optional value
	 */
	private Optional<Subscription> serviceGetSubscription(String id) {
		return Optional.ofNullable(daoGetSubscription(id));
	}

	/**
	 * Declarative approach using optional.
	 */
	public String controllerGetSubscriptionNameUsingOptional(String id) {
		return serviceGetSubscription(id)
			.filter(Subscription::isSuspended)
			.map(Subscription::getName)
			.orElse("Unknown subscription");
	}
}
