package gui.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import command.MortgageCommand;
import controller.Controller;
import element.PropertyLand;

public class PropertyButton implements ActionListener {

	PropertyLand property;
	Controller controller;

	public PropertyButton(PropertyLand property, Controller controller) {
		this.property = property;
		this.controller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new MortgageCommand(property).execute(controller);
	}



}
