package top.fireworkrocket.sleepyjava.jsontree.compatibility;

import top.fireworkrocket.sleepyjava.devices.DeviceInterface;

public class Device implements DeviceInterface {
    private String show_name;
    private boolean using;
    private String app_name;

    public Device(String show_name, boolean using, String app_name) {
        this.show_name = show_name;
        this.using = using;
        this.app_name = app_name;
    }

    @Override
    public String getShowName() {
        return show_name;
    }

    public void setShowName(String show_name) {
        this.show_name = show_name;
    }

    @Override
    public boolean isUsing() {
        return using;
    }

    public void setUsing(boolean using) {
        this.using = using;
    }

    @Override
    public String getAppName() {
        return app_name;
    }

    public void setAppName(String app_name) {
        this.app_name = app_name;
    }
}