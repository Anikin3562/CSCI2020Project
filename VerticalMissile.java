import java.awt.Image;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

// Class representing a missile. 
//This class has the same functions as the other missile class, except
//this class deals with the a vertical missile, which is fired from above rather than
//horizontally.
public class VerticalMissile {

	// Location and image settings.
	private int x, y;
	private Image image;
	boolean visible;
	private int width, height,direction;

	
	// Constant that specifies the missile's speed.
	private final int MISSILE_SPEED = 4;

	public VerticalMissile(int x, int y, int dir) {

		ImageIcon ii = new ImageIcon(this.getClass().getResource("VerticalMissile.png"));
		image = ii.getImage();
		visible = true;
		width = image.getWidth(null);
		height = image.getHeight(null);
		this.x = x;
		this.y = y;
		direction = dir;
	}


	public Image getImage() {
		return image;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean getVisibility() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}

	public void move() {
		y = y + (MISSILE_SPEED*direction);
	
	}
		public Rectangle getHitbox() {
			return new Rectangle(this.x, this.y, this.width, this.height);
	}
}
