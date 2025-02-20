import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Station station1 = new Station("Центральная", "ул. Ленина, 1", "2025-01-11 15:30:00");
        Station station2 = new Station("Вокзал", "пр. Независимости, 45", "2025-01-11 16:00:00");
        Station station3 = new Station("Площадь", "пл. Победы, 7", "2025-01-11 17:00:00");

        Route route1 = new Route("Маршрут 101");
        route1.addStation(station1);
        route1.addStation(station2);
        route1.addStation(station3);

        Bus bus1 = new Bus("A1", 2, "2025-01-11T14:00:00");
        Bus bus2 = new Bus("B2", 3, "2025-01-11T14:30:00");

        station1.addBus(bus1);
        station2.addBus(bus2);

        PassengerAction action = passenger -> {
            System.out.println("Пассажир " + passenger + " заходит в автобус.");
            return "Пассажир " + passenger + " принят";
        };

        Stack<String> passengerStack1 = new MyStack<>();
        passengerStack1.push("Иван");
        passengerStack1.push("Мария");
        passengerStack1.push("Анна");

        System.out.println("\nИнформация о первом автобусе:");
        while (!passengerStack1.empty()) {
            String passenger = passengerStack1.pop();
            try {
                bus1.boardPassenger(passenger, action);
            } catch (BusOvercapacityException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("\nИнформация о станции 1:");
        System.out.println(station1.getArrivalTimeInfo());
        System.out.println(station1.getTimeUntilArrival());
        System.out.println("Дней до прибытия на станцию 1: " + station1.getDaysUntilArrival());
        System.out.println(station1.getPeriodUntilArrival());
        System.out.println(bus1.getTripDuration());

        System.out.println("\nИнформация о втором автобусе:");
        Stack<String> passengerStack2 = new MyStack<>();
        passengerStack2.push("Петр");
        passengerStack2.push("Ольга");
        passengerStack2.push("Сергей");

        while (!passengerStack2.empty()) {
            String passenger = passengerStack2.pop();
            try {
                bus2.boardPassenger(passenger, action);
            } catch (BusOvercapacityException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("\nИнформация о станции 2:");
        System.out.println(station2.getArrivalTimeInfo());
        System.out.println(station2.getTimeUntilArrival());
        System.out.println("Дней до прибытия на станцию 2: " + station2.getDaysUntilArrival());
        System.out.println(station2.getPeriodUntilArrival());
        System.out.println(bus2.getTripDuration());

        System.out.println("\nИнформация о маршруте:");
        System.out.println(route1.getRouteInfo());

        Bus busDuplicate = new Bus("A1", 2, "2025-01-11T14:00:00");

        System.out.println("\nПроверка equals() между bus1 и busDuplicate: " + bus1.equals(busDuplicate));
        System.out.println("Проверка equals() между bus1 и bus2: " + bus1.equals(bus2));

        Set<Bus> busSet = new HashSet<>();
        busSet.add(bus1);
        busSet.add(busDuplicate);
        busSet.add(bus2);

        System.out.println("Количество уникальных автобусов в HashSet: " + busSet.size());
    }
}
