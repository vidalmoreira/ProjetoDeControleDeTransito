package br.com.academy.threads.src.service;

import br.com.academy.threads.src.model.Car;

public class MovimentacaoVeiculos implements Runnable{
    private Car carros; 

    
    public MovimentacaoVeiculos(Car carros){
        this.carros = carros; 
    }

    @Override
	public void run() {
		while (true) {
			try {
				carros.mover();
				Thread.sleep(1000);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
   
        
    
    
}
