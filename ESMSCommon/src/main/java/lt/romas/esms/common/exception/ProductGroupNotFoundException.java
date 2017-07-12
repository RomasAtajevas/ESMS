package lt.romas.esms.common.exception;

public class ProductGroupNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ProductGroupNotFoundException(String message) {
		super(message);
	}
}
