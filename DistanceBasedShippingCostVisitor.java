import java.util.*;

public class DistanceBasedShippingCostVisitor implements ShippingCostVisitor {

    private final double baseCost;
    private final double costPerKm;
    private final Map<String, Double> sizeRateMap;

    public DistanceBasedShippingCostVisitor(double baseCost, double costPerKm, Map<String, Double> sizeRateMap) {
        this.baseCost = baseCost;
        this.costPerKm = costPerKm;
        this.sizeRateMap = sizeRateMap;
    }

    @Override
    public double visitChair(Chair chair) {
        return baseCost;
    }

    @Override
    public double visitTable(Table table) {
        double sizeRate = sizeRateMap.get(table.getSize().name().toLowerCase());
        switch (table.getSize()) {
            case SMALL:
                return baseCost + (costPerKm * sizeRate * 1.0);
            case MEDIUM:
                return baseCost + (costPerKm * sizeRate * 1.2);
            case LARGE:
                return baseCost + (costPerKm * sizeRate * 1.5);
            default:
                return baseCost;
        }
    }

    @Override
    public double visitSofa(Sofa sofa) {
        double sizeRate = sizeRateMap.get(sofa.getSize().name().toLowerCase());
        switch (sofa.getSize()) {
            case SMALL:
                return baseCost * 2 + (costPerKm * sizeRate * 1.0);
            case MEDIUM:
                return baseCost * 2 + (costPerKm * sizeRate * 1.2);
            case LARGE:
                return baseCost * 2 + (costPerKm * sizeRate * 1.3);
            default:
                return baseCost * 2;
        }
    }
}
