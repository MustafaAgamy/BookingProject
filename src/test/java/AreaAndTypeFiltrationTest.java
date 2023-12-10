import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DiscoverPage;
import pages.filters.filterType.FilterTypeEnumMaps;
import utils.ReadJSON;

public class AreaAndTypeFiltrationTest extends TestBase{
    ReadJSON jsonFile;
    private final String COMMERCIAL_FILE = "typeFilter/commercial.json";
    private final String RESIDENTIAL_FILE = "typeFilter/residential.json";

    @Test
    public void testOfAreaAndTypeFilters(){
        jsonFile = new ReadJSON(RESIDENTIAL_FILE);
        homePage.clickDiscoverBtn()
                .visitTypeFilter()
                .pickResidentialTypeFilterOption(FilterTypeEnumMaps.ResidentialTypes.SERVICED_APARTMENT)
                .applyFilter()
                .waitForUrlToChange()
                .checkTypeFilterApplied()
                .parallelStream().forEach(resultText -> Assert.assertTrue(resultText.equalsIgnoreCase(jsonFile.readJsonString("servicedApartment"))
                                || resultText.equalsIgnoreCase(jsonFile.readJsonString("duplex"))
                        ,"Expected 'Serviced Apartment OR duplex', but found: " + resultText));
        new DiscoverPage(driver)
                .visitAreaFilter()
                .setMinAndMaxAreaAndApply("200","500")
                .waitForUrlToChange()
                .checkAreaFilterApplied()
                .parallelStream().forEach(resultText -> Assert.assertTrue( 200 <= resultText
                                && resultText <= 500
                        ,"Expected 'result to be in between 200 & 500', but found: " + resultText));;
    }
}
