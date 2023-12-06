import org.testng.Assert;
import org.testng.annotations.Test;

public class AreaFiltrationTest extends TestBase{

    @Test
    public void testOfAreaFilter() {
        homePage.clickDiscoverBtn().visitAreaFilter()
                .setMinAndMaxAreaAndApply("200","500")
                .waitForUrlToChange()
                .checkAreaFilterApplied()
                .parallelStream().forEach(resultText -> Assert.assertTrue( 200 <= Integer.parseInt(resultText.substring(0, 3))
                                && Integer.parseInt(resultText.substring(0, 3)) <= 500
                        ,"Expected 'result to be in between 200 & 500', but found: " + Integer.parseInt(resultText.substring(0, 3))));;
    }

    @Test
    public void testofFilters() {
        homePage.clickDiscoverBtn().visitAreaFilter()
                .setMinAndMaxAreaAndApply("200","500")
                .waitForUrlToChange()
                .checkPriceFilterApplied()
                .parallelStream().forEach(resultText ->
                                Assert.assertTrue( 1000000 <= resultText
                                                && resultText <= 10000000,
                                        "Expected 'result to be in between 1 Million & 5 Million but found : " + resultText));
    }

}

