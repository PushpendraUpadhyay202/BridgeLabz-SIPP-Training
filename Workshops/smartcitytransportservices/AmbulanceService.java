package workshops.smartcitytransportservices;

class AmbulanceService implements TransportService, EmergencyService {
    private String serviceName;
    private double fare;
    private String schedule;

    public AmbulanceService(String serviceName, double fare, String schedule) {
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

