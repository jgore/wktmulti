package pl.urtica.wktmulti.entity.cart;

public enum CartPosition {

    p1_1(1, 1),
    p1_2(1, 2),
    p1_3(1, 3),
    p1_4(1, 4),
    p1_5(1, 5),
    p1_6(1, 6),

    p2_1(2, 1),
    p2_2(2, 2),
    p2_3(2, 3),
    p2_4(2, 4),
    p2_5(2, 5),
    p2_6(2, 6),

    p3_1(3, 1),
    p3_2(3, 2),
    p3_3(3, 3),
    p3_4(3, 4),
    p3_5(3, 5),
    p3_6(3, 6),

    p4_1(4, 1),
    p4_2(4, 2),
    p4_3(4, 3),
    p4_4(4, 4),
    p4_5(4, 5),
    p4_6(4, 6);


    private int x;
    private int y;

    CartPosition(int x, int y) {
    }
}
