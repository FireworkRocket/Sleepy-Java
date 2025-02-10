package top.fireworkrocket.sleepyjava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.fireworkrocket.sleepyjava.default_config.CopyWriting;
import top.fireworkrocket.sleepyjava.default_config.Value;
import top.fireworkrocket.sleepyjava.devices.DeviceInterface;
import top.fireworkrocket.sleepyjava.jsontree.compatibility.Info;
import top.fireworkrocket.sleepyjava.jsontree.compatibility.SleepResponse;

import java.lang.String;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("")
public class ApiController {

    @Autowired
    private ApplicationContext context;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @GetMapping("/query")
    public SleepResponse sleep() {
        Calendar cal = Calendar.getInstance();

        Info info = new Info(0,
                Value.WAKE_UP ? CopyWriting.iAmAwake : CopyWriting.iAmSleepy,
                Value.WAKE_UP ? CopyWriting.dESC: CopyWriting.dESCSleepy,
                Color.awake.getColor());

        // 动态加载所有DeviceInterface的实现类
        Map<java.lang.String, DeviceInterface> devices = context.getBeansOfType(DeviceInterface.class);
        Map<String, DeviceInterface> device = new HashMap<>(devices);

        return new SleepResponse(sdf.format(cal.getTime()), true, 0, info, device, 30, sdf.format(cal.getTime()),
                Integer.parseInt(CopyWriting.refreshTime));
    }

    @PostMapping("/upload")
    public SleepResponse upload(@RequestBody SleepResponse request) {
        SleepResponse sleepResponse = sleep();
        if (!request.equals(sleepResponse)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Upload failed");
        }
        return request;
    }
}