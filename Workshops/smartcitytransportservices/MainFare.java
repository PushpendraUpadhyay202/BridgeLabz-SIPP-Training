package workshops.smartcitytransportservices;

public class MainFare {
    public static void main(String[] args) {
        double distance = 10.0; // 10 km trip

        //Flat fare (base fare only)
        FareCalculator flatFare = (base, dist) -> base;

        //Per km fare
        FareCalculator perKmFare = (base, dist) -> base + (dist * 2);

        //Surge pricing fare
        FareCalculator surgeFare = (base, dist) -> (base + (dist * 2)) * 1.5;

        System.out.println("Flat Fare: " + flatFare.calculateFare(20.0, distance));
        System.out.println("Per Km Fare: " + perKmFare.calculateFare(20.0, distance));
        System.out.println("Surge Fare: " + surgeFare.calculateFare(20.0, distance));
    }
}

