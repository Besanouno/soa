package pl.basistam.soa.parkometr;


public class Main {
    public static void main(String[] args)   {
        Parkometr parkometr = new Parkometr();
        while(true) {
            parkometr.buyTicket();
        }
    }
}
