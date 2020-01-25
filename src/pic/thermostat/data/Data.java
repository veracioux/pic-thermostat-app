package pic.thermostat.data;

import com.sun.jdi.AbsentInformationException;

public class Data {

    private volatile static short temperature;
    private volatile static short deviceTime;
    private volatile static byte startDay, endDay;
    private volatile static short on, off;
    private volatile static short min, max;
    private volatile static Program[] programs;

    public static short getTemperatureRaw() {
        return temperature;
    }

    public static void setTemperatureRaw(short temp) {
        temperature = temp;
    }

    public static float getTemperature() {
        return (float) (temperature * 5.0 / 1024);
    }

    public static void setTemperature(float temp) {
        //TODO temperature = temp;
    }

    public static void setDeviceTime(short time) {
        deviceTime = time;
    }

    public static byte[] serializeTemperature() {
        return new byte[]{(byte) temperature, (byte) (temperature >> 8)};
    }

    public static short deserializeTemperature(byte[] data) throws AbsentInformationException {
        if (data.length < 2)
            throw new AbsentInformationException("Temperature data is incomplete");
        return (short) (data[0] + ((short) data[1] << 8));
    }

}