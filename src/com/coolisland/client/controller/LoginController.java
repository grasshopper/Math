package com.coolisland.client.controller;

import com.allen_sauer.gwt.log.client.Log;
import com.coolisland.client.view.LoginView;

/**
 * Handler for the sendButton and nameField. This class is responsible for
 * handling the user logging in.
 * 
 * @author Silvio
 * 
 */
public class LoginController {

	private LoginController() {
		Log.debug("Constructor MathController() starting");

		initialize();

		Log.debug("Constructor MathController() finished");
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
		Log.debug("LoginController.getInstance() starting");

		return SingletonHolder.theLoginControllerSingletonInst;
	}

	/**
	 * Initializes the login
	 */
	public void initialize() {
		LoginView.getInstance().initialize();
	}
}
