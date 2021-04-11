package duque.laura.quiz1;

import processing.core.PApplet;

public abstract class Figura {

	protected PApplet app;
	protected int x;
	protected int y;
	protected int tam;
	protected int velX;
	protected int velY;
	protected int val;
	private boolean isMoving = true;

	public Figura(PApplet app, int tam, int x, int y, int dir, int val) {
		// TODO Auto-generated constructor stub
		this.app = app;
		this.tam = tam;
		this.x = x;
		this.y = y;
		this.velX = 2 * dir;
		this.velY = 2 * dir;
		this.val = val;

	}

	public abstract void show();

	public void mover() {
		if (isMoving) {
			x += velX;
			y += velY;
			if ((x < tam && velX < 0 ) || (x > app.width - tam && velX >0)) {
				velX *= -1;
			}
			if ( (y < tam && velY < 0 ) || (y > app.height - tam && velY > 0)) {
				velY *= -1;
			}
		}
	}

	public void click(int mX,int mY) {
		if(app.dist(x, y, mX, mY)<tam) {
			isMoving = !isMoving;
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public int getTam() {
		return tam;
	}

	public void setTam(int tam) {
		this.tam = tam;
	}
	
	

}