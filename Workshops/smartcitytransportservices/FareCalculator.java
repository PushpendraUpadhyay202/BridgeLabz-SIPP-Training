package workshops.smartcitytransportservices;

@FunctionalInterface
interface FareCalculator {
    double calculateFare(double baseFare, double distance);
}
