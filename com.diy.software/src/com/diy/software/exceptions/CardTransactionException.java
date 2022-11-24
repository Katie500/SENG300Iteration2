package com.diy.software.exceptions;

import java.io.IOException;

public class CardTransactionException extends IOException {
	private static final long serialVersionUID = 7439528679518923725L;

	public CardTransactionException() {}
	
	public CardTransactionException(String message) {
		super(message);
	}
}
