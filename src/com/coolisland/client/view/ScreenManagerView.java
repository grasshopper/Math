package com.coolisland.client.view;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class ScreenManagerView extends PanelViewAbstract {
	private DockPanel	  theDockPanel	        = null;
	private VerticalPanel	verticalPanel	    = null;
	private static String	logDebugIndentation	= "";
	private boolean	      initialized	        = false;

	// final private static WorkspacePanel theWorkspacePanel = new
	// WorkspacePanel();

	private ScreenManagerView() {
		super();

		Log.debug(logDebugIndentation + "Constructor ScreenManagerView() starting");

		// initialize the DockPanel
		initialize();

		Log.debug(logDebugIndentation + "Constructor ScreenManagerView() finished");
	}

	/**
	 * SingletonHolder is loaded on the first execution of
	 * ScreenManagerView.getInstance()
	 */
	private static class SingletonHolder {
		private static final ScreenManagerView	theScreenManagerViewSingletonInst	= new ScreenManagerView();
	}

	public static ScreenManagerView getInstance() {
		Log.debug(logDebugIndentation + "ScreenManagerView.getInstance()");

		return SingletonHolder.theScreenManagerViewSingletonInst;
	}

	/**
	 * Initialize all the panels
	 */
	private void initialize() {
		// if we have already initialized, just return
		if (initialized) {
			Log.debug(logDebugIndentation + this.getClass().getName()
			        + ".initialize() no need to initialize");
			return;
		}

		Log.debug(logDebugIndentation + this.getClass().getName() + ".initialize() starting");

		// set flag to indicate that we have already initialized
		initialized = true;

		Log.debug(logDebugIndentation + this.getClass().getName() + ".initialize() finished");
	}

	/**
	 * Returns the workspace panel
	 * 
	 * @return workspace panel
	 */
	// public Widget getWorkSpace() {
	// Log.debug(this.getClass().getName() + ".getWorkSpace()");
	//
	// return theWorkspacePanel;
	// }

	// /**
	// * Adds a link to the navigation panel
	// *
	// * @param linkLabel
	// */
	// public void addLinkToNavigationPanel(String linkLabel) {
	// theNavigationModel.addLink(linkLabel);
	// }

	// /**
	// * resets the content of the navigation panel
	// */
	// public void resetNavigationPanel() {
	// theNavigationPanel.reset();
	// }

	/**
	 * resets the content of the workspace panel
	 */
	// public void resetWorkspacePanel() {
	// Log.debug(this.getClass().getName() + ".resetWorkspacePanel() starting");
	//
	// theWorkspacePanel.reset();
	//
	// Log.debug(this.getClass().getName() + ".resetWorkspacePanel() finished");
	// }

	/**
	 * Adds a link to the navigation panel
	 * 
	 * @param linkLabel
	 */
	// public void addContentToWorkspacePanel(String content) {
	// Log.debug(this.getClass().getName() +
	// ".addContentToWorkspacePanel() starting");
	//
	// theWorkspacePanel.addContent(content);
	//
	// Log.debug(this.getClass().getName() +
	// ".addContentToWorkspacePanel() finished");
	// }

	/**
	 * Returns the Navigation Panel
	 * 
	 * @return navigation panel
	 */
	@Override
	public Widget getWidget() {
		Log.debug(logDebugIndentation + this.getClass().getName() + ".getWidget()");

		// return dock;
		return verticalPanel;
	}

	@Override
	public void draw() {
		Log.debug(logDebugIndentation + this.getClass().getName() + ".draw() starting");

		theDockPanel = new DockPanel();

		verticalPanel = new VerticalPanel();

		if (theDockPanel != null) {
			// Allow 4 pixels of spacing between each cell
			theDockPanel.setSpacing(5);
			theDockPanel.setWidth("100%");

			/*
			 * Center each component horizontally within each cell for each
			 * component added after this call. A shortcut to calling
			 * theDockPanel.setCellHorizontalAlignment() for each cell.
			 */
			theDockPanel.setHorizontalAlignment(DockPanel.ALIGN_CENTER);

			// create the title panel
			// TitlePanel title = new TitlePanel();
			// theDockPanel.add(title.getWidget(), DockPanel.NORTH);

			// create the copyright panel
			// CopyRightPanel copyrightPanel = new CopyRightPanel();
			// theDockPanel.add(copyrightPanel.getWidget(), DockPanel.SOUTH);

			Log.debug(this.getClass().getName() + ".draw() adding NavigationPanel to dockpanel");
			theDockPanel.add(NavigationPanel.getInstance().getWidget(), DockPanel.WEST);

			// create the header panel
			// HeaderPanel headerPanel = new HeaderPanel();
			// theDockPanel.add(headerPanel.getWidget(), DockPanel.NORTH);

			// create the footer panel
			// FooterPanel footerPanel = new FooterPanel();
			// theDockPanel.add(footerPanel.getWidget(), DockPanel.SOUTH);

			// Add a workspace panel in the center
			// theDockPanel.add(theWorkspacePanel.getWidget(),
			// DockPanel.CENTER);

			// add all the vertical panels to a vertical panel
			verticalPanel.add(theDockPanel);
		} else {
			System.out.println("Unable to create dock panels");
			throw new NullPointerException("Unable to initialize the dock panel");
		}

		Log.debug(logDebugIndentation + this.getClass().getName() + ".draw() finished");
	}

	@Override
	public void printDebugInfo() {
		Log.debug(logDebugIndentation + this.getClass().getName() + ".printDebugInfo() starting");

		Log.debug(logDebugIndentation + this.getClass().getName() + ".printDebugInfo() finished");
	}

	@Override
	public void reset() {
		Log.debug(logDebugIndentation + this.getClass().getName() + ".reset() starting");

		Log.debug(logDebugIndentation + this.getClass().getName() + ".reset() finished");
	}

}
