package designPatern.strategy;

/**
 * Created by fazhao on 16/9/19.
 */
public class RedheadDuck extends Duck {
    @Override
    void display() {
        System.out.println("ReadheadDuck");
    }
    public RedheadDuck(){
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }
}
