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
            System.out.printf("name = %s, weight = %s", item.getName(), item.getWeight());
            System.out.println();
        }

        return items;
    }

    public static void main(String[] args) throws Exception {
        Simulation simulation = new Simulation();
        ArrayList<Item> items = simulation.loadItems("phase-1.txt");
    }
}
