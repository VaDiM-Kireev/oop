import java.util.Objects;

public class Transport {
    protected String vehicleNumber;
    protected int capacity;
    protected TransportType type;

    public Transport(String vehicleNumber, int capacity, TransportType type) {
        if (vehicleNumber == null || vehicleNumber.isEmpty()) {
            throw new InvalidTransportException("Ошибка: номер транспорта не может быть пустым!");
        }
        if (capacity <= 0) {
            throw new InvalidTransportException("Ошибка: вместимость транспорта должна быть больше 0!");
        }
        this.vehicleNumber = vehicleNumber;
        this.capacity = capacity;
        this.type = type;
    }

    public void boardPassenger(String passenger) {
        System.out.println("Метод boardPassenger не реализован для " + vehicleNumber);
    }

    public String getVehicleInfo() {
        return "Транспорт: " + vehicleNumber + ", Тип: " + type.getName() + ", Вместимость: " + capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return capacity == transport.capacity && Objects.equals(vehicleNumber, transport.vehicleNumber) && type == transport.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleNumber, capacity, type);
    }
}
