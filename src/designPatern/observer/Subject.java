package designPatern.observer;



/**
 * Created by fazhao on 16/9/19.
 */
public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObersers();
}
