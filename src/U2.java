public class U2 extends Rocket {

    U2(int weightLimit) {
        this.cost = 120000000;
        this.weight = 18;
        this.weightLimit = 29;
    }

    public boolean launch() {
        return Math.random() >= 0.04 * (weight / weightLimit);
    }

    public boolean land() {
        return Math.random() >= 0.08 * (weight / weightLimit);
    }
}
