import org.testng.Assert;
import org.testng.annotations.Test;


public class BedsBathsFiltrationTest extends TestBase{

    @Test
    public void testOfBedsBathsFilter(){
        homePage.clickDiscoverBtn()
                .visitBedsBathsFilter()
                .pickRoomsNumber(2)
                .pickBathsNumber(2)
                .applyFilter()
                .waitForUrlToChange()
                .checkBedsBathsFilterApplied()
                .parallelStream().forEach(resultList ->
                    resultList
                            .parallelStream().forEach(
                                    resultText -> Assert.assertEquals(
                                            Integer.parseInt(String.valueOf(resultText))
                    , 2, "Incorrect beds or baths filter applied " + resultText)));


    }
}
