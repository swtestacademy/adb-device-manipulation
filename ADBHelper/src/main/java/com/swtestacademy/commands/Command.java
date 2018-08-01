package com.swtestacademy.commands;

public class Command {

    private String deviceId;

    public Command(){

    }

    public void setDeviceId(String deviceId){
        this.deviceId = deviceId;
    }

    public String getDeviceId(){

        return this.deviceId;
    }
}
