package designPatern.strategy;

/**
 * Created by fazhao on 16/9/19.
 */
public class MallardDuck extends Duck {
    @Override
    void display() {
        System.out.println("Mallard duck");
    }
    public MallardDuck(){
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }
}
