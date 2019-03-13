import javax.swing.JFrame;
/* Game.java
 * 
 * This class extends JFrame. It opens the main window of our game.
 * This means that it IS considered a JFrame and also has additional member variables
 * as shown below. Additionally, it allows us to set various attributes in the constructor of the class.
 *
 */

/* What needs to be done if you are to use for Software final: 
 * Must clear window after death. 
 * Add destruction 'animations' upon dying. 
 * Fix Asteroid AI/Spawning pattern.
 * Fix Power-up spawning, possibly add some animation that triggers after grabbing the power-up. 
 * Bigger ship?.
 * IMPORTANT: Update UI to use Javafx, rather than Jframe. 
 * Improve overall feel of the game (It's rather clunky currently)
 * Improve main screen. 
 */
public class Game extends JFrame {

	// Static final variables are constant values that never change.
	static final int W_WIDTH = 800;
	static final int W_HEIGHT = 600;
	
	public Game() {
		// Creates an instance of our game content and adds 
		// it to the JFrame's content pane.
		this.getContentPane().add(new GameContent(W_WIDTH, W_HEIGHT));
		
		// Sets various attributes of the JFrame.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(W_WIDTH, W_HEIGHT);
		
		this.setTitle("ISU Game By: Joshua Wry");
		this.setResizable(false);
		this.setVisible(true);
	}

	// The game's main method. This simply creates an instance
	// of the JFrame and from there, the game begins running!
	public static void main(String[] args) {
		Game gameWindow = new Game();
	}
}
