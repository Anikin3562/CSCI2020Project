import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.*;

public class GameContent extends JPanel implements ActionListener{

	// Timer for animation purposes
	private Timer timer;

	// Our main character
	private Shield shield;
	private Character player;
	private Enemy1 enemy;
	private Enemy2 enemy2;
	private Enemy3 enemy3;
	private Bombardment ssd;
	// The coin object.
	private Coin coin;
	private Coin2 coin2;
	private Barrier barrier;
	private Asteroid2 asteroid;
	// Backgrounds
	Background bg1, bg2;

	private boolean menuOn;

	// Constructor for the game content
	public GameContent(int width, int height) {
		// Common settings for JPanel
		this.setFocusable(true);
		this.setBackground(Color.BLACK);
		this.setDoubleBuffered(true);
		this.setSize(width, height);

		// Creates an instance of the player's character, as well as all other objects in the game.
		this.shield = new Shield();
		this.player = new Character();
		this.ssd = new Bombardment();
		this.coin = new Coin();
		this.coin2 = new Coin2();
		this.barrier = new Barrier();
		this.enemy = new Enemy1();
		this.enemy2 = new Enemy2();
		this.enemy3 = new Enemy3();
		this.asteroid = new Asteroid2();
		// Adds a KeyListener to this JPanel object. 
		// A key listener is an object that intercepts keystrokes allowing
		// you to process them. The code for this key listener is at the 
		// bottom of this file.
		this.addKeyListener(new KeyListener());		

		this.menuOn = true;

		// Background stuff;
		this.bg1 = new Background(0,0, "SPACE.png");
		this.bg2 = new Background(800,0, "SPACE.png");

		// Creates a new Timer. The timer "goes off" every 5ms and calls
		// the actionPerformed() method. This allows us to update game content
		// rapidly.
		this.timer = new Timer(5, this);
		this.timer.start();
	}

	// The following method must be included so that the board is displayed on screen.
	// It's a required method that ensures the window is actively redrawn.
	public void addNotify() {
		super.addNotify(); 
	}
	//Scoring System Variables
	int score = 0;
	int finalscore = 0;
	// This method instructs Java how to "paint" the game content.

	public void paint(Graphics g) {



		// Tells the JPanel class to paint itself. DO NOT MODIFY!

		super.paint(g);

		// Grabs the Graphics object to draw images. DO NOT MODIFY!
		Graphics2D g2d = (Graphics2D)g;

		// When the Menu is not on, the game will proceed to run.
		if (menuOn == false) {
			g2d.drawImage(bg1.getImage(), bg1.getX(), bg1.getY(), this);
			g2d.drawImage(bg2.getImage(), bg2.getX(), bg2.getY(), this);
			g2d.setFont(Font.decode("arial-bold-36"));
			g2d.drawString("Score: " + score, 0, 560);
			finalscore = score;
			// Draws the character and other objects, also arranges shooting system 
			//for applicable objects.
			if(this.player.getVisibility() == true){
				g2d.drawImage(this.player.getImage(),  this.player.getX(),  this.player.getY(), this);
			}

			ArrayList<Missile> firedMissiles1 = this.player.getFiredMissiles();
			for (int i = 0; i < firedMissiles1.size(); i++ ) {
				if (firedMissiles1.get(i).getVisibility() == true) {
					g2d.drawImage(firedMissiles1.get(i).getImage(), firedMissiles1.get(i).getX(), firedMissiles1.get(i).getY(), this);
				}
			}
			ArrayList<Missile> firedMissiles2 = this.enemy.getFiredMissiles();	
			for(int i = 0; i < firedMissiles2.size(); i++){
				if(firedMissiles2.get(i).getVisibility() == true){
					g2d.drawImage(firedMissiles2.get(i).getImage(), firedMissiles2.get(i).getX(), firedMissiles2.get(i).getY(), this);
				}
			}	
			ArrayList<Missile> firedMissiles4 = this.enemy2.getFiredMissiles();	
			for(int i = 0; i < firedMissiles4.size(); i++){
				if(firedMissiles4.get(i).getVisibility() == true){
					g2d.drawImage(firedMissiles4.get(i).getImage(), firedMissiles4.get(i).getX(), firedMissiles4.get(i).getY(), this);
				}
			}
			ArrayList<Missile> firedMissiles5 = this.enemy3.getFiredMissiles();	
			for(int i = 0; i < firedMissiles5.size(); i++){
				if(firedMissiles5.get(i).getVisibility() == true){
					g2d.drawImage(firedMissiles5.get(i).getImage(), firedMissiles5.get(i).getX(), firedMissiles5.get(i).getY(), this);
				}
			}
			ArrayList<VerticalMissile> firedMissiles3 = this.ssd.getFiredMissiles();	
			for(int i = 0; i < firedMissiles3.size(); i++){
				if(firedMissiles3.get(i).getVisibility() == true){
					g2d.drawImage(firedMissiles3.get(i).getImage(), firedMissiles3.get(i).getX(), firedMissiles3.get(i).getY(), this);
				}
			}

			if (this.coin.getVisibility()) {
				g2d.drawImage(this.coin.getImage(),  this.coin.getX(),  this.coin.getY(), this);
			}
			if (this.coin2.getVisibility()) {
				g2d.drawImage(this.coin2.getImage(),  this.coin2.getX(),  this.coin2.getY(), this);
			}
			if(this.barrier.getVisibility()){
				g2d.drawImage(this.barrier.getImage(),  this.barrier.getX(),  this.barrier.getY(), this);
			}
			if(this.enemy.getVisibility()){
				g2d.drawImage(this.enemy.getImage(), this.enemy.getX(), this.enemy.getY(), this);
			}	
			if(this.enemy2.getVisibility()){
				g2d.drawImage(this.enemy2.getImage(), this.enemy2.getX(), this.enemy2.getY(), this);
			}	
			if(this.enemy3.getVisibility()){
				g2d.drawImage(this.enemy3.getImage(), this.enemy3.getX(), this.enemy3.getY(), this);
			}	
			if(this.asteroid.getVisibility()){
				g2d.drawImage(this.asteroid.getImage(),  this.asteroid.getX(),  this.asteroid.getY(), this);
			}
			if(this.ssd.getVisibility()){
				g2d.drawImage(this.ssd.getImage(),  this.ssd.getX(),  this.ssd.getY(), this);
			}
			if(this.shield.getVisibility()){
				g2d.drawImage(this.shield.getImage(),  this.shield.getX(),  this.shield.getY(), this);
			}

		} else {
			// Draws the Menu when menuOn is true.

			g2d.drawImage(bg2.getImage(), 0, 0, this);
			g2d.setFont(Font.decode("arial-bold-36"));
			g2d.drawString("PRESS ENTER TO BEGIN", 180, 300);
			g2d.drawString("Final Score: " + finalscore, 265, 400);
			g2d.drawString("Arrowkeys to move, Space to shoot!", 100, 500);

		}
		// Synchronizes the graphics state. DO NOT MODIFY!
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}


