package gui;

import java.awt.Cursor;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.Controller;
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
		for (PropertyLand property : controller.getGame().getCurrentPlayer().getProperties()) {
			JButton land = new JButton(property.getName());
			land.setContentAreaFilled(false);
			land.setCursor(new Cursor(Cursor.HAND_CURSOR));
			land.addActionListener(new PropertyButtonListener(property, controller));
			add(land);			
		}
	}
	
}
