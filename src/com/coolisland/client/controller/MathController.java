package com.coolisland.client.controller;

import com.allen_sauer.gwt.log.client.Log;
import com.coolisland.client.model.MathModel;
import com.coolisland.client.utils.HtmlUtils;
import com.coolisland.client.view.ScreenManagerView;
import com.google.gwt.user.client.ui.RootPanel;

public class MathController {
	private boolean	initialized	= false;

	private MathController() {
		Log.setCurrentLogLevel(Log.LOG_LEVEL_DEBUG);
		Log.debug("Constructor MathController() starting");

		initialize();

		Log.debug("Constructor MathController() finished");
	}

	/**
	 * SingletonHolder is loaded on the first execution of
	 * MathController.getInstance() or the first access to
	 * SingletonHolder.theKidMathControllerSingletonInst, not before.
	 */
	private static class SingletonHolder {
		private static final MathController	theKidMathControllerSingletonInst	= new MathController();
	}

	public static MathController getInstance() {
		Log.debug("MathController.getInstance() starting");

		return SingletonHolder.theKidMathControllerSingletonInst;
	}

	/**
	 * initializes all the panel views, models, and controllers
	 */
	public void initialize() {
		// if we have already initialized the model, just return
		if (initialized) {
			Log.debug(this.getClass().getName() + ".initialize() no need to initialize");
			return;
		}

		Log.debug(this.getClass().getName() + ".initialize() starting");

		/*
		 * initialize the general model
		 */
		Log.debug(this.getClass().getName() + ".initialize() initializing KidMathModel");
		MathModel.getInstance().initialize();

		/*
		 * initialize the navigation panel
		 */

		/*
		 * initialize the specific models
		 */

		/*
		 * initialize the specific controllers
		 */
		Log.debug(this.getClass().getName() + ".initialize() initializing NavigationController");
		NavigationController.getInstance().initialize();

		// /*
		// * initialize the specific panels
		// */
		// Log.debug(this.getClass().getName() +
		// ".initialize() initializing NavigationPanel");
		// NavigationPanel.getInstance().initialize();

		// Log.debug(this.getClass().getName() +
		// ".initialize() initializing AdsPanel");
		// AdsPanel.getInstance().initialize();

		/*
		 * draw the specific panels
		 */
		ScreenManagerView.getInstance().draw();

		/*
		 * redraw the screen
		 */
		RootPanel rootPanel = RootPanel.get();

		Log.debug(this.getClass().getName() + "Title: " + rootPanel.getTitle());
		Log.debug(this.getClass().getName() + "Number of widgets in root panel: "
		        + rootPanel.getWidgetCount());

		// rootPanel.clear();
		Log.debug(this.getClass().getName() + "Root Panel visible: " + rootPanel.isVisible());

		rootPanel.setTitle("MATH WEB APPLICATION");

		rootPanel.add(ScreenManagerView.getInstance().getWidget());

		Log.debug(this.getClass().getName() + "Number of widgets in root panel: "
		        + rootPanel.getWidgetCount());

		HtmlUtils utils = new HtmlUtils();
		Log.debug(this.getClass().getName() + "Root panel contents: ");
		utils.printElement(RootPanel.getBodyElement());

		// set flag to indicate that we have already initialized the model
		initialized = true;

		Log.debug(this.getClass().getName() + ".initialize() finished");
	}

	/**
	 * resets the panel views and models
	 */
	public void reset() {
		Log.debug(this.getClass().getName() + ".reset() starting");

		initialize();

		Log.debug(this.getClass().getName() + ".reset() finished");
	}

	public void printDebugInfo() {
		Log.debug(this.getClass().getName() + ".printDebugInfo() starting");

		// NavigationModel.getInstance().printDebugInfo();
		// NavigationPanel.getInstance().printDebugInfo();
		// AdsPanel.getInstance().printDebugInfo();

		Log.debug(this.getClass().getName() + ".printDebugInfo() finished");
	}
}
