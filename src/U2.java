public class U2 extends Rocket {

    U2() {
        this.cost = 120000000;
        this.weight = 18000;
        this.weightLimit = 29000;
    }

    public boolean launch() {
        return Math.random() >= 0.04 * (weight / weightLimit);
    }

    public boolean land() {
        return Math.random() >= 0.08 * (weight / weightLimit);
    }
}
