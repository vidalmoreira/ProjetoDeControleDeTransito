package br.com.academy.threads.src.service;

import br.com.academy.threads.src.model.Factory;

public class SupplyFactory implements Runnable {


    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Iniciando suprimentos da fabrica");
                Factory.getFactory().supplyFactory();
                Thread.sleep(30000);
                System.out.println("Abastecimento concluido");
                System.out.println("Contém em estoque: " + Factory.getFactory().getCombustivel() + " litros de combustível.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
