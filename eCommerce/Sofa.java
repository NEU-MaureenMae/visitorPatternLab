package eCommerce;

public class Sofa implements Furniture {

    private final Size size;

    public Sofa(Size size) {
        this.size = size;
    }

    @Override
    public Size getSize() {
        return size;
    }

    @Override
    public double accept(ShippingCostVisitor visitor) {
        return visitor.visitSofa(this); // Delegate cost calculation to visitor
    }
}