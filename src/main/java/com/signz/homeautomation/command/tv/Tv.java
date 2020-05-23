package com.signz.homeautomation.command.tv;

public class Tv {

    public enum SupportedCommands {
        TURN_ON,
        TURN_OFF,
        CHANGE_CHANNEL,
        CHANGE_VOLUME
    }

    String turnOnTv() {
        return "turning ON tv !!!";
    }

    String turnOffTv() {
        return "turning OFF tv !!!";
    }

    String changeChannel() {
        return "TV Channel Changed !!!";
    }

    String changeVolume() {
        return "TV Volume Changed !!!";
    }
}
