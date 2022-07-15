package br.com.connemat.sysmat.exception;

public class SysmatEntityException extends RuntimeException {

	private static final long serialVersionUID = -525183630613341745L;

	public SysmatEntityException() {
	}

	public SysmatEntityException(String message) {
		super(message);
	}

	public SysmatEntityException(Throwable cause) {
		super(cause);
	}

	public SysmatEntityException(String message, Throwable cause) {
		super(message, cause);
	}

	public SysmatEntityException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
