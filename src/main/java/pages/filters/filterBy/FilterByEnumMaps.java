package pages.filters.filterBy;

import java.util.EnumMap;

public class FilterByEnumMaps {
    public enum Features {
        DRIVERS_BATHROOM, DRIVERS_ROOM, MAIDS_BATHROOM, MAIDS_ROOM, JACUZZI, PRIVATE_PARKING, BASEMENT, ROOF, GARDEN, POOL
    }

    public enum Amenities {
        HOSPITAL, UNIVERSITY, SCHOOL, NURSERY, LAUNDRY, HOUSEKEEPING, BANK, KIDS_AREA, SWIMMING_POOL, MEDICAL_CENTER, GYM, COMMERCIAL_AREA, CLUBHOUSE
    }

    protected static final EnumMap<Features, Integer> FEATURES_MAP = new EnumMap<>(Features.class);
    protected static final EnumMap<Amenities, Integer> AMENITIES_MAP = new EnumMap<>(Amenities.class);

    static {
        FEATURES_MAP.put(Features.DRIVERS_BATHROOM, 1);
        FEATURES_MAP.put(Features.DRIVERS_ROOM, 2);
        FEATURES_MAP.put(Features.MAIDS_BATHROOM, 3);
        FEATURES_MAP.put(Features.MAIDS_ROOM, 4);
        FEATURES_MAP.put(Features.JACUZZI, 5);
        FEATURES_MAP.put(Features.PRIVATE_PARKING, 6);
        FEATURES_MAP.put(Features.BASEMENT, 7);
        FEATURES_MAP.put(Features.ROOF, 8);
        FEATURES_MAP.put(Features.GARDEN, 9);
        FEATURES_MAP.put(Features.POOL, 10);

        AMENITIES_MAP.put(Amenities.HOSPITAL, 1);
        AMENITIES_MAP.put(Amenities.UNIVERSITY, 2);
        AMENITIES_MAP.put(Amenities.SCHOOL, 3);
        AMENITIES_MAP.put(Amenities.NURSERY, 4);
        AMENITIES_MAP.put(Amenities.LAUNDRY, 5);
        AMENITIES_MAP.put(Amenities.HOUSEKEEPING, 6);
        AMENITIES_MAP.put(Amenities.BANK, 7);
        AMENITIES_MAP.put(Amenities.KIDS_AREA, 8);
        AMENITIES_MAP.put(Amenities.SWIMMING_POOL, 9);
        AMENITIES_MAP.put(Amenities.MEDICAL_CENTER, 10);
        AMENITIES_MAP.put(Amenities.GYM, 11);
        AMENITIES_MAP.put(Amenities.COMMERCIAL_AREA, 12);
        AMENITIES_MAP.put(Amenities.CLUBHOUSE, 13);
    }
}
