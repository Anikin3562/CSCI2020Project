import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Enemy2 {

	// The name of the image representing the second enemy's character.
	// This file must be in the same folder as the Java source files.
	private String imgName = "Tie fighter.png";
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

	// Constructor for the character.
	public Enemy2() {
		// Creates the image representing the character.
		ImageIcon ii = new ImageIcon(this.getClass().getResource(imgName));
		this.image = ii.getImage();

		// Calculates the size of the character based on the image.
		this.width = this.image.getWidth(null);
		this.height = this.image.getHeight(null);
		this.fired = new ArrayList<Missile>();
		// Sets the initial position of the character.
		this.resetPosition2();
		
		//this.x = 600;
		//this.y = 400;
		dx = 1; 
		dy = 1;

		this.isVisible = true;
	}
	public void resetPosition2(){
		this.x = 1100;	
		this.y = 150;
	}
	public boolean getVisibility() {
		return isVisible;
	}
	public void setVisible(boolean visOrNot) {
		this.isVisible = visOrNot;
	}

	// Moves the character. 
	// The width and height of the screen must be passed so that it cannot go out of bounds.
	public void move(int px, int py) {
		// Updates the character's location based on its dx and dy values.
		if(px > this.x){
			this.dx = +2;
	}
		if(px < this.x){ 
			this.dx = -2;
		}	
		if(py < this.y){
			this.dy = -2;
		}
		if(py > this.y){
			this.dy = 2;
		}
		this.x = this.x + this.dx;
		this.y = this.y + this.dy;

		for (int i = 0; i < this.fired.size(); i++) {
			if (this.fired.get(i).getVisibility() == true) {
				// Move the missile if it's visible.	
				this.fired.get(i).move();
			}
			else {
				// Remove the missile if it's not visible.
				this.fired.remove(this.fired.get(i));
			}
		}
	}

	// Returns the x-coordinate of the character.
	// This is primarily so that the content pane knows where to draw it on screen.
	public int getX() {
		return this.x;
	}

	// Returns the y-coordinate of the character.
	public int getY() {
		return this.y;
	}

	// Returns the image of the character.
	public Image getImage() {
		return this.image;
	}
	public ArrayList<Missile> getFiredMissiles() {
		return this.fired;
	}
	public void fire(){
		fired.add(new Missile(this.x, this.y,-1));
	}
	// Returns the hitbox associated with the Character.
	public Rectangle getHitbox() {
		return new Rectangle(this.x, this.y, this.width, this.height);
	}
}