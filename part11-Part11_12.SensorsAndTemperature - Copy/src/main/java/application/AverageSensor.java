package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class AverageSensor implements Sensor {
    private List<Sensor> sensors;
    private List<Integer> readingHistory;

    public AverageSensor() {
        this.sensors = new ArrayList<>();
        this.readingHistory=new ArrayList<>();
    }

    public void addSensor(Sensor toAdd){
        this.sensors.add(toAdd);
    }

    public List<Integer> readings() {
        return this.readingHistory;
    }

    @Override
    public boolean isOn(){
        boolean status = true;
        for (Sensor sensor : sensors) {
            if (!sensor.isOn()) {
                status = false;
                break;
            }
        }
        return status;
    }

    @Override
    public int read() {
        if (!this.isOn()) {
            throw new IllegalStateException("AverageSensor must be on before reading!");
        }

        if (sensors.isEmpty()) {
            return 0;
        }

        int count=0;
        int sum =0;
        int avg=0;

        for (Sensor sensor:sensors) {
            count++;
            sum+=sensor.read();
        }
        avg = sum / count;
        //add this average to our readingHistory attribute
        this.readingHistory.add(avg);
        return avg;
        
    }

    @Override
    public void setOff() {
        sensors.stream().forEach(sen -> sen.setOff());
    }

    @Override
    public void setOn() {
        sensors.stream().forEach(sen -> sen.setOn());
    }
    


}
