package duque.laura.quiz1;

import processing.core.PApplet;

public class Triangulo extends Figura {
	
	int r = (int) app.random(255);
	int g = (int) app.random(255);
	int b = (int) app.random(255);

	public Triangulo(PApplet app, int tam, int x, int y, int dir, int val) {
		super(app, tam, x, y, dir, val);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		app.fill(r,g,b,80);
		app.triangle(x, y-tam, x-tam, y+tam, x+tam, y+tam);
		app.fill(0);
		app.textSize(10);
		app.text(val,x, y);	
	}

}
