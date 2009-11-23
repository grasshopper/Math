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
	private void initialize() {
		LoginView.getInstance().initialize();
	}

	/**
	 * display server response
	 */
	private void displayServerResponse(String result) {
		// don't display the success message
		return;

		// dialogBox.setText("Remote Procedure Call");
		// serverResponseLabel.removeStyleName("serverResponseLabelError");
		// serverResponseLabel.setHTML(result);
		// dialogBox.center();
		// closeButton.setFocus(true);

		// // Add a handler to close the DialogBox
		// closeButton.addClickHandler(new ClickHandler() {
		// /**
		// * Handles the close button click from the RPC pop-up
		// */
		// public void onClick(ClickEvent event) {
		// dialogBox.hide();
		// sendButton.setEnabled(true);
		// sendButton.setFocus(true);
		// }
		// });
		//
		// // We can set the id of a widget by accessing its Element
		// closeButton.getElement().setId("closeButton");
		// VerticalPanel dialogVPanel = new VerticalPanel();
		// dialogVPanel.addStyleName("dialogVPanel");
		// dialogVPanel.add(new
		// HTML("<b>Sending name to the server:</b>"));
		// dialogVPanel.add(textToServerLabel);
		// dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
		// dialogVPanel.add(serverResponseLabel);
		// dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		// dialogVPanel.add(closeButton);
		// dialogBox.setWidget(dialogVPanel);
	}

}
