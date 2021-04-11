package duque.laura.quiz1;

import processing.core.PApplet;

public class Main extends PApplet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("duque.laura.quiz1.Main");

	}

	Logica log;

	public void settings() {
		size(1200, 700);
	}
	
	public void setup() {
		log = new Logica(this);
		ellipseMode(CENTER);
		rectMode(CENTER);
		textAlign(CENTER,CENTER);
	}

	public void draw() {

		log.show();

	}

	public void mouseReleased() {
		log.released();
	}
}
