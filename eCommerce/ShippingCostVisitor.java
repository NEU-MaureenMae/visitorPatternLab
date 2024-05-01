package eCommerce;

public interface ShippingCostVisitor {

    double visitChair(Chair chair);

    double visitTable(Table table);

    double visitSofa(Sofa sofa);
}
