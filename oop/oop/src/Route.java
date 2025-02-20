import java.util.ArrayList;
import java.util.List;

public class Route {
    private String routeNumber;
    private List<Station> stations;

    public Route(String routeNumber) {
        this.routeNumber = routeNumber;
        this.stations = new ArrayList<>();
    }

    public void addStation(Station station) {
        if (station != null) {
            stations.add(station);
        } else {
            System.out.println("Ошибка: Невалидная станция!");
        }
    }

    public String getRouteInfo() {
        StringBuilder info = new StringBuilder("Маршрут " + routeNumber + ":");
        for (Station station : stations) {
            info.append("\n- ").append(station.getInfo());
        }
        return info.toString();
    }
}
