package com.company.ejercicio3;

public class Ejercicio3 {

    public static int variableComun=0;
    public static boolean operar =true;


    public static void main(String[] args) throws InterruptedException {

        Suma suma1 = new Suma();
        Suma suma2 = new Suma();
        Suma suma3 = new Suma();
        Resta resta1 = new Resta();
        Resta resta2 = new Resta();

        suma1.start();
        suma1.join();
        suma2.start();
        suma2.join();
        suma3.start();
        suma3.join();
        resta1.start();
        resta2.start();

    }

    public static class Suma extends Thread{
        @Override
        public synchronized void run() {
            while (variableComun>=3 || !operar){
                try {
                    System.out.println("Fio suma, entra na cola, os estados das varaibles son : variableComun = "+variableComun+" operar = "+operar);
                    wait();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
            // Me aseguro de que a variable este a false cando sumo para que non acceda a variable en común outro fio
            operar=false;
            variableComun +=1;
            System.out.println("Sumo 1 a varible en común, resultado :"+variableComun);
            // Fago accesible a variable outra vez
            operar=true;

            notify();
        }
    }
    public static class  Resta extends Thread{
        @Override
        public synchronized void run() {
            while (variableComun<1 || !operar){
                try {
                    System.out.println("Fio resta, entra na cola, os estados das varaibles son : variableComun "+variableComun+" operar "+operar);
                    wait();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
            // Me aseguro de que a variable este a false cando sumo para que non acceda a variable en común outro fio
            operar=false;
            variableComun -=1;
            System.out.println("Resto 1 a varible en común, resultado:"+variableComun);
            // Fago accesible a variable outra vez
            operar=true;
            notify();
        }
    }
}
