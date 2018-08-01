package com.swtestacademy.commands;

import com.swtestacademy.ProcessExecutor;
import com.swtestacademy.enums.BatteryLevelEnum;
import com.swtestacademy.enums.SwitchEnum;

import java.io.IOException;

public class BatteryCommand extends Command {

    private static final String batteryLevelCommand ="dumpsys battery set level %s";
    private static final String batteryStatusCommand ="dumpsys battery set status %s";
    private static final String batteryResetCommand ="dumpsys battery reset";
    private static final String batteryUSBCommand ="dumpsys battery set usb %s";


    public void setBatteryLevel(String level) throws IOException {

        ProcessExecutor.exec(getDeviceId(),String.format(batteryLevelCommand,level));
        System.out.print("Battery leve is set to "+level);
    }

    public void resetBattery() throws IOException {

        ProcessExecutor.exec(getDeviceId(),String.format(batteryResetCommand));
        System.out.print("Battery configuration is succesfully reset");
    }

    public void setBatteryStatus(BatteryLevelEnum level) throws IOException {
        String status = "";

            switch (level) {
                case Unknown:
                    status = "1";
                    break;
                case Charging:
                    status = "2";
                    break;
                case Discharging:
                    status = "3";
                    break;
                case NotCharging:
                    status = "4";
                    break;
                case Full:
                    status = "5";
                    break;
                default:
                    break;
            }
            ProcessExecutor.exec(getDeviceId(),String.format(batteryStatusCommand,status));
            System.out.print("Battery status is changed to "+status);
        }

    public void setUSB(SwitchEnum val) throws IOException {
        String status = "";

        switch (val) {
            case ON:
                status = "1";
                break;
            case OFF:
                status = "0";
                break;
            default:
                break;
        }
        ProcessExecutor.exec(getDeviceId(),String.format(batteryUSBCommand,status));
        System.out.print("Device USB state is "+status);
    }
}
