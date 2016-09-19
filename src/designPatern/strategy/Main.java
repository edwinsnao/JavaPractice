package designPatern.strategy;

/**
 * Created by fazhao on 16/9/19.
 */
public class Main {
    public static void main(String args[]) {
        Duck mallard = new MallardDuck();
        mallard.performFly();
        mallard.performQuack();

        Duck redhead = new RedheadDuck();
        redhead.performFly();
        redhead.performQuack();

        Duck rubber = new RubberDuck();
        rubber.performFly();
        rubber.performQuack();

        Duck decoy = new DecoyDuck();
        decoy.performFly();
        decoy.performQuack();


    }
}
