package element;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Token {
	private int landIndex;
	String imagePath;

	public Token(int tokenID) {
		this.imagePath = String.format("assets/tokens/monopoly_token_%d.png", tokenID);
	}

	public void setLocation(int landIndex) {
		this.landIndex = landIndex;
	}

	public int getLandIndex() {
		return landIndex;
	}

	public Image getImage() {
		Image tokenImage = new ImageIcon(imagePath).getImage();
		return tokenImage.getScaledInstance(30, 22, Image.SCALE_SMOOTH);
	}
}
