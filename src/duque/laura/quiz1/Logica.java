package duque.laura.quiz1;

import java.util.ArrayList;

import processing.core.PApplet;

public class Logica {

	private PApplet app;
	private String[] txt;
	private ArrayList<Figura> figuras;

	public Logica(PApplet app) {
		// TODO Auto-generated constructor stub
		figuras = new ArrayList<Figura>();
		this.app = app;
		txt = app.loadStrings("data/texto.txt");
		for (int i = 0; i < txt.length; i++) {
			String fig[] = txt[i].split(" ");

			switch (fig[0]) {
			case "Cuadrado":
				figuras.add(new Cuadrado(app, Integer.parseInt(fig[1]), Integer.parseInt(fig[2]),
						Integer.parseInt(fig[3]), Integer.parseInt(fig[4]), Integer.parseInt(fig[5])));
				break;
			case "Circulo":
				figuras.add(new Circulo(app, Integer.parseInt(fig[1]), Integer.parseInt(fig[2]),
						Integer.parseInt(fig[3]), Integer.parseInt(fig[4]), Integer.parseInt(fig[5])));
				break;
			}

		}

	}

	public void show() {
		app.background(255);
		for (int i = 0; i < figuras.size(); i++) {
			figuras.get(i).show();
			figuras.get(i).mover();
		}
		colission();
	}

	public void released() {
		if (app.mouseButton == app.RIGHT) {
			float r = app.random(1);
			int dir;
			if (r >= 0.5) {
				dir = 1;
			} else {
				dir = -1;
			}
			r = app.random(1);
			if (r >= 0.5) {
				figuras.add(new Cuadrado(app, (int) app.random(10,100), (int) app.random(app.width), (int) app.random(app.height), dir,
						(int)	app.random(1,51)));				
			} else {
				figuras.add(new Circulo(app, (int) app.random(10,100), (int) app.random(app.width), (int) app.random(app.height), dir,
						(int)	app.random(1,51)));
			}

		} else {
			
			for (int i = 0; i < figuras.size(); i++) {
				figuras.get(i).click(app.mouseX, app.mouseY);
			}
		}
	}

	public void colission() {
		for (int i = 0; i < figuras.size(); i++) {
			Figura a = figuras.get(i);
			for (int j = 0; j < figuras.size(); j++) {
				Figura b = figuras.get(j);
				if (a != b && a instanceof Triangulo == false && b instanceof Triangulo == false) {

					if (app.dist(a.getX(), a.getY(), b.getX(), b.getY()) < a.getTam()) {
						float r = app.random(1);
						int dir;
						if (r >= 0.5) {
							dir = 1;
						} else {
							dir = -1;
						}
						figuras.add(new Triangulo(app, (int) app.random(10,100), a.getX(), a.getY(), dir,
								(a.getVal() + b.getVal())));
						figuras.remove(a);
						figuras.remove(b);

					}
				}
			}
		}
	}

}
