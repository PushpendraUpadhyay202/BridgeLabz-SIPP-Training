package workshops.smartcitytransportservices;

public class BusService implements TransportService{
    private String serviceName;
    private double fare;
    private String schedule;

    public BusService(String serviceName, double fare, String schedule) {
        this.serviceName = serviceName;
        this.fare = fare;
        this.schedule = schedule;
    }

    @Override
    public String getServiceName() { return serviceName; }

    @Override
    public double getFare() { return fare; }

    @Override
    public String getSchedule() { return schedule; }
}
