public class Rocket implements SpaceShip {

    int currentWeight;
    int weightLimit;


    Rocket(int weightLimit) {
        this.currentWeight = 0;
        this.weightLimit = weightLimit;
    }

    public boolean launch() {
        return true;
    }

    public boolean land() {
        return true;
    }

    public boolean canCarry(Item item) {
        return (currentWeight + item.getWeight()) > weightLimit;
    }

    public void carry(Item item) {
        currentWeight += item.getWeight();
    }
}
