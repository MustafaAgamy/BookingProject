import org.testng.Assert;
import org.testng.annotations.Test;
import pages.filters.filterType.FilterTypeEnumMaps;
import utils.ReadJSON;

public class TypeFiltrationTest extends TestBase{
    private ReadJSON jsonFile;
    private final String COMMERCIAL_FILE = "typeFilter/commercial.json";
    private final String RESIDENTIAL_FILE = "typeFilter/residential.json";
    @Test
    public void testOfTypeResidential() {
        jsonFile = new ReadJSON(RESIDENTIAL_FILE);
        homePage.clickDiscoverBtn().visitTypeFilter()
                .pickResidentialTypeFilterOption(FilterTypeEnumMaps.ResidentialTypes.SERVICED_APARTMENT)
                .pickResidentialTypeFilterOption(FilterTypeEnumMaps.ResidentialTypes.APARTMENT)
                .applyFilter()
                .waitForUrlToChange()
                .checkTypeFilterApplied()
                .parallelStream().forEach(typeFilter -> Assert.assertTrue(typeFilter.equalsIgnoreCase(jsonFile.readJsonString("servicedApartment"))
                                || typeFilter.equalsIgnoreCase(jsonFile.readJsonString("apartment"))
                        ,"Expected 'Serviced Apartment OR duplex', but found: " + typeFilter));

    }

    @Test
    public void testOfTypeCommercial(){
        jsonFile = new ReadJSON(COMMERCIAL_FILE);

        homePage.clickDiscoverBtn().visitTypeFilter()
                .clickCommercial()
                .pickCommercialTypeFilterOption(FilterTypeEnumMaps.CommercialTypes.BANK)
                .pickCommercialTypeFilterOption(FilterTypeEnumMaps.CommercialTypes.BUILDING)
                .pickCommercialTypeFilterOption(FilterTypeEnumMaps.CommercialTypes.MALL)
                .applyFilter()
                .waitForUrlToChange()
                .checkTypeFilterApplied().forEach(typeFilter -> Assert.assertTrue(typeFilter.equalsIgnoreCase(jsonFile.readJsonString("bank"))
                        || typeFilter.equalsIgnoreCase(jsonFile.readJsonString("building")) || typeFilter.equalsIgnoreCase(jsonFile.readJsonString("mall")),
                        "Expected 'Bank - Building - Mall', but found : " + typeFilter));
    }
}
