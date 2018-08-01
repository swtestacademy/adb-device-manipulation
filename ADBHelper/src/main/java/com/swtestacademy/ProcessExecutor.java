package com.swtestacademy;

import com.testinium.deviceinformation.helper.ProcessHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcessExecutor {


    public static void exec(String deviceId,String command) throws IOException {


        Process process = null;
        String commandString;
        if(deviceId != null) {
            commandString = String.format("%s", "adb -s " + deviceId + " shell " + command);
        }else
            commandString = String.format("%s", "adb shell " + command);

        System.out.print("Command is "+commandString+"\n");
        try {
            process = ProcessHelper.runTimeExec(commandString);
        } catch (IOException e) {
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.print(line+"\n");
        }
    }

}
