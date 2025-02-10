package top.fireworkrocket.sleepyjava.jsontree.compatibility;

public class Info {
    private static int id;
    private static String name;
    private static String desc;
    private static String color;

    public Info(int id, String name, String desc, String color) {
        Info.id = id;
        Info.name = name;
        Info.desc = desc;
        Info.color = String.valueOf(color);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        Info.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Info.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        Info.desc = desc;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        Info.color = color;
    }
}