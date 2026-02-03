package domain.model;

public class Payment {

	private final String id;
	private PaymentStatus status;
	
	public Payment(
			final String id) {
		this.id = id;
		this.status = PaymentStatus.PENDING;
	}
	
	public void approved() {
		this.status = PaymentStatus.APPROVED;
	}
	
	public void reject() {
		this.status = PaymentStatus.REJECTED;
	}
	
	public PaymentStatus getStatus() {
		return status;
	}
	
	public String getId() {
		return id;
	}
	
}
