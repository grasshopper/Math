package com.coolisland.client.view;

import com.allen_sauer.gwt.log.client.Log;
import com.coolisland.client.controller.LoginController;
import com.coolisland.client.model.LoginModel;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

public class LoginView {
	DialogBox	          dialogBox	            = null;
	Button	              closeButton	        = null;
	// Label textToServerLabel = null;
	HTML	              serverResponseLabel	= null;
	final Button	      sendButton	        = new Button("Send");
	final TextBox	      nameField	            = new TextBox();

	private static String	logDebugIndentation	= "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp";
	private boolean	      initialized	        = false;

	private LoginView() {
		Log.debug(logDebugIndentation + "Constructor LoginView() starting");

		initialize();

		Log.debug(logDebugIndentation + "Constructor LoginView() finished");
	}

	/**
	 * SingletonHolder is loaded on the first execution of
	 * LoginView.getInstance() or the first access to
	 * SingletonHolder.theLoginViewSingletonInst, not before.
	 */
	private static class SingletonHolder {
		private static final LoginView	theLoginViewSingletonInst	= new LoginView();
	}

	public static LoginView getInstance() {
		Log.debug(logDebugIndentation + "LoginView.getInstance()");

		return SingletonHolder.theLoginViewSingletonInst;
	}

	/**
	 * Handler for the sendButton and nameField. This class is responsible for
	 * handling the user logging in.
	 * 
	 * @author Silvio
	 * 
	 */
	class LoginHandler implements ClickHandler, KeyUpHandler {
		DialogBox	dialogBox		    = null;
		Button		closeButton		    = null;
		// Label textToServerLabel = null;
		HTML		serverResponseLabel	= null;

		public LoginHandler() {
			// Create the popup dialog box
			dialogBox = new DialogBox();
			dialogBox.setText("Remote Procedure Call");
			dialogBox.setAnimationEnabled(true);

			closeButton = new Button("Close");
			// textToServerLabel = new Label();
			serverResponseLabel = new HTML();
		}

		/**
		 * Fired when the user clicks on the send button to login
		 */
		public void onClick(ClickEvent event) {
			// get the login name the user entered
			String loginName = LoginModel.getInstance().getLoginName();

			LoginController.getInstance().sendNameToServer(loginName);
		}

		/**
		 * Fired when the user types in the nameField.
		 */
		public void onKeyUp(KeyUpEvent event) {
			if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
				// get the login name the user entered
				String loginName = LoginModel.getInstance().getLoginName();

				LoginController.getInstance().sendNameToServer(loginName);
			}
		}
	}

	/**
	 * display server response
	 */
	public void displayLoginResponse(boolean sucess, String result) {

		if (!sucess) {
			// Show the RPC error message to the user
			dialogBox.setText("Remote Procedure Call - Failure");
			serverResponseLabel.addStyleName("serverResponseLabelError");
			serverResponseLabel.setHTML(result);
			dialogBox.center();
			closeButton.setFocus(true);
		} else {
			// don't display the success message
			// dialogBox.setText("Remote Procedure Call");
			// serverResponseLabel.removeStyleName("serverResponseLabelError");
			// serverResponseLabel.setHTML(result);
			// dialogBox.center();
			// closeButton.setFocus(true);
		}

		// Add a handler to close the DialogBox
		closeButton.addClickHandler(new ClickHandler() {
			/**
			 * Handles the close button click from the RPC pop-up
			 */
			public void onClick(ClickEvent event) {
				dialogBox.hide();
				sendButton.setEnabled(true);
				sendButton.setFocus(true);
			}
		});
	}

	/**
	 * initializes the navigation panel with some hard coded strings
	 */
	public void initialize() {
		Log.debug(logDebugIndentation + this.getClass().getName() + ".initialize() starting");

		// if we have already initialized, just return
		if (initialized) {
			Log.debug(logDebugIndentation + this.getClass().getName()
			        + ".initialize() no need to initialize");
			return;
		}

		dialogBox = new DialogBox();
		dialogBox.setText("Remote Procedure Call");
		dialogBox.setAnimationEnabled(true);

		closeButton = new Button("Close");
		// textToServerLabel = new Label();
		serverResponseLabel = new HTML();

		nameField.setText("William");

		// We can add style names to widgets
		sendButton.addStyleName("sendButton");

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel.get("nameFieldContainer").add(nameField);
		RootPanel.get("sendButtonContainer").add(sendButton);

		// Focus the cursor on the name field when the app loads
		nameField.setFocus(true);
		nameField.selectAll();

		// Add a handler to send the name to the server
		LoginHandler handler = new LoginHandler();
		sendButton.addClickHandler(handler);
		nameField.addKeyUpHandler(handler);

		// set flag indicating that we have initialized ourselves
		initialized = true;

		Log.debug(logDebugIndentation + this.getClass().getName() + ".initialize() finished");
	}

	/**
	 * Disables the send button
	 */
	public void disableSend() {
		Log.debug(logDebugIndentation + "disableSend() starting");

		sendButton.setEnabled(false);

		Log.debug(logDebugIndentation + "disableSend() finished");
	}

	/**
	 * Disables the send button
	 */
	public void enableSend() {
		Log.debug(logDebugIndentation + "enableSend() starting");

		sendButton.setEnabled(true);

		Log.debug(logDebugIndentation + "enableSend() finished");
	}

}
