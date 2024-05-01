package eCommerce;

public class Table implements Furniture {

    private final Size size;

    public Table(Size size) {
        this.size = size;
    }

    @Override
    public Size getSize() {
        return size;
    }

    @Override
    public double accept(ShippingCostVisitor visitor) {
        return visitor.visitTable(this); // Delegate cost calculation to visitor
    }
}