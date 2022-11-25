package com.diy.software.exceptions;

import java.io.IOException;

public class ChipFailureException extends IOException {
	private static final long serialVersionUID = 1544258083122134340L;

	public ChipFailureException() {}
	
	public ChipFailureException(String message) {
		super(message);
	}
}
