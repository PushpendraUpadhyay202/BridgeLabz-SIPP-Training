package workshops.smartcitytransportservices;

import java.util.*;
import java.util.stream.*;
import java.util.DoubleSummaryStatistics;

public class MainCollectors {
    public static void main(String[] args) {
        List<Passenger> passengers = Arrays.asList(
            new Passenger("Alice", "Route A", 15.0, true),
            new Passenger("Bob", "Route B", 25.0, false),
            new Passenger("Charlie", "Route A", 15.0, true),
            new Passenger("David", "Route C", 50.0, true),
            new Passenger("Eva", "Route B", 25.0, false)
        );

        //Group passengers by route
        Map<String, List<Passenger>> byRoute = passengers.stream()
            .collect(Collectors.groupingBy(Passenger::getRoute));

        System.out.println("Passengers grouped by route:");
        byRoute.forEach((route, list) -> {
            System.out.println(route + " -> " + list.size() + " passengers");
        });

        //Partition passengers: Peak vs Non-Peak
        Map<Boolean, List<Passenger>> peakPartition = passengers.stream()
            .collect(Collectors.partitioningBy(Passenger::isPeakTime));

        System.out.println("\nPartitioned by Peak Time:");
        System.out.println("Peak: " + peakPartition.get(true).size());
        System.out.println("Non-Peak: " + peakPartition.get(false).size());

        //Summarize fares (total, average, min, max)
        DoubleSummaryStatistics fareStats = passengers.stream()
            .collect(Collectors.summarizingDouble(Passenger::getFarePaid));

        System.out.println("\nFare Summary:");
        System.out.println("Total Revenue: " + fareStats.getSum());
        System.out.println("Average Fare: " + fareStats.getAverage());
        System.out.println("Min Fare: " + fareStats.getMin());
        System.out.println("Max Fare: " + fareStats.getMax());
    }
}

