package top.fireworkrocket.sleepyjava.jsontree.compatibility;

import top.fireworkrocket.sleepyjava.devices.DeviceInterface;

import java.util.Map;

public class SleepResponse {
    private static String time;  // 时间
    private static boolean success;  // 本次请求是否成功
    private static int status;  // 状态
    private static Info info;  // 信息
    private static Map<String, DeviceInterface> device; // 设备
    private static int device_status_slice; // 设备状态切片
    private static String last_updated; // 最后更新时间
    private static int refresh; // 刷新时间

    public SleepResponse(String time, boolean success, int status, Info info, Map<String, DeviceInterface> device, int device_status_slice, String last_updated, int refresh) {
        SleepResponse.time = time;
        SleepResponse.success = success;
        SleepResponse.status = status;
        SleepResponse.info = info;
        SleepResponse.device = device;
        SleepResponse.device_status_slice = device_status_slice;
        SleepResponse.last_updated = last_updated;
        SleepResponse.refresh = refresh;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        SleepResponse.time = time;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        SleepResponse.success = success;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        SleepResponse.status = status;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        SleepResponse.info = info;
    }

    public Map<String, DeviceInterface> getDevice() {
        return device;
    }

    public void setDevice(Map<String, DeviceInterface> device) {
        SleepResponse.device = device;
    }

    public int getDevice_status_slice() {
        return device_status_slice;
    }

    public void setDevice_status_slice(int device_status_slice) {
        SleepResponse.device_status_slice = device_status_slice;
    }

    public String getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(String last_updated) {
        SleepResponse.last_updated = last_updated;
    }

    public int getRefresh() {
        return refresh;
    }

    public void setRefresh(int refresh) {
        SleepResponse.refresh = refresh;
    }
}