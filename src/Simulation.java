import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    private ArrayList<Item> loadItems(String filePath) {

        ArrayList<Item> items = new ArrayList<Item>();

        // Load from file
        File file = new File(filePath);
        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("=");
                items.add(new Item(parts[0], (int) Integer.parseInt(parts[1])));
            }

        } catch (Exception exception) {
            System.out.println("%s  -  Could not open %s".format(exception.toString(), filePath));
        }

        for (Item item : items)  {
            System.out.println();
        }

        return items;
    }

    private ArrayList<Rocket> loadU1(ArrayList<Item> items) {
        ArrayList<Rocket> u1Fleet = new ArrayList<Rocket>();

        U1 u1Rocket = new U1();
        for (Item item : items) {
            if (u1Rocket.canCarry(item)) {
                u1Rocket.carry(item);
            }
            else {
                u1Fleet.add(u1Rocket);
                u1Rocket = new U1();
            }
        }
        if (!u1Fleet.contains(u1Rocket)) {
            u1Fleet.add(u1Rocket);
        }
        return u1Fleet;
    }

    private ArrayList<Rocket> loadU2(ArrayList<Item> items) {
        ArrayList<Rocket> u2Fleet = new ArrayList<Rocket>();

        U2 u2Rocket = new U2();
        for (Item item : items) {
            if (u2Rocket.canCarry(item)) {
                u2Rocket.carry(item);
            }
            else {
                u2Fleet.add(u2Rocket);
                u2Rocket = new U2();
            }
        }
        if (!u2Fleet.contains(u2Rocket)) {
            u2Fleet.add(u2Rocket);
        }
        return u2Fleet;
    }

    private int runSimulation(ArrayList<Rocket> rockets) {
        int totalCost = 0;

        for (Rocket rocket : rockets) {
            boolean missionComplete = false;
            while (!missionComplete) {
                totalCost += rocket.cost;
                if (!rocket.launch()) {
                    continue;
                }
                if (!rocket.land()) {
                    continue;
                }
                missionComplete = true;
            }
        }
        return totalCost;
    }

    public static void main(String[] args) throws Exception {
        Simulation simulation = new Simulation();
        ArrayList<Item> phaseOneitems = simulation.loadItems("phase-1.txt");
        ArrayList<Item> phaseTwoitems = simulation.loadItems("phase-2.txt");

        System.out.println("Running U1 Simulation");
        ArrayList<Rocket> u1FleetPhase1 = simulation.loadU1(phaseOneitems);
        int u1Phase1Cost = simulation.runSimulation(u1FleetPhase1);
        System.out.printf("Phase 1 cost = %s", u1Phase1Cost);
        System.out.println();

        ArrayList<Rocket> u1FleetPhase2 = simulation.loadU1(phaseTwoitems);
        int u1Phase2Cost = simulation.runSimulation(u1FleetPhase2);
        System.out.printf("Phase 2 cost = %s", u1Phase2Cost);
        System.out.println();
        System.out.printf("Simulation complete, Total Cost (Phase 1 + 2) = %s", u1Phase1Cost + u1Phase2Cost);
        System.out.println();
        System.out.println();

        System.out.println("Running U2 Simulation");
        ArrayList<Rocket> u2FleetPhase1 = simulation.loadU2(phaseOneitems);
        int u2Phase1Cost = simulation.runSimulation(u2FleetPhase1);
        System.out.printf("Phase 1 cost = %s", u2Phase1Cost);
        System.out.println();

        ArrayList<Rocket> u2FleetPhase2 = simulation.loadU2(phaseTwoitems);
        int u2Phase2Cost = simulation.runSimulation(u2FleetPhase2);
        System.out.printf("Phase 2 cost = %s", u2Phase2Cost);
        System.out.println();
        System.out.printf("Simulation complete, Total Cost (Phase 1 + 2) = %s", u2Phase1Cost + u2Phase2Cost);
        System.out.println();
    }
}
