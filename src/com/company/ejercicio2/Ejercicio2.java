package com.company.ejercicio2;


public class Ejercicio2 {

    public static void main(String[] args) throws InterruptedException {

        Hilo hilo1 = new Hilo("Hilo 1");
        Hilo hilo2 = new Hilo("Hilo 2");
        Hilo hilo3 = new Hilo("Hilo 3");

        // Utilizo join para asegurame que o fio 1 non se execute ata que o fio 2 haxa rematado e o fio 2 non se execute ata que o fio3 haxa rematado

        hilo3.start();
        hilo3.join();
        hilo2.start();
        hilo2.join();
        hilo1.start();
        hilo1.join();

        System.out.println("O programa principal remata");
    }

    public static class Hilo extends Thread{
        public Hilo(String name) {
            super(name);
        }

        @Override
        public void run() {
            // Búcle que escribe oito veces o nome do fio e a iteración correspondente
            for (int i=0; i<8;i++){
                System.out.println("Número iteración : " +i+" Nome do fío : "+getName() );
                // Despois de escribir o nome o fio se dorme duurante un tempo e logo volve a estar dispoñible
                try {
                    Thread.sleep((long) (Math.random()*50));
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
