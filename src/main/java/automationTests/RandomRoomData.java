package automationTests;

public class RandomRoomData {
    public String roomType() {
        int markerTypes = newRandomInt() % 5;
        return switch (markerTypes) {
            case 1 -> "Twin";
            case 2 -> "Double";
            case 3 -> "Family";
            case 4 -> "Suite";
            default -> "Single";
        };
    }

    public Boolean hasMarker() {
        return (newRandomInt() % 2) == 0;
    }

    private int newRandomInt() {
        return (int) (Math.random()*100);

    }

}
