package designPatern.strategy;

/**
 * Created by fazhao on 16/9/19.
 */
public class RubberDuck extends Duck {
    @Override
    void display() {
        System.out.println("runbber duck");
    }
    public RubberDuck(){
        flyBehavior = new FlyNoWay();
        quackBehavior = new Squeak();
    }
}
