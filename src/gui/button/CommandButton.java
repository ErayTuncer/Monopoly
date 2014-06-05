package gui.button;

import gui.ResetableComponent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import command.Command;
import controller.Controller;

public abstract class CommandButton extends JButton implements ResetableComponent {

	protected Command command;
	protected Controller controller;
	
	public CommandButton(Command command, Controller controller) {
		this.command = command;
		this.controller = controller;
		addActionListener(getListener());
	}

	protected ActionListener getListener() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				command.execute(controller);
			}
		};
	}
	
}
