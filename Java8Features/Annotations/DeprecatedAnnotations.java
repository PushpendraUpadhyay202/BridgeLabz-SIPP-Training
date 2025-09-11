class LegacyAPI {
    @Deprecated
    public void oldFeature() {
        System.out.println("This is the old feature (deprecated).");
    }

    public void newFeature() {
        System.out.println("This is the new feature!");
    }
}

public class DeprecatedAnnotations {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        api.oldFeature();  
        api.newFeature();
    }
}
