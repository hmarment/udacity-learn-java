public class Rocket implements SpaceShip {

    int cost;
    int weight;
    int weightLimit;

    Rocket() {

    }

    Rocket(int weightLimit) {
        this.cost = 0;
        this.weight = 0;
        this.weightLimit = weightLimit;
    }

    public boolean launch() {
        return true;
    }

    public boolean land() {
        return true;
    }

    public boolean canCarry(Item item) {
        return (weight + item.getWeight()) > weightLimit;
    }

    public void carry(Item item) {
        weight += item.getWeight();
    }
}
