package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.Controller;
import element.Player;
import element.PropertyLand;
import gui.button.PropertyButtonListener;

public class PropertyListPanel extends JPanel {
	
	public PropertyListPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(new TitledBorder("Properties Owned"));
		setAlignmentX(CENTER_ALIGNMENT);
		setVisible(true);
	}

	public void setProperties(Controller controller) {
		removeAll();
		listProperties(controller, Color.BLACK);
		listMortgages(controller, Color.RED);
	}

	private void listProperties(Controller controller, Color color) {
		ArrayList<PropertyLand> properties = controller.getGame().getCurrentPlayer().getProperties();
		for (PropertyLand property : properties) {
			JButton land = new JButton(property.getName());
			land.setContentAreaFilled(false);
			land.setForeground(color);
			land.setCursor(new Cursor(Cursor.HAND_CURSOR));
			land.addActionListener(new PropertyButtonListener(property, controller));
			add(land);			
		}
	}

	private void listMortgages(Controller controller, Color color) {
		ArrayList<PropertyLand> mortgages = controller.getGame().getCurrentPlayer().getMortgagedProperties();
		for (PropertyLand mortgage : mortgages) {
			JButton land = new JButton(mortgage.getName());
			land.setContentAreaFilled(false);
			land.setForeground(color);
			land.setCursor(new Cursor(Cursor.HAND_CURSOR));
			land.addActionListener(new PropertyButtonListener(mortgage, controller));
			add(land);			
		}		
	}
	
}
