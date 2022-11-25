package com.diy.software.exceptions;

import java.io.IOException;

public class IssuerHoldException extends IOException {
	private static final long serialVersionUID = -706684453379463161L;

	public IssuerHoldException() {}
	
	public IssuerHoldException(String message) {
		super(message);
	}
}
