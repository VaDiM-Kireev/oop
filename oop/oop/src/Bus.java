import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.time.LocalDateTime;
import java.time.Duration;

public class Bus extends Transport {
    private List<String> passengers;
    private LocalDateTime departureTime;

    public Bus(String vehicleNumber, int capacity, String departureTimeStr) {
        super(vehicleNumber, capacity, TransportType.BUS);
        this.passengers = new ArrayList<>();
        this.departureTime = LocalDateTime.parse(departureTimeStr);
    }

    public void boardPassenger(String passenger, PassengerAction action) {
        if (passengers.size() < capacity) {
            action.execute(passenger);
            passengers.add(passenger);
            System.out.println("Пассажир " + passenger + " успешно сел в автобус " + vehicleNumber + ".");
        } else {
            throw new BusOvercapacityException("Автобус " + vehicleNumber + " переполнен! Пассажир " + passenger + " не может сесть.");
        }
    }

    @Override
    public String getVehicleInfo() {
        return super.getVehicleInfo() + ", Пассажиры: " + passengers.size();
    }

    public String getTripDuration() {
        Duration duration = Duration.between(departureTime, LocalDateTime.now());
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;
        return "Продолжительность поездки: " + hours + " часов и " + minutes + " минут.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bus)) return false;
        if (!super.equals(o)) return false;
        Bus bus = (Bus) o;
        return Objects.equals(passengers, bus.passengers) &&
                Objects.equals(departureTime, bus.departureTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), passengers, departureTime);
    }
}
