/**
 * 
 */
package com.example.venu.springlearning.helloworld;

/**
 * @author venugopal
 *
 */
public class HelloWorldBean {

	private String message;

	

	/**
	 * @param message
	 */
	public HelloWorldBean(String message) {
		super();
		this.message = message;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
}
