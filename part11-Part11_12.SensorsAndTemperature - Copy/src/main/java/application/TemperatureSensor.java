package application;

import java.util.Random;

public class TemperatureSensor implements Sensor{
    private boolean currentlyOn;
    private Random rand;

    public TemperatureSensor() {
        this.currentlyOn = false;
        this.rand = new Random();
    }

    @Override
    public boolean isOn() {
        return this.currentlyOn;
    }

    @Override
    public int read() {
        if (!this.currentlyOn) {
            throw new IllegalStateException("Sensor must be on before reading!");
        }        
        int reading = rand.nextInt(61)-30;
        return reading;
    }

    @Override
    public void setOff() {
        this.currentlyOn = false;
    }

    @Override
    public void setOn() {
        this.currentlyOn = true;
    }


}
