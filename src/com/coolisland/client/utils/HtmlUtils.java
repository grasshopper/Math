package com.coolisland.client.utils;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Node;
import com.google.gwt.dom.client.NodeList;

public class HtmlUtils {
	private final String	logDebugIndentation	= "  ";
	private String	     elemIndentation	    = "";
	private String	     nodeIndentation	    = "";

	/**
	 * 
	 * @param e
	 */
	public void printElement(Element e) {

		// start from the top most element
		if (e.getParentElement() != null) {
			printElement(e.getParentElement());
			elemIndentation += " ";
		}

		Log.debug("");
		Log.debug(logDebugIndentation + this.getClass().getName() + elemIndentation
		        + "Element name: " + e.getNodeName());
		Log.debug(logDebugIndentation + this.getClass().getName() + elemIndentation
		        + "Element type: " + e.getNodeType());
		Log.debug(logDebugIndentation + this.getClass().getName() + elemIndentation
		        + "Element value: " + e.getNodeValue());
		Log.debug(logDebugIndentation + this.getClass().getName() + elemIndentation
		        + "Element has children: " + e.hasChildNodes());
		Log.debug(logDebugIndentation + this.getClass().getName() + elemIndentation
		        + "Element title: " + e.getTitle());
		Log.debug(logDebugIndentation + this.getClass().getName() + elemIndentation
		        + "Element absolute left: " + e.getAbsoluteLeft());
		Log.debug(logDebugIndentation + this.getClass().getName() + elemIndentation
		        + "Element absolute top: " + e.getAbsoluteTop());
		Log.debug(logDebugIndentation + this.getClass().getName() + elemIndentation
		        + "Element ID: " + e.getId());
		Log.debug(logDebugIndentation + this.getClass().getName() + elemIndentation
		        + "Element inner text: " + e.getInnerText());
		Log.debug(logDebugIndentation + this.getClass().getName() + elemIndentation
		        + "Element tag name: " + e.getTagName());

		// NodeList<Node> children = e.getChildNodes();
		// for (int i = 0; i < children.getLength(); i++) {
		// nodeIndentation = " ";
		// Node child = children.getItem(i);
		// printNode(child);
		// }
		Log.debug("");
	}

	/**
	 * 
	 * @param node
	 */
	public void printNode(Node node) {
		Log.debug(logDebugIndentation + this.getClass().getName() + elemIndentation
		        + nodeIndentation + "Node name: " + node.getNodeName());
		Log.debug(logDebugIndentation + this.getClass().getName() + elemIndentation
		        + nodeIndentation + "Node type: " + node.getNodeType());
		System.out
		        .println(elemIndentation + nodeIndentation + "Node value: " + node.getNodeValue());
		Log.debug(logDebugIndentation + this.getClass().getName() + elemIndentation
		        + nodeIndentation + "Node has children: " + node.hasChildNodes());

		// print the node's children
		if (node.hasChildNodes()) {
			NodeList<Node> children = node.getChildNodes();

			for (int i = 0; i < children.getLength(); i++) {
				Node child = children.getItem(i);
				printNode(child);
				nodeIndentation += " ";
			}
		}
		Log.debug("");
	}
}
