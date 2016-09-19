package designPatern.observer;

/**
 * Created by fazhao on 16/9/19.
 */
public class CurrentConditionDisplay implements Observer,DisplayElement {
    private float temp;
    private float hum;
    private Subject weatherData;

    public CurrentConditionDisplay(Subject weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.hum = hum;
        display();
    }

    @Override
    public void display() {
        System.out.println("Current condition:temp:"+temp+"and humidity:"+hum);
    }
}
