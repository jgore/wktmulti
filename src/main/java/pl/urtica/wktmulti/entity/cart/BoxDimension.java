package pl.urtica.wktmulti.entity.cart;

public enum BoxDimension {
    SMALL(500), MEDIUM(1000), BIG(3000);

    private Integer dimension;

    BoxDimension(Integer dimension) {
        this.dimension = dimension;
    }
}
