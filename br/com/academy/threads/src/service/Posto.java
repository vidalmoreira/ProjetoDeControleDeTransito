package br.com.academy.threads.src.service;

import java.util.ArrayList;
import br.com.academy.threads.src.model.Car;
import br.com.academy.threads.src.model.Factory;

public class Posto implements Runnable{

    private ArrayList<Car> carros;

    public Posto(ArrayList<Car> carros){
        this.carros = carros;
    }

    

    @Override
    public void run() {
        while(true){
            for (Car carros : carros)        
                if(carros.getCombustivelCarro() <= 1){
                    try{
                        Factory.getFactory().abastecerCar(carros);
                        Thread.sleep(5000);
                        System.out.println("O carro: " + carros.getNumeroDeChassi() + " está com o tanque cheio");
                        
                     }catch (InterruptedException e) {
                    e.printStackTrace();
                }

        
                }   

            }
    }
}