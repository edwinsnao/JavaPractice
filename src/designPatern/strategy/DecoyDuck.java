package designPatern.strategy;

/**
 * Created by fazhao on 16/9/19.
 */
public class DecoyDuck extends Duck {
    @Override
    void display() {
        System.out.println("DecoyDuck");
    }
    public DecoyDuck(){
        setFlyBehavior(new FlyNoWay());
        setQuackBehavior(new MuteQuack());
    }
}
