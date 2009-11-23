/**
 * 
 */
package com.coolisland.client.model;

import java.util.ArrayList;
import java.util.List;

import com.allen_sauer.gwt.log.client.Log;

/**
 * @author Silvio Nunes
 */
public class NavigationModel {
	private List<String>	theNavigationLinks	= null;
	private static String	logDebugIndentation	= "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp";
	private boolean	      initialized	        = false;

	/**
	 * Private constructor prevents instantiation from other classes
	 */
	private NavigationModel() {
		Log.debug(logDebugIndentation + this.getClass().getName()
		        + ".Constructor NavigationModel() starting");

		initialize();

		Log.debug(logDebugIndentation + this.getClass().getName()
		        + ".Constructor NavigationModel() finished");
	}

	/**
	 * SingletonHolder is loaded on the first execution of
	 * NavigationModel.getInstance() or the first access to
	 * SingletonHolder.theNavigationModelSingletonInst, not before.
	 */
	private static class SingletonHolder {
		private static final NavigationModel	theNavigationModelSingletonInst	= new NavigationModel();
	}

	public static NavigationModel getInstance() {
		Log.debug(logDebugIndentation + "NavigationModel.getInstance()");

		return SingletonHolder.theNavigationModelSingletonInst;
	}

	/**
	 * initialize the object
	 */
	private void initialize() {
		// if we have already initialized the controller, just return
		if (initialized) {
			Log.debug(logDebugIndentation + this.getClass().getName()
			        + ".initialize() no need to initialize");
			return;
		}

		Log.debug(logDebugIndentation + this.getClass().getName() + ".initialize() starting");

		theNavigationLinks = new ArrayList<String>();

		// set flag to indicate that we have already initialized
		initialized = true;

		Log.debug(logDebugIndentation + this.getClass().getName() + ".initialize() finished");
	}

	/**
	 * add a link to the navigation model
	 */
	public void addLink(String linkLabel) {
		Log.debug(logDebugIndentation + this.getClass().getName() + ".addLink() starting");

		if (linkLabel == null) {
			return;
		}

		Log.debug(logDebugIndentation + this.getClass().getName() + ".addLink() linkLabel:"
		        + linkLabel);

		/*
		 * initialize the navigation links if needed
		 */
		if (theNavigationLinks == null) {
			theNavigationLinks = new ArrayList<String>();
		}

		/*
		 * add the new link to the navigation link list and redraw the
		 * navigation menu
		 */
		theNavigationLinks.add(linkLabel);

		Log.debug(logDebugIndentation + this.getClass().getName() + ".addLink() finished");
	}

	public void reset() {
		Log.debug(logDebugIndentation + this.getClass().getName() + ".reset() starting");

		theNavigationLinks = null;

		Log.debug(logDebugIndentation + this.getClass().getName() + ".reset() finished");
	}

	public List<String> getNavigationLinks() {
		Log.debug(logDebugIndentation + this.getClass().getName()
		        + ".getNavigationLinks() starting");

		return theNavigationLinks;
	}

	public void printDebugInfo() {
		Log.debug(logDebugIndentation + this.getClass().getName() + ".printDebugInfo() starting");

		if (theNavigationLinks != null) {
			Log.debug(logDebugIndentation + "Number of navigation links:  "
			        + theNavigationLinks.size());

			int numLinks = theNavigationLinks.size();
			for (int i = 0; i < numLinks; i++) {
				Log.debug(logDebugIndentation + "Link[" + i + "]: " + theNavigationLinks.get(i));
			}
		}

		Log.debug(logDebugIndentation + this.getClass().getName() + ".printDebugInfo() finished");
	}

}
