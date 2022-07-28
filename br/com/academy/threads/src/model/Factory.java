package br.com.academy.threads.src.model;

public class Factory {
    private int combustivelFabrica;
    private static Factory factory;

    public Factory(int combustivelFabrica) {
        this.combustivelFabrica = combustivelFabrica;

    }

    public void abastecerCar(Car carros) {

        synchronized (this) {
            if (getCombustivel() >= 50) {
                carros.setCombustivelCarro(20);
                setCombustivel(getCombustivel() - (20 - 50));
            } else {
                System.out.println("Aguarde, já atenderemos o seu veículo");
            }
        }
    }

    public int getCombustivel() {
        return combustivelFabrica;
    }

    public void setCombustivel(int combustivelFabrica) {
        this.combustivelFabrica = combustivelFabrica;
    }

    public void supplyFactory() {
        this.combustivelFabrica = combustivelFabrica + 50;
    }

    public static Factory getFactory(){
        
        if(factory !=  null){
            return factory;
        }else{
            factory = new Factory(50);
            return factory;
        }
    }

}