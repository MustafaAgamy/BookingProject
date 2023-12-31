import org.testng.Assert;
import org.testng.annotations.Test;

public class AreaFiltrationTest extends TestBase{

    @Test
    public void testOfAreaFilter() {
        homePage.clickDiscoverBtn().visitAreaFilter()
                .setMinAndMaxAreaAndApply(200,500)
                .applyFilter()
                .waitForUrlToChange()
                .checkAreaFilterApplied()
                .parallelStream().forEach(resultText -> Assert.assertTrue( 200 <= resultText
                                && resultText <= 500
                        ,"Expected 'result to be in between 200 & 500', but found: " + resultText));
    }

    @Test
    public void testofFilters() {
        homePage.clickDiscoverBtn().visitAreaFilter()
                .setMinAndMaxAreaAndApply(200,500)
                .applyFilter()
                .waitForUrlToChange()
                .checkPriceFilterApplied()
                .parallelStream().forEach(resultText ->
                                Assert.assertTrue( 1000000 <= resultText
                                                && resultText <= 10000000,
                                        "Expected 'result to be in between 1 Million & 5 Million but found : " + resultText));
    }

}

