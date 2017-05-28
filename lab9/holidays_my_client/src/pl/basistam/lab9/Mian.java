package pl.basistam.lab9;

public class Mian {
    public static void main(String[] args) {
        new RequestSender().send(new HolidaysService());
    }
}
