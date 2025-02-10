package top.fireworkrocket.sleepyjava;

public enum Color {

    awake("awake"),
    asleep("sleeping");

    private final String color;

    Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
