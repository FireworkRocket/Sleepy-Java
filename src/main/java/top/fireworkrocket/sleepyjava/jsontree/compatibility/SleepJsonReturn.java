package top.fireworkrocket.sleepyjava.jsontree.compatibility;

public class SleepJsonReturn {
    private static String message;
    private static int status;

    public SleepJsonReturn(String message, int status) {
        SleepJsonReturn.message = message;
        SleepJsonReturn.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        SleepJsonReturn.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        SleepJsonReturn.status = status;
    }
}