import org.testng.annotations.Test;
import pages.filters.filterBy.FilterByEnumMaps;

public class FilterByTest extends TestBase{

    @Test
    public void testAllFeatureFilters(){
       homePage.clickDiscoverBtn()
               .visitFilterBy()
               .pickFeatureFilter(FilterByEnumMaps.Features.DRIVERS_BATHROOM)
               .pickFeatureFilter(FilterByEnumMaps.Features.DRIVERS_ROOM)
               .pickFeatureFilter(FilterByEnumMaps.Features.MAIDS_BATHROOM)
               .pickFeatureFilter(FilterByEnumMaps.Features.MAIDS_ROOM)
               .pickFeatureFilter(FilterByEnumMaps.Features.JACUZZI)
               .pickFeatureFilter(FilterByEnumMaps.Features.POOL)
               .pickFeatureFilter(FilterByEnumMaps.Features.PRIVATE_PARKING)
               .pickFeatureFilter(FilterByEnumMaps.Features.BASEMENT)
               .pickFeatureFilter(FilterByEnumMaps.Features.ROOF)
               .pickFeatureFilter(FilterByEnumMaps.Features.GARDEN)
               .pickFeatureFilter(FilterByEnumMaps.Features.POOL);

    }

    @Test
    public void testAllAmenitiesFilters(){
        homePage.clickDiscoverBtn()
                .visitFilterBy()
                .pickAmenitiesFilter(FilterByEnumMaps.Amenities.HOSPITAL)
                .pickAmenitiesFilter(FilterByEnumMaps.Amenities.UNIVERSITY)
                .pickAmenitiesFilter(FilterByEnumMaps.Amenities.SCHOOL)
                .pickAmenitiesFilter(FilterByEnumMaps.Amenities.NURSERY)
                .pickAmenitiesFilter(FilterByEnumMaps.Amenities.LAUNDRY)
                .pickAmenitiesFilter(FilterByEnumMaps.Amenities.HOUSEKEEPING)
                .pickAmenitiesFilter(FilterByEnumMaps.Amenities.BANK)
                .pickAmenitiesFilter(FilterByEnumMaps.Amenities.KIDS_AREA)
                .pickAmenitiesFilter(FilterByEnumMaps.Amenities.SWIMMING_POOL)
                .pickAmenitiesFilter(FilterByEnumMaps.Amenities.MEDICAL_CENTER)
                .pickAmenitiesFilter(FilterByEnumMaps.Amenities.GYM)
                .pickAmenitiesFilter(FilterByEnumMaps.Amenities.COMMERCIAL_AREA)
                .pickAmenitiesFilter(FilterByEnumMaps.Amenities.CLUBHOUSE);

    }
}
