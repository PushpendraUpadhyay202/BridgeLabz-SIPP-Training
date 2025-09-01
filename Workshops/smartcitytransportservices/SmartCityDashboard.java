package workshops.smartcitytransportservices;

import java.util.*;
import java.util.stream.Collectors;

public class SmartCityDashboard {
    public static void main(String[] args) {
        //Setup Services
        List<TransportService> services = Arrays.asList(
            new BusService("City Bus", 15.0, "10:00 AM - 10:00 PM"),
            new MetroService("Metro Line 1", 25.0, "6:00 AM - 11:00 PM"),
            new TaxiService("City Taxi", 50.0, "24/7"),
            new AmbulanceService("City Ambulance", 0.0, "24/7")
        );

        //Live Dashboard (forEach)
        System.out.println("=== Live Dashboard ===");
        services.forEach(TransportService::printServiceDetails);

        //Filtering with Lambda (cheap services <= 25)
        System.out.println("\n=== Cheap Services (<= 25) ===");
        services.stream()
            .filter(s -> s.getFare() <= 25)
            .forEach(s -> System.out.println(s.getServiceName()));

        //Sorting by Fare
        System.out.println("\n=== Services Sorted by Fare ===");
        services.stream()
            .sorted(Comparator.comparingDouble(TransportService::getFare))
            .forEach(s -> System.out.println(s.getServiceName() + " - " + s.getFare()));

        //Emergency Detection
        System.out.println("\n=== Emergency Services ===");
        services.stream()
            .filter(s -> s instanceof EmergencyService)
            .forEach(s -> System.out.println("🚨 " + s.getServiceName()));

        //Fare Calculation with Lambda
        FareCalculator perKmFare = (base, dist) -> base + (dist * 2);
        double fare = perKmFare.calculateFare(20, 10); // base=20, dist=10 km
        System.out.println("\nFare Calculation Example: " + fare);

        //Passenger Data + Collectors
        List<Passenger> passengers = Arrays.asList(
            new Passenger("Alice", "Route A", 15.0, true),
            new Passenger("Bob", "Route B", 25.0, false),
            new Passenger("Charlie", "Route A", 15.0, true),
            new Passenger("David", "Route C", 50.0, true),
            new Passenger("Eva", "Route B", 25.0, false)
        );

        System.out.println("\n=== Passengers Grouped by Route ===");
        Map<String, List<Passenger>> byRoute = passengers.stream()
            .collect(Collectors.groupingBy(Passenger::getRoute));
        byRoute.forEach((route, list) -> 
            System.out.println(route + " -> " + list.size() + " passengers"));

        System.out.println("\n=== Peak vs Non-Peak ===");
        Map<Boolean, List<Passenger>> partition = passengers.stream()
            .collect(Collectors.partitioningBy(Passenger::isPeakTime));
        System.out.println("Peak: " + partition.get(true).size());
        System.out.println("Non-Peak: " + partition.get(false).size());

        System.out.println("\n=== Fare Summary ===");
        DoubleSummaryStatistics stats = passengers.stream()
            .collect(Collectors.summarizingDouble(Passenger::getFarePaid));
        System.out.println("Total Revenue: " + stats.getSum());
        System.out.println("Average Fare: " + stats.getAverage());
        System.out.println("Min Fare: " + stats.getMin());
        System.out.println("Max Fare: " + stats.getMax());
    }
}