package workshops.smartcitytransportservices;

import java.util.*;

public class MainEmergency {
    public static void main(String[] args) {
        List<TransportService> services = Arrays.asList(
            new BusService("City Bus", 15.0, "10:00 AM - 10:00 PM"),
            new MetroService("Metro Line 1", 25.0, "6:00 AM - 11:00 PM"),
            new TaxiService("City Taxi", 50.0, "24/7"),
            new AmbulanceService("City Ambulance", 0.0, "24/7")
        );

        for (TransportService service : services) {
            // Check if service is an emergency (marker interface)
            if (service instanceof EmergencyService) {
                System.out.println("🚨 Emergency Service Detected: " + service.getServiceName());
            } else {
                System.out.println("Normal Service: " + service.getServiceName());
            }
        }
    }
}

