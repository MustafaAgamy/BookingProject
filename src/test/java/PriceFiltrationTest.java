import org.testng.Assert;
import org.testng.annotations.Test;
import pages.filters.price.FilterPriceEnumMaps;
import utils.ReadJSON;


public class PriceFiltrationTest extends TestBase{
    private ReadJSON jsonFile;
    private final String PRICE_FILTER_FILE = "priceFilter/price.json";

    @Test
    public void testOfProtoTypeEnum() {
       jsonFile = new ReadJSON(PRICE_FILTER_FILE);

       homePage.clickDiscoverBtn()
               .visitPriceFilter()
               .setPriceFromToField(FilterPriceEnumMaps.PriceValue._1_MILLION, FilterPriceEnumMaps.PriceValue._25_MILLION)
               .clickDownPayment()
               .setDownPaymentFromToField(FilterPriceEnumMaps.DownPaymentValue._100K, FilterPriceEnumMaps.DownPaymentValue._1M)
               .clickInstallments()
               .setInstallmentFromToField(FilterPriceEnumMaps.InstallmentValue._30K, FilterPriceEnumMaps.InstallmentValue._50K)
               .applyFilter()
               .waitForUrlToChange()
               .checkPriceRelatedFiltersApplied()
               .get(0).forEach(priceFilter -> Assert.assertTrue(
                       jsonFile.readJsonInt("fromPrice") <= priceFilter && priceFilter <= jsonFile.readJsonInt("toPrice")));
    }
}