	public void actionPerformed(ActionEvent e) {

		// When the Menu is not toggled on, the game will continue to run.
		if (menuOn == false) {
			// Update BG movement.
			// This method is called every 5ms. We will use it to tell
			// classes that they should update their images, locations, and
			// other similar content. For now, it is empty.
			bg1.move();
			bg2.move();
			// Updates the player's position.
			player.move();
			//  Update object locations
			this.shield.move(player.getX(),player.getY());
			this.coin.move();
			this.coin2.move();
			this.barrier.move();
			this.enemy.move();
			this.enemy2.move(player.getX(),player.getY());
			this.enemy3.move(player.getX(),player.getY());
			this.asteroid.move();
			this.ssd.move();
			// Check for collisions, activated firing pattern and checks for destroyed enemies.
			FiringPattern1();
			FiringPattern2();
			FiringPattern3();
			checkForCollisions();
			CheckRespawn();
		}
		// Tells the JPanel to repaint itself since object positions
		// may have changed.
		repaint();  
	}

	private void CheckRespawn(){
		//Checks for disabled objects, will set them visible based upon randomness.
		if(coin.getVisibility() == false || coin2.getVisibility() == false || barrier.getVisibility() == false || enemy.getVisibility() == false || asteroid.getVisibility() == false || enemy2.getVisibility() == false || enemy3.getVisibility() == false){	
			int COR = (int) (Math.random()*100)+1;
			if(COR == 1){
				this.coin.setVisible(true);
				this.coin2.setVisible(true);
				this.barrier.setVisible(true);
				this.asteroid.setVisible(true);
			}
		}
	}
	// All Firing patterns below are applicable for each of the 3 enemies that use them.
	private void FiringPattern1(){
		if(this.enemy.getVisibility() == true){
			int FP = (int) (Math.random()*100)+1;
			if(FP == 1){
				this.enemy.fire();
			}
		}
	}
	private void FiringPattern2(){
		if(this.enemy2.getVisibility() == true){
			int FP = (int) (Math.random()*100)+1;
			if(FP == 1){
				this.enemy2.fire();
			}
		}
	}
	private void FiringPattern3(){
		if(this.enemy3.getVisibility() == true){
			int FP = (int) (Math.random()*100)+1;
			if(FP == 1){
				this.enemy3.fire();
			}
		}
	}
	//Power-up: Bombardment; calls missiles from above the map to strike enemy objects.
	private void BP(){
		if(this.ssd.getVisibility() == true){
			int FP = (int) (Math.random()*100)+1;
			if(FP > 10){
				this.ssd.fire();
				if (FP == 1){
					this.ssd.setVisible(false);

				}
			}
		}
	}

