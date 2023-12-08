package fly;

public class NoFly implements Flyable{
    @Override
    public void fly() {
        // do nothing
        System.out.println("날 수 없습니다!");
    }
}
