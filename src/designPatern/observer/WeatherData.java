package designPatern.observer;

import java.util.ArrayList;

/**
 * Created by fazhao on 16/9/19.
 */
public class WeatherData implements Subject{
    private ArrayList observers;
    private float temp;
    private float hum;
    private float press;

    public WeatherData(){
        observers = new ArrayList();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getHum() {
        return hum;
    }

    public void setHum(float hum) {
        this.hum = hum;
    }

    public float getPress() {
        return press;
    }

    public void setPress(float press) {
        this.press = press;
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if(i >= 0)
            observers.remove(i);

    }

    @Override
    public void notifyObersers() {
        for (int i = 0; i < observers.size() ; i++) {
            Observer o = (Observer) observers.get(i);
            o.update(temp,hum,press);
        }
    }
    public void measurementsChanged(){
        notifyObersers();
    }
    public void setMeasurements(float temp,float hum,float press){
        this.temp = temp;
        this.hum = hum;
        this.press = press;
        measurementsChanged();;
    }
}
