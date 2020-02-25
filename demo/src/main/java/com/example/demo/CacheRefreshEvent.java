package com.example.demo;

import org.springframework.context.ApplicationEvent;

public class CacheRefreshEvent extends ApplicationEvent {
	private String message;

	private static final long serialVersionUID = 1L;

	public CacheRefreshEvent(Object source, String message) {
		super(source);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}