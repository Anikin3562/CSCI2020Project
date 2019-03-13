import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
// This class enables the background to scroll by using two of the 
//same image and moving them simultaneously.
public class Background {

	private Image image;


	// Movement variables
	private int x;
	private int y;
	private int dx, dy;


	public Background(int sx, int sy, String fileName) {
		this.x = sx;
		this.y = sy;
		ImageIcon ii = new ImageIcon(this.getClass().getResource(fileName));
		this.image = ii.getImage();
	}
	// Returns the x-coordinate of the character.
	// This is primarily so that the content pane knows where to draw it on screen.
	public int getX() {
		return this.x;
	}

	public void move() {
		x = x - 1;
		if (x == -800) {
			x = 800;
		}
	}
	// Returns the y-coordinate of the character.
	public int getY() {
		return this.y;
	}

	// Returns the image of the character.
	public Image getImage() {
		return this.image;
	}




}

