package com.swtestacademy;

import com.swtestacademy.commands.BatteryCommand;
import com.testinium.deviceinformation.DeviceInfo;
import com.testinium.deviceinformation.DeviceInfoImpl;
import com.testinium.deviceinformation.device.DeviceType;
import com.testinium.deviceinformation.exception.DeviceNotFoundException;
import com.testinium.deviceinformation.model.Device;
import com.swtestacademy.enums.BatteryLevelEnum;
import com.swtestacademy.enums.SwitchEnum;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class AppTest {
    Device device;

    @Before
    public void before() throws IOException, DeviceNotFoundException {
        DeviceInfo deviceInfo = new DeviceInfoImpl(DeviceType.ANDROID);
         device = deviceInfo.getFirstDevice();
         System.out.print("Your device's ID is "+ device.getUniqueDeviceID());
    }

    @Test
    public void testBattery() throws IOException, InterruptedException {


        Thread.sleep(15000);

        BatteryCommand command = new BatteryCommand();
        command.setDeviceId(device.getUniqueDeviceID());
        command.setBatteryLevel("5");
        command.setBatteryStatus(BatteryLevelEnum.NotCharging);
        command.setUSB(SwitchEnum.OFF);
        Thread.sleep(2000);

        command.resetBattery();
    }

}
