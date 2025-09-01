package workshops.smartcitytransportservices;

public interface TransportService {
    String getServiceName();
    double getFare();
    String getSchedule();

    default void printServiceDetails() {
        System.out.println("Service: " + getServiceName());
        System.out.println("Fare: " + getFare());
        System.out.println("Schedule: " + getSchedule());
    }
}
