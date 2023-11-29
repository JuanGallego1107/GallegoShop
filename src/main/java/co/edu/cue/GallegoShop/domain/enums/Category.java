package co.edu.cue.GallegoShop.domain.enums;

public enum Category {
    FOOTWEAR("Calzado"),
    T_SHIRTS("Camisetas"),
    PANTS("Pantalones"),
    ACCESORIES("Accesorios")
    ;
    private final String value;

    Category(String value) {
        this.value = value;
    }
}
