package com.signz.homeautomation.utility.enumconstants;

public enum SUPPORTED_DEVICE {
    FAN("fan"), LIGHT("light");

    String value;

    SUPPORTED_DEVICE(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static SUPPORTED_DEVICE getEnum(String value) {
        return SUPPORTED_DEVICE.valueOf(value);
    }
}


