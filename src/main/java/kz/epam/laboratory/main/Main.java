package kz.epam.laboratory.main;


import kz.epam.laboratory.seaports.Seaport;

public class Main {

    public static void main(String[] args) {
        Seaport port = new Seaport();
        port.startWorking();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
