package com.coolisland.client.controller;

import com.allen_sauer.gwt.log.client.Log;
import com.coolisland.client.model.NavigationModel;
import com.coolisland.client.view.NavigationPanel;

public class NavigationController {
	private static String	logDebugIndentation	= "&nbsp&nbsp&nbsp&nbsp&nbsp";
	private boolean	      initialized	        = false;

	private NavigationController() {
		Log.debug(logDebugIndentation + "Constructor NavigationController() starting");

		initialize();

		Log.debug(logDebugIndentation + "Constructor NavigationController() finished");
	}

	/**
	 * SingletonHolder is loaded on the first execution of
	 * NavigationController.getInstance() or the first access to
	 * SingletonHolder.theNavigationControllerSingletonInst, not before.
	 */
	private static class SingletonHolder {
		private static final NavigationController	theNavigationControllerSingletonInst	= new NavigationController();
	}

	public static NavigationController getInstance() {
		Log.debug(logDebugIndentation + "NavigationController.getInstance()");

		return SingletonHolder.theNavigationControllerSingletonInst;
	}

	/**
	 * initializes the navigation panel view and model
	 */
	public void initialize() {
		// if we have already initialized the controller, just return
		if (initialized) {
			Log.debug(logDebugIndentation + this.getClass().getName()
			        + ".initialize() no need to initialize");
			return;
		}

		Log.debug(logDebugIndentation + this.getClass().getName() + ".initialize() starting");

		/*
		 * build the navigation links...
		 */
		for (int i = 1; i < 10; i++) {
			String linkLabel = "Link " + i;
			NavigationModel.getInstance().addLink(linkLabel);
		}

		/*
		 * initialize the view
		 */
		NavigationPanel.getInstance().initialize();

		// set flag to indicate that we have already initialized
		initialized = true;

		Log.debug(logDebugIndentation + this.getClass().getName() + ".initialize() finished");
	}

	/**
	 * resets the navigation panel view and model
	 */
	public void reset() {
		Log.debug(logDebugIndentation + this.getClass().getName() + ".reset() starting");

		Log.debug(logDebugIndentation + this.getClass().getName() + ".reset()");

		NavigationModel.getInstance().reset();
		NavigationPanel.getInstance().reset();
		initialize();

		Log.debug(logDebugIndentation + this.getClass().getName() + ".reset() finished");
	}

	public void printDebugInfo() {
		Log.debug(logDebugIndentation + this.getClass().getName() + ".printDebugInfo() starting");

		NavigationModel.getInstance().printDebugInfo();
		NavigationPanel.getInstance().printDebugInfo();

		Log.debug(logDebugIndentation + this.getClass().getName() + ".printDebugInfo() finished");
	}

}
