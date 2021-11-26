package com.company.ejercicio1;

public class Ejercicio1 {

    public static void main(String[] args)  {

        Hilo hilo1 = new Hilo("Hilo 1");
        Hilo hilo2 = new Hilo("Hilo 2");
        Hilo hilo3 = new Hilo("Hilo 3");


        hilo1.start();

        hilo2.start();

        hilo3.start();


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
