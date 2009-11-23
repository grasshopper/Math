package com.coolisland.client.view;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.Widget;

public abstract class PanelViewAbstract extends Widget implements PanelViewInterface {
	protected DockPanel	theDockPanel;

	public PanelViewAbstract() {
		theDockPanel = null;
	}

	/**
	 * @return the dock panel
	 */
	public Widget getWidget() {
		Log.debug(this.getClass().getName() + ".getWidget()");
		this.printDebugInfo();

		return theDockPanel;
	}

	/**
	 * clears all the contents from the panel
	 */
	// protected void reset() {
	// theDockPanel = null;
	// }
}
