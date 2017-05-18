package pl.basistam.cars;

public enum CarType {
    SPORT, LUXURY, STANDARD;

    public static CarType parse(String type) {
        type = type.toUpperCase();
        if ("LUXURY".equals(type))
        {
            return LUXURY;
        }
        else if ("SPORT".equals(type))
        {
            return SPORT;
        }
        else
        {
            return STANDARD;
        }
    }
}
