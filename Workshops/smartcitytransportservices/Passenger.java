package workshops.smartcitytransportservices;

class Passenger {
    private String name;
    private String route;
    private double farePaid;
    private boolean peakTime;

    public Passenger(String name, String route, double farePaid, boolean peakTime) {
        this.name = name;
        this.route = route;
        this.farePaid = farePaid;
        this.peakTime = peakTime;
    }

    public String getName() { return name; }
    public String getRoute() { return route; }
    public double getFarePaid() { return farePaid; }
    public boolean isPeakTime() { return peakTime; }
}

