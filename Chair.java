public class Chair implements Furniture {

    private final Size size;

    public Chair(Size size) {
        this.size = size;
    }

    @Override
    public Size getSize() {
        return size;
    }

    @Override
    public double accept(ShippingCostVisitor visitor) {
        return visitor.visitChair(this); // Delegate cost calculation to visitor
    }
}