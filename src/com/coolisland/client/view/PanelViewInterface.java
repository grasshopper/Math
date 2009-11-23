package com.coolisland.client.view;

public interface PanelViewInterface {
	/*
	 * draw the panel
	 */
	public void draw();

	/**
	 * print information about the panel
	 */
	public void printDebugInfo();

	/**
	 * resets the object.
	 */
	public void reset();
}
