package br.com.academy.threads.src.model;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Car extends Veiculos{

	

	public Car(int x, int y, int combustivelCarro, Color color,  int numeroDeChassi) {
		super(x, y, combustivelCarro, color, numeroDeChassi);
	
	}

	public void mover() {
		if (combustivelCarro > 0) {
			Random rand = new Random();
			int sortx = rand.nextInt(30) - 10;

			x += sortx;
			y += rand.nextInt(30) - 10;

			if (x > 800 || y > 600) {
			//	System.out.print("volta pro inicio");
				x = 0;
				y = 0;
			}
			// consome o combustível
			combustivelCarro -= sortx;
		}
	}

	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawRect(getX(), getY(), 30, 30);
		if (combustivelCarro < 0) {
			g.drawString("X", getX(), getY()+10);
		//	System.out.println("Necessário abastecer o veiculo");
		}

	}

	

}
