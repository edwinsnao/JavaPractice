package designPatern.strategy;

/**
 * Created by fazhao on 16/9/19.
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I can't fly");
    }
}