	// Method that checks for collisions and reacts accordingly.
	private void checkForCollisions() {
		// Get the hitbox for the Character.
		Rectangle charHitbox = this.player.getHitbox();
		//Rectangle charHitbox2 = this.player2.getHitbox();



		// Get the hitboxes for all objects
		Rectangle shieldHitbox = this.shield.getHitbox();
		Rectangle coinHitbox = this.coin.getHitbox();
		Rectangle coin2Hitbox = this.coin2.getHitbox();
		Rectangle enemyHitbox = this.enemy.getHitbox();
		Rectangle enemy2Hitbox = this.enemy2.getHitbox();
		Rectangle enemy3Hitbox = this.enemy3.getHitbox();
		Rectangle barrierHitbox = this.barrier.getHitbox();
		Rectangle asteroidHitbox = this.asteroid.getHitbox();

		//Missile object called for enemies.
		ArrayList<Missile> firedMissiles2 = this.enemy.getFiredMissiles();
		ArrayList<VerticalMissile>firedMissiles3 = this.ssd.getFiredMissiles();
		ArrayList<Missile> firedMissiles4 = this.enemy2.getFiredMissiles();
		ArrayList<Missile> firedMissiles5 = this.enemy3.getFiredMissiles();

		//Calls in bombardment when player intersects the coin2 object, sets coin2 invisible.
		if(coin2Hitbox.intersects(charHitbox)){
			BP();
			this.coin2.setVisible(false);
		}
		//Reinstates shield when player intersects coin object.
		if(this.coin.getVisibility() == true) {
			// Check if the two objects collided.

			if (charHitbox.intersects(coinHitbox)) {

				// Set the coin to be invisible and shield visible.
				this.coin.setVisible(false);
				this.shield.setVisible(true);


			}
		}



		// Everything below is the functions of the game, 
		//including the conditions that the player dies from, as well as the enemy objects.
		//The player's score is also tallied up for display. 
		if(this.player.getVisibility() == true){
			for (int i = 0; i < firedMissiles3.size(); i++){
				Rectangle VerticalMissileHitbox = firedMissiles3.get(i).getHitbox();
				if(VerticalMissileHitbox.intersects(enemyHitbox)){
					this.enemy.setVisible(false);
					this.enemy.resetPosition1();
					this.enemy.setVisible(true);
					score = score + 50;
					finalscore = finalscore + 50;
				}
				if(VerticalMissileHitbox.intersects(enemy2Hitbox)){
					this.enemy2.setVisible(false);
					this.enemy2.resetPosition2();
					this.enemy2.setVisible(true);
					score = score + 50;
					finalscore = finalscore + 50;
				}
				if(VerticalMissileHitbox.intersects(enemy3Hitbox)){
					this.enemy3.setVisible(false);
					this.enemy3.resetPosition3();
					this.enemy3.setVisible(true);
					score = score + 50;
					finalscore = finalscore + 50;
				}
				if(VerticalMissileHitbox.intersects(barrierHitbox)){
					this.barrier.setVisible(false);
					this.barrier.resetPosition();
					this.barrier.setVisible(true);
					score = score + 25;
					finalscore = finalscore + 25;
				}
				if(VerticalMissileHitbox.intersects(asteroidHitbox)){
					this.asteroid.setVisible(false);	
					this.asteroid.resetPosition();	
					this.asteroid.setVisible(true);
					score = score + 25;
					finalscore = finalscore + 25;
				}
			}
		}
		if(asteroidHitbox.intersects(shieldHitbox) && shield.getVisibility() == true){

			this.asteroid.setVisible(false);
			this.asteroid.resetPosition();
			this.asteroid.setVisible(true);
			this.shield.setVisible(false);
		}	
		if(barrierHitbox.intersects(shieldHitbox) && shield.getVisibility() == true){
			this.barrier.setVisible(false);
			this.barrier.resetPosition();
			this.barrier.setVisible(true);
			this.shield.setVisible(false);
		}


		for (int i = 0; i < firedMissiles2.size(); i++){
			Rectangle MissileHitbox = firedMissiles2.get(i).getHitbox();

			//If the player dies, the menu will turn on. 
			if (MissileHitbox.intersects(charHitbox)){
				this.player.setVisible(false);
				menuOn = true;
				this.player.resetPositionP();
				this.player.setVisible(true);
				this.enemy.resetPosition1();
				this.enemy2.resetPosition2();
				this.enemy3.resetPosition3();
				this.shield.setVisible(true);
				score = 0;


			}
			if (asteroidHitbox.intersects(charHitbox) && this.asteroid.getVisibility() == true){
				this.player.setVisible(false);
				menuOn = true;
				this.player.resetPositionP();
				this.player.setVisible(true);
				this.asteroid.resetPosition();
				this.barrier.setVisible(false);
				this.enemy.resetPosition1();
				this.enemy2.resetPosition2();
				this.enemy3.resetPosition3();
				this.shield.setVisible(true);
				score = 0;

			}
		}
		for (int i = 0; i < firedMissiles5.size(); i++){
			Rectangle MissileHitbox = firedMissiles5.get(i).getHitbox();

			if (MissileHitbox.intersects(charHitbox)){

				this.player.setVisible(false);
				menuOn = true;
				this.player.resetPositionP();
				this.player.setVisible(true);
				this.enemy.resetPosition1();
				this.enemy2.resetPosition2();
				this.enemy3.resetPosition3();
				this.asteroid.resetPosition();
				this.shield.setVisible(true);
				score = 0;

			}
			if (asteroidHitbox.intersects(charHitbox)){
				this.player.setVisible(false);
				menuOn = true;
				this.player.resetPositionP();
				this.player.setVisible(true);
				this.enemy.resetPosition1();
				this.enemy2.resetPosition2();
				this.enemy3.resetPosition3();
				this.asteroid.resetPosition();
				this.shield.setVisible(true);
				score = 0;

			}
		}
		for (int i = 0; i < firedMissiles4.size(); i++){
			Rectangle MissileHitbox = firedMissiles4.get(i).getHitbox();

			if (MissileHitbox.intersects(charHitbox)){
				this.player.setVisible(false);
				menuOn = true;
				this.player.resetPositionP();
				this.player.setVisible(true);
				this.enemy.resetPosition1();
				this.enemy2.resetPosition2();
				this.enemy3.resetPosition3();
				this.asteroid.resetPosition();
				this.shield.setVisible(true);
				score = 0;

			}
			if (asteroidHitbox.intersects(charHitbox)){
				this.player.setVisible(false);
				menuOn = true;
				this.player.resetPositionP();
				this.player.setVisible(true);
				this.enemy.resetPosition1();
				this.enemy2.resetPosition2();
				this.enemy3.resetPosition3();
				this.asteroid.resetPosition();
				this.shield.setVisible(true);
				score = 0;

			}
		}

		ArrayList<Missile> firedMissiles1 = this.player.getFiredMissiles();
		for (int i = 0 ; i < firedMissiles1.size(); i++) {
			Rectangle MissileHitbox = firedMissiles1.get(i).getHitbox();

			if (MissileHitbox.intersects(enemy2Hitbox)){
				this.enemy2.setVisible(false);
				this.enemy2.resetPosition2();
				this.enemy2.setVisible(true);
				score = score + 50;
				finalscore = finalscore + 50;
			}

			if (MissileHitbox.intersects(enemy3Hitbox)){
				this.enemy3.setVisible(false);
				this.enemy3.resetPosition3();
				this.enemy3.setVisible(true);
				score = score + 50;
				finalscore = finalscore + 50;
			}	
			if (MissileHitbox.intersects(barrierHitbox)) {
				this.barrier.setVisible(false);
				this.barrier.resetPosition();
				this.barrier.setVisible(true);
				score = score + 25;
				finalscore = finalscore + 25;
			}				
			if(MissileHitbox.intersects(enemyHitbox)){
				this.enemy.setVisible(false);
				this.enemy.resetPosition1();
				this.enemy.setVisible(true);
				score = score + 50;
				finalscore = finalscore + 50;
			}
			if(MissileHitbox.intersects(asteroidHitbox)){
				this.asteroid.setVisible(false);		
				this.asteroid.resetPosition();
				this.asteroid.setVisible(true);
				score = score + 25;
				finalscore = finalscore + 25;
			}
		}

		if (charHitbox.intersects(barrierHitbox)){	
			this.player.setVisible(false);
			menuOn = true;
			this.player.resetPositionP();
			this.player.setVisible(true);
			this.asteroid.resetPosition();
			this.enemy.resetPosition1();
			this.enemy2.resetPosition2();
			this.enemy3.resetPosition3();
			this.shield.setVisible(true);
			this.barrier.setVisible(false);
			score = 0;


		}
	
	}


	// Private class -- this is a class that outside Java files
	// cannot see. It's sole purpose is to intercept keystrokes
	// and send them to the player class for processing.
	// DO NOT MODIFY!
	//Pressing Enter will start the game (Erases Menu).
	private class KeyListener extends KeyAdapter {

		public void keyReleased(KeyEvent e) {
			if (menuOn == false) {
				player.keyReleased(e);
			

			}
		}

		public void keyPressed(KeyEvent e) {
			if (menuOn == true) {
				// Intercept key stroke to determine if menu should be turned off.

				if (e.getKeyCode() == e.VK_ENTER)


					menuOn = false;

			}
			else {
				player.keyPressed(e);
				
			}
		}
	}

}
