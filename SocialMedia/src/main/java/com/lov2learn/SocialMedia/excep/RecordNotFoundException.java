package com.lov2learn.SocialMedia.excep;

public class RecordNotFoundException extends RuntimeException {

	public RecordNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public RecordNotFoundException(String message) {
		super(message);
	}


   
}
