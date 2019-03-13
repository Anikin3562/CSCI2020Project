import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Shield {

	// The name of the image representing the character.
	// This file must be in the same folder as the Java source files.
	private String imgName = "TestShield5.png-c200.png";
	private Image image;
	private boolean isVisible;
	private ArrayList<Missile> fired;
	// Movement variables
	private int x;
	private int y;
	private int dx, dy;

	// Represents the width and height of the character. This will be
	// used later...
	private int width;
	private int height;

	// Constructor for the Shield.
	public Shield() {
		// Creates the image representing the Shield.
		ImageIcon ii = new ImageIcon(this.getClass().getResource(imgName));
		this.image = ii.getImage();

		// Calculates the size of the Shield based on the image.
		this.width = this.image.getWidth(null);
		this.height = this.image.getHeight(null);
		this.fired = new ArrayList<Missile>();
		// Sets the initial position of the Shield.
		this.x = 400;
		this.y = 400;
		dx = 1; 
		dy = 1;

		this.isVisible = true;
	}

	public boolean getVisibility() {
		return isVisible;
	}
	public void setVisible(boolean visOrNot) {
		this.isVisible = visOrNot;
	}


	
	// Moves the Shield. 
	// The width and height of the screen must be passed so that it cannot go out of bounds.
	public void move(int px, int py) {
		// Updates the Shield's position based upon the position of the player.
		this.x = px - 60;
		this.y = py -75;

	}

	// Returns the x-coordinate of the Shield.
	// This is primarily so that the content pane knows where to draw it on screen.
	public int getX() {
		return this.x;
	}

	// Returns the y-coordinate of the Shield.
	public int getY() {
		return this.y;
	}

	// Returns the image of the Shield.
	public Image getImage() {
		return this.image;
	}

	// Returns the hitbox associated with the Shield.
	public Rectangle getHitbox() {
		return new Rectangle(this.x, this.y, this.width, this.height);
	}
}