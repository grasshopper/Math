package com.coolisland.client.view;

import com.allen_sauer.gwt.log.client.Log;
import com.coolisland.client.GreetingService;
import com.coolisland.client.GreetingServiceAsync;
import com.coolisland.client.controller.MathController;
import com.coolisland.client.model.LoginModel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

public class LoginView implements ClickHandler, KeyUpHandler {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String	       SERVER_ERROR	       = "An error occurred while "
	                                                               + "attempting to contact the server. Please check your network "
	                                                               + "connection and try again.";
	/**
	 * Create a remote service proxy to talk to the server-side Greeting
	 * service.
	 */
	private final GreetingServiceAsync	greetingService	   = GWT.create(GreetingService.class);

	DialogBox	                       dialogBox	       = null;
	Button	                           closeButton	       = null;
	Label	                           textToServerLabel	= null;
	HTML	                           serverResponseLabel	= null;
	final Button	                   sendButton	       = new Button("Send");
	final TextBox	                   nameField	       = new TextBox();

	private static String	           logDebugIndentation	= "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp";
	private final boolean	           initialized	       = false;

	private LoginView() {
		Log.debug(logDebugIndentation + "Constructor LoginView()");

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
	 * initializes the navigation panel with some hard coded strings
	 */
	public void initialize() {
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
		textToServerLabel = new Label();
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

		Log.debug(logDebugIndentation + this.getClass().getName() + ".initialize() starting");
	}

	/**
	 * Disables the send button
	 */
	public void disableSend() {
		sendButton.setEnabled(false);
	}

	/**
	 * Disables the send button
	 */
	public void enableSend() {
		sendButton.setEnabled(true);
	}

	/**
	 * Fired when the user clicks on the send button to login
	 */
	@Override
	public void onClick(ClickEvent event) {
		sendNameToServer();
	}

	/**
	 * Fired when the user types in the nameField.
	 */
	@Override
	public void onKeyUp(KeyUpEvent event) {
		if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
			sendNameToServer();
		}
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

	/**
	 * Send the name from the nameField to the server and wait for a response.
	 */
	private void sendNameToServer() {
		// disable the send button from the login screen
		LoginView.getInstance().disableSend();

		// get the login name the user entered
		textToServerLabel.setText(LoginModel.getInstance().getLoginName());

		String textToServer = nameField.getText();
		textToServerLabel.setText(textToServer);

		// clear the server response
		serverResponseLabel.setText("");

		/*
		 * submit the login name to the server and pop-up a screen indicating if
		 * we had success or failure logging in
		 */
		greetingService.greetServer(textToServer, new AsyncCallback<String>() {
			/**
			 * onFailure will be called if the login sent to the server fails
			 */
			public void onFailure(Throwable caught) {
				// Show the RPC error message to the user
				dialogBox.setText("Remote Procedure Call - Failure");
				serverResponseLabel.addStyleName("serverResponseLabelError");
				serverResponseLabel.setHTML(SERVER_ERROR);
				dialogBox.center();
				closeButton.setFocus(true);
			}

			/**
			 * onSuccess will be called if the login sent to the server succeeds
			 * 
			 * @param result
			 */
			public void onSuccess(String result) {
				displayServerResponse(result);

				// startup the math application
				MathController.getInstance().initialize();
			}
		});
	}

}
