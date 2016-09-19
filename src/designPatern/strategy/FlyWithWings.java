package designPatern.strategy;

/**
 * Created by fazhao on 16/9/19.
 */
public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("fly with wings");
    }
}
