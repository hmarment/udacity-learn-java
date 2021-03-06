
public class U1 extends Rocket {

    U1() {
        this.cost = 100000000;
        this.weight = 10000;
        this.weightLimit = 18000;
    }

    public boolean launch() {
        return Math.random() >= 0.05 * (weight / weightLimit);
    }

    public boolean land() {
        return Math.random() >= 0.01 * (weight / weightLimit);
    }
}
