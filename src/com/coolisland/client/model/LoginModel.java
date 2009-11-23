package com.coolisland.client.model;

import com.allen_sauer.gwt.log.client.Log;

public class LoginModel {
	final String	loginName	= null;

	private LoginModel() {
		Log.debug("Constructor LoginModel() starting");

		initialize();

		Log.debug("Constructor LoginModel() finished");
	}

	/**
	 * SingletonHolder is loaded on the first execution of
	 * LoginModel.getInstance() or the first access to
	 * SingletonHolder.theLoginModelSingletonInst, not before.
	 */
	private static class SingletonHolder {
		private static final LoginModel	theLoginModelSingletonInst	= new LoginModel();
	}

	public static LoginModel getInstance() {
		Log.debug("LoginModel.getInstance() starting");

		return SingletonHolder.theLoginModelSingletonInst;
	}

	/**
	 * Initializes the login model
	 */
	private void initialize() {
	}

	/**
	 * 
	 * @return
	 */
	public String getLoginName() {
		return loginName;
	}

}
