package br.com.academy.threads.src.Main;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.*;

import br.com.academy.threads.src.model.Car;
import br.com.academy.threads.src.model.Factory;
import br.com.academy.threads.src.service.MovimentacaoVeiculos;
import br.com.academy.threads.src.service.Posto;
import br.com.academy.threads.src.service.SupplyFactory;

class FrameUI extends JFrame {

	private JPanel jPanel2;

	public FrameUI() {
		initComponents();

	}

	private void initComponents() {
		jPanel2 = new Panel2();
		jPanel2.setBackground(new java.awt.Color(255, 255, 255));
		jPanel2.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		this.setContentPane(jPanel2);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
	}

	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new FrameUI().setVisible(true);
			}
		});
	}

	class Panel2 extends JPanel {

		private ArrayList<Car> carros;

		Panel2() {
			setPreferredSize(new Dimension(800, 600));
			iniciarCarros();
		}

		private Color defineColor() {
			Random rand = new Random();
			float r = rand.nextFloat();
			float g = rand.nextFloat();
			float b = rand.nextFloat();
			return new Color(r, g, b);
		}

		private void iniciarCarros() {
			
			Random rand = new Random();
			Thread tFactory = new Thread(new SupplyFactory());
			tFactory.start();



		
			//Cria 10 novos carros
			carros = new ArrayList<Car>();
			for (int i = 0; i < 10; i++) {
				Car c = new Car(rand.nextInt(800), rand.nextInt(600), rand.nextInt(50), defineColor(), i);
				c.mover();
				carros.add(c);
				Thread tMovimentacaoVeiculo = new Thread(new MovimentacaoVeiculos(c));
				tMovimentacaoVeiculo.start();
			} 

			Thread t = new Thread(new Posto(carros));
			t.start();
			Thread pintura = new Thread(new Runnable() {

				@Override
				public void run() {
					while(true){
						jPanel2.repaint();
						try {
							Thread.sleep(1000);
			
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
						
					
				}
				
			});
			pintura.start();

			
			
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			for (Car c : carros) {
				c.draw(g);
			}
		}
	}
}
