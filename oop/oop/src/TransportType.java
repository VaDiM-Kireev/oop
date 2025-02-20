public enum TransportType {
    BUS("Автобус"),
    TROLLEYBUS("Троллейбус"),
    TRAM("Трамвай");

    private final String name;

    TransportType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
