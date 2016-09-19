package designPatern.strategy;

/**
 * Created by fazhao on 16/9/19.
 */
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Quack");
    }
}
