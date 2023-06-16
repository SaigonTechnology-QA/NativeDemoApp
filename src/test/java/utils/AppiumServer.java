package utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;

public class AppiumServer {
    public static void startServer(){
        getInstance().start();
    }
    static AppiumDriverLocalService getInstance(){
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");
        builder.withAppiumJS(new File("C:\\Users\\thich.nguyen\\AppData\\Roaming\\npm\\node_modules\\appium"))
                .usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
                .usingPort(4723);
        // .usingPort(4723).withLogFile(new File("AppiumLog.txt"));
        return AppiumDriverLocalService.buildService(builder);
    }
}
