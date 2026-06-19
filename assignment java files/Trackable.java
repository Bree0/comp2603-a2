/**
 * Trackable interface for animals that can have sighting logs.
 *
 */
public interface Trackable {
    void logSighting(String date, String location);
    int getSightingCount();
    String getLastSighting();
}
