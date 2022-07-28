package br.com.academy.threads.src.model;

import java.awt.Color;


public abstract class Veiculos{

    protected int x;
	protected int y;
	protected Color color;
	protected int combustivelCarro;
	protected int numeroDeChassi;

    public Veiculos(int x, int y, int combustivelCarro, Color color, int numeroDeChassi) {
		this.x = x;
		this.y = y;
		this.combustivelCarro = combustivelCarro;
		this.color = color;
        this.numeroDeChassi = numeroDeChassi; 
    } 
   

    public int getCombustivelCarro() {
		return combustivelCarro;
	}

	public void setCombustivelCarro(int combustivelCarro) {
		this.combustivelCarro = combustivelCarro;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Color getColor() {
		return color;
	}

	public int getNumeroDeChassi() {
		return numeroDeChassi;
	}

	public void setNumeroDeChassi(int id) {
		this.numeroDeChassi = id;
	}

}