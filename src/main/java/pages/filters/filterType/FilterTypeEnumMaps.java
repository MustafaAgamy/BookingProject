package pages.filters.filterType;


import java.util.EnumMap;

public class FilterTypeEnumMaps {


    public enum ResidentialTypes {
        SERVICED_APARTMENT, TRIPLEX, CHALET, FAMILY_HOUSE, QUATTRO, LOFT, APARTMENT,
        CABIN, STUDIO, DUPLEX, PENTHOUSE, TOWNHOUSE, TWIN_HOUSE, STANDALONE_VILLA
    }

    public enum CommercialTypes {
        CLINIC, BANK, RETAIL, BUILDING, MALL, OFFICE
    }

    protected static final EnumMap<ResidentialTypes,Integer> RESIDENTIAL_TYPES_MAP = new EnumMap<>(ResidentialTypes.class);
    protected static final EnumMap<CommercialTypes,Integer> COMMERCIAL_TYPES_MAP = new EnumMap<>(CommercialTypes.class);

    static {
        RESIDENTIAL_TYPES_MAP.put(ResidentialTypes.SERVICED_APARTMENT,1);
        RESIDENTIAL_TYPES_MAP.put(ResidentialTypes.TRIPLEX,2);
        RESIDENTIAL_TYPES_MAP.put(ResidentialTypes.CHALET,3);
        RESIDENTIAL_TYPES_MAP.put(ResidentialTypes.FAMILY_HOUSE,4);
        RESIDENTIAL_TYPES_MAP.put(ResidentialTypes.QUATTRO,5);
        RESIDENTIAL_TYPES_MAP.put(ResidentialTypes.LOFT,6);
        RESIDENTIAL_TYPES_MAP.put(ResidentialTypes.APARTMENT,7);
        RESIDENTIAL_TYPES_MAP.put(ResidentialTypes.CABIN,8);
        RESIDENTIAL_TYPES_MAP.put(ResidentialTypes.STUDIO,9);
        RESIDENTIAL_TYPES_MAP.put(ResidentialTypes.DUPLEX,10);
        RESIDENTIAL_TYPES_MAP.put(ResidentialTypes.PENTHOUSE,11);
        RESIDENTIAL_TYPES_MAP.put(ResidentialTypes.TOWNHOUSE,12);
        RESIDENTIAL_TYPES_MAP.put(ResidentialTypes.TWIN_HOUSE,13);
        RESIDENTIAL_TYPES_MAP.put(ResidentialTypes.STANDALONE_VILLA,14);

        COMMERCIAL_TYPES_MAP.put(CommercialTypes.CLINIC,1);
        COMMERCIAL_TYPES_MAP.put(CommercialTypes.BANK,2);
        COMMERCIAL_TYPES_MAP.put(CommercialTypes.RETAIL,3);
        COMMERCIAL_TYPES_MAP.put(CommercialTypes.BUILDING,4);
        COMMERCIAL_TYPES_MAP.put(CommercialTypes.MALL,5);
        COMMERCIAL_TYPES_MAP.put(CommercialTypes.OFFICE,1);

    }

}
