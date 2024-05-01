package eCommerce;

import java.util.*;

public class FurnitureShippingCostCalculator {

    public static void main(String[] args) {

        /*
        RATE CALCULATION
        Chairs: Flat rate (base cost)
        Tables: Base cost + (Size Rate * Cost per Km * Size Multiplier)
        Sofas: (Double Chair Base Cost) + (Size Rate * Cost per Km * Size Multiplier) with slightly different size multipliers compared to tables.
        */

        // Create furniture objects with sizes
        Furniture chair = new Chair(Furniture.Size.SMALL);
        Furniture table = new Table(Furniture.Size.MEDIUM);
        Furniture sofa = new Sofa(Furniture.Size.LARGE);

        // Cost parameters
        double baseCost = 70.0;
        double costPerKm = 10.0;

        Map<String, Double> sizeRateMap = new HashMap<>();
        sizeRateMap.put("small", 0.7);
        sizeRateMap.put("medium", 1.0);
        sizeRateMap.put("large", 1.3);

        // Choose shipping cost visitor
        ShippingCostVisitor visitor = new DistanceBasedShippingCostVisitor(baseCost, costPerKm, sizeRateMap);

        // Print furniture details and shipping cost
        for (Furniture furniture : new Furniture[]{chair, table, sofa}) {
            System.out.println("Furniture: " + furniture.getClass().getSimpleName());
            System.out.println("Size: " + furniture.getSize());
            double cost = furniture.accept(visitor);
            System.out.println("Shipping Cost: ₱" + cost);
            System.out.println();
        }

    }
}
