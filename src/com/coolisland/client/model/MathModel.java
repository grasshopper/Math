package com.coolisland.client.model;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.ui.HTML;

/**
 * @author Silvio Nunes
 */
public class MathModel {
	private HTML	      adsHtml	            = null;
	private boolean	      initialized	        = false;
	private static String	logDebugIndentation	= "&nbsp&nbsp&nbsp";

	/**
	 * Private constructor prevents instantiation from other classes
	 */
	private MathModel() {
		Log.setCurrentLogLevel(Log.LOG_LEVEL_DEBUG);
		Log.debug(logDebugIndentation + "Constructor KidMathModel() starting");

		initialize();

		Log.debug(logDebugIndentation + "Constructor KidMathModel() finished");
	}

	/**
	 * initialize the object
	 */
	public void initialize() {
		// if we have already initialized the model, just return
		if (initialized) {
			Log.debug(logDebugIndentation + this.getClass().getName()
			        + ".initialize() no need to initialize");
			return;
		}

		Log.debug(logDebugIndentation + this.getClass().getName() + ".initialize() starting");

		/*
		 * Initialize the data for the Ads
		 */
		adsHtml = new HTML("Advertisements go here");

		/*
		 * Initialize the data for the Title
		 */

		// set flag to indicate that we have already initialized the model
		initialized = true;

		Log.debug(logDebugIndentation + this.getClass().getName() + ".initialize() finished");
	}

	/**
	 * SingletonHolder is loaded on the first execution of
	 * KidMathModel.getInstance() or the first access to
	 * SingletonHolder.theKidMathModelSingletonInst, not before.
	 */
	private static class SingletonHolder {
		private static final MathModel	theKidMathModelSingletonInst	= new MathModel();
	}

	public static MathModel getInstance() {
		Log.debug(logDebugIndentation + "KidMathModel.getInstance() starting");

		return SingletonHolder.theKidMathModelSingletonInst;
	}

	public void reset() {
		Log.debug(logDebugIndentation + this.getClass().getName() + ".reset() starting");

		Log.debug(logDebugIndentation + this.getClass().getName() + ".reset() finished");
	}

	public void printDebugInfo() {
		Log.debug(logDebugIndentation + this.getClass().getName() + ".printDebugInfo() starting");

		Log.debug(logDebugIndentation + "Ads Panel data: " + this.adsHtml);

		Log.debug(logDebugIndentation + this.getClass().getName() + ".printDebugInfo() finished");
	}

	public HTML getAdsData() {
		Log.debug(logDebugIndentation + this.getClass().getName() + ".getAdsData()");

		return adsHtml;
	}
}
