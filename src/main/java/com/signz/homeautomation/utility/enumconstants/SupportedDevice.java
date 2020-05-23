package com.signz.homeautomation.utility.enumconstants;

import com.signz.homeautomation.exception.DeviceNotFoundException;

public enum SupportedDevice {
    FAN("fan"), LIGHT("light"), TV("light");

    String value;

    SupportedDevice(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public SupportedDevice tt(String v) {
        System.out.println(SupportedDevice.valueOf(v));
        return SupportedDevice.valueOf(v);
    }

    public static SupportedDevice getDeviceByValue(String value) {
        for (SupportedDevice v : values()) {
            if (v.getValue().equalsIgnoreCase(value)) {
                return v;
            }
        }
        throw new DeviceNotFoundException("Unsupported Device");
    }

}


