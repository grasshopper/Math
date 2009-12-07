package com.coolisland.client.controller;

import com.allen_sauer.gwt.log.client.Log;
import com.coolisland.client.GreetingService;
import com.coolisland.client.GreetingServiceAsync;
import com.coolisland.client.view.LoginView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Handler for the sendButton and nameField. This class is responsible for
 * handling the user logging in.
 * 
 * @author Silvio
 * 
 */
public class LoginController {
	/**
	 * Create a remote service proxy to talk to the server-side Greeting
	 * service.
	 */
	private final GreetingServiceAsync	greetingService	   = GWT.create(GreetingService.class);

	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String	       SERVER_ERROR	       = "An error occurred while "
	                                                               + "attempting to contact the server. Please check your network "
	                                                               + "connection and try again.";
	private boolean	                   initialized	       = false;
	private static String	           logDebugIndentation	= "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp";

	private LoginController() {
		Log.debug(logDebugIndentation + "Constructor MathController() starting");

		initialize();

		Log.debug(logDebugIndentation + "Constructor MathController() finished");
	}

	/**
	 * SingletonHolder is loaded on the first execution of
	 * LoginController.getInstance() or the first access to
	 * SingletonHolder.theLoginControllerSingletonInst, not before.
	 */
	private static class SingletonHolder {
		private static final LoginController	theLoginControllerSingletonInst	= new LoginController();
	}

	public static LoginController getInstance() {
		Log.debug(logDebugIndentation + "LoginController.getInstance()");

		return SingletonHolder.theLoginControllerSingletonInst;
	}

	/**
	 * Initializes the login
	 */
	public void initialize() {
		Log.debug(logDebugIndentation + this.getClass().getName() + " initialize() starting");

		if (initialized) {
			Log.debug(logDebugIndentation + this.getClass().getName()
			        + " initialize() we've already initialized");
			return;
		}

		LoginView.getInstance().initialize();
		initialized = true;

		Log.debug(logDebugIndentation + this.getClass().getName() + " initialize() finished");
	}

	/**
	 * Send the name from the nameField to the server and wait for a response.
	 */
	public void sendNameToServer(String loginName) {
		Log.debug(logDebugIndentation + this.getClass().getName() + " sendNameToServer() starting");

		// disable the send button from the login screen
		LoginView.getInstance().disableSend();

		/*
		 * submit the login name to the server and pop-up a screen indicating if
		 * we had success or failure logging in
		 */
		greetingService.greetServer(loginName, new AsyncCallback<String>() {
			/**
			 * onFailure will be called if the login sent to the server fails
			 */
			public void onFailure(Throwable caught) {
				Log.debug(logDebugIndentation + this.getClass().getName()
				        + " greetServer.onFailure() starting");

				LoginView.getInstance().displayLoginResponse(false, SERVER_ERROR);

				Log.debug(logDebugIndentation + this.getClass().getName()
				        + " greetServer.onFailure() finished");
			}

			/**
			 * onSuccess will be called if the login sent to the server succeeds
			 * 
			 * @param result
			 */
			public void onSuccess(String result) {
				Log.debug(logDebugIndentation + this.getClass().getName()
				        + " greetServer.onSuccess() starting");

				LoginView.getInstance().displayLoginResponse(true, result);

				// startup the math application
				MathController.getInstance().initialize();

				Log.debug(logDebugIndentation + this.getClass().getName()
				        + " greetServer.onSuccess() finished");
			}
		});

		Log.debug(logDebugIndentation + this.getClass().getName() + " sendNameToServer() finished");
	}

}
