package Pages;

public enum SortFiltersEnums {
    SORT_FILTERS_ON_SALE("On Sale"),
    SORT_FILTERS_Best_Seller("Best Sellers"),
    SORT_FILTERS_Product_ATo_Z("Product A to Z"),
    SORT_FILTERS_Product_Z_To_A("Product Z to A"),
//    SORT_FILTERS_Price_low_to_high("Price (Low to High)"),
//    SORT_FILTERS_Price_high_to_low("Price (High to Low)"),
    SORT_FILTERS_New_Arrivals("New Arrivals");

    private String name;

    SortFiltersEnums(String name) {
        this.name = name;
    }

    public String getResourcesName() {
        return name;
    }
}
