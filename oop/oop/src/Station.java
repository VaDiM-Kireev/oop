import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Station {
    private String name;
    private String address;
    private static String month;
    private LocalDateTime arrivalTime;
    private List<Bus> buses;

    static {
        month = "Сентябрь";
    }

    public Station(String name, String address, String arrivalTimeStr) {
        if (name == null || name.isEmpty()) {
            System.out.println("Ошибка: название станции не может быть пустым!");
            this.name = "Неизвестная станция";
        } else {
            this.name = name;
        }

        this.address = (address != null && !address.isEmpty()) ? address : "Адрес не указан";
        this.buses = new ArrayList<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.arrivalTime = LocalDateTime.parse(arrivalTimeStr, formatter);
    }

    public void addBus(Bus bus) {
        buses.add(bus);
    }

    public List<Bus> getBuses() {
        return buses;
    }

    public String getInfo() {
        return "Станция: " + name + " (Адрес: " + address + ")";
    }

    public String getTimeUntilArrival() {
        Duration duration = Duration.between(LocalDateTime.now(), arrivalTime);
        return "До прибытия автобуса " + duration.toHours() + " часов и " + duration.toMinutesPart() + " минут.";
    }

    public String getArrivalTimeInfo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm:ss");
        return "Время прибытия: " + arrivalTime.format(formatter);
    }

    public long getDaysUntilArrival() {
        return Duration.between(LocalDateTime.now(), arrivalTime).toDays();
    }

    public String getPeriodUntilArrival() {
        Period period = Period.between(LocalDateTime.now().toLocalDate(), arrivalTime.toLocalDate());
        return "До прибытия автобуса: " + period.getYears() + " лет, " + period.getMonths() + " месяцев, " + period.getDays() + " дней.";
    }
}
