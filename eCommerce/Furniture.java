package eCommerce;

public interface Furniture {

    enum Size { SMALL, MEDIUM, LARGE };

    Size getSize();

    double accept(ShippingCostVisitor visitor);
}
