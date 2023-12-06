import org.testng.Assert;
import org.testng.annotations.Test;
import pages.filters.filterType.FilterTypeEnumMaps;
import pages.filters.price.FilterPriceEnumMaps;

public class TestTypeAreaBedsBathsPriceFilters extends TestBase{


    @Test
    public void testAllFilters(){
        homePage.clickDiscoverBtn()
                .visitTypeFilter()
                .pickResidentialTypeFilterOption(FilterTypeEnumMaps.ResidentialTypes.APARTMENT)
                .applyFilter()
                .waitForUrlToChange()
                .checkTypeFilterApplied().parallelStream()
                .forEach(typeFilter -> Assert.assertTrue(typeFilter.equalsIgnoreCase("apartment"),
                        "Expected 'Apartment' but found: " + typeFilter));

        homePage.clickDiscoverBtn()
                .visitAreaFilter()
                .setMinAndMaxAreaAndApply("200","500")
                .waitForUrlToChange()
                .checkAreaFilterApplied().parallelStream()
                .forEach(areaFilter -> Assert.assertTrue(200 <= Integer.parseInt(areaFilter.substring(0, 3))
                        && Integer.parseInt(areaFilter.substring(0, 3)) <= 500,
                        "Expected 'Area to be in between 200 & 500', but found : " + areaFilter));

        homePage.clickDiscoverBtn()
                .visitBedsBathsFilter()
                .pickRoomsNumber(2)
                .pickBathsNumber(2)
                .applyFilter()
                .waitForUrlToChange()
                .checkBedsBathsFilterApplied().parallelStream().forEach(bedsAndBathsList ->
                bedsAndBathsList.parallelStream().forEach(bedAndBathsNumbers -> Assert.assertTrue(
                        Integer.parseInt(bedAndBathsNumbers) == 2 || Integer.parseInt(bedAndBathsNumbers) == 3,
                        "Expected 'Beds And Baths number to = 2 OR 3 but found :'" + bedAndBathsNumbers)));

        homePage.clickDiscoverBtn()
                .visitPriceFilter()
                .setPriceFromToField(FilterPriceEnumMaps.PriceValue._5_MILLION, FilterPriceEnumMaps.PriceValue._15_MILLION)
                .applyFilter()
                .waitForUrlToChange()
                .checkPriceFilterApplied().parallelStream()
                .forEach(priceFilter -> Assert.assertTrue(priceFilter >= 5000000 && priceFilter <= 15000000,
                        "Expected Price to be between '5Million And 15Million; but found : " + priceFilter));
    }

    @Test
    public void testAllFiltersChaining(){
        homePage.clickDiscoverBtn()
                .visitTypeFilter()
                .clickCommercial()
                .pickCommercialTypeFilterOption(FilterTypeEnumMaps.CommercialTypes.MALL)
                .and()
                .visitPriceFilter()
                .clickDownPayment()
                .setDownPaymentFromToField(FilterPriceEnumMaps.DownPaymentValue._1M, FilterPriceEnumMaps.DownPaymentValue._1_9M)
                .and()
                .visitBedsBathsFilter()
                .pickRoomsNumber(2).pickBathsNumber(2)
                .and()
                .visitAreaFilter()
                .setMinAndMaxAreaAndApply("200","500")
                .waitForUrlToChange();
    }
}
