class LegacyAPI {
    @Deprecated
    public void oldFeature() {
        System.out.println("This old feature is deprecated and should not be used.");
    }

    public void newFeature() {
        System.out.println("This is the new and improved feature.");
    }
}

public class LegacyAPIDemo {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        api.oldFeature();
        api.newFeature();
    }
}