import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;


public class FourthTest extends BaseTest {

    @Test
    public void mainCountriesTableIsSorted() {
        loginToAdmin();
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        List<String> listOfCountries = getListOfNames(".row td:nth-child(5)");

        List<String> listOfSortedCountries = getListOfNames(".row td:nth-child(5)");
        listOfSortedCountries
                .sort(Comparator.naturalOrder());

        assertThat(listOfCountries, equalTo(listOfSortedCountries));
    }

    @Test
    public void zonesForCanadaIsSorted() {
        loginToAdmin();
        testZoneSorted("http://localhost/litecart/admin/?app=countries&doc=edit_country&country_code=CA");
    }

    @Test
    public void zonesForUSIsSorted() {
        loginToAdmin();
        testZoneSorted("http://localhost/litecart/admin/?app=countries&doc=edit_country&country_code=US");
    }

    @Test
    public void geoZonesForCanadaIsSorted() {
        loginToAdmin();
        driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        testGeoZoneSorted("http://localhost/litecart/admin/?app=geo_zones&doc=edit_geo_zone&page=1&geo_zone_id=1");
    }

    @Test
    public void geoZonesForUSIsSorted() {
        loginToAdmin();
        driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        testGeoZoneSorted("http://localhost/litecart/admin/?app=geo_zones&doc=edit_geo_zone&page=1&geo_zone_id=2");
    }

    private void testGeoZoneSorted(String url) {
        driver.get(url);
        List<String> listOfCountries = getListOfNames("select[name*='zone_code'] > option[selected='selected']");
        List<String> listOfSortedCountries = getListOfNames("select[name*='zone_code'] > option[selected='selected']");
        listOfSortedCountries.sort(Comparator.naturalOrder());
        assertThat(listOfCountries, equalTo(listOfSortedCountries));
    }

    private void testZoneSorted(String url) {
        driver.get(url);

        List<String> listOfCountries = getListOfNames("#table-zones tr td:nth-child(3)");
        if (listOfCountries.get(listOfCountries.size() - 1).equals("")) {
            listOfCountries.remove(listOfCountries.size() - 1);
        }

        List<String> listOfSortedCountries = getListOfNames("#table-zones tr td:nth-child(3)");
        if (listOfSortedCountries.get(listOfSortedCountries.size() - 1).equals("")) {
            listOfSortedCountries.remove(listOfSortedCountries.size() - 1);
        }

        listOfSortedCountries.sort(Comparator.naturalOrder());

        assertThat(listOfCountries, equalTo(listOfSortedCountries));
    }


    private List getListOfNames(String locator) {
        return driver.findElements(By.cssSelector(locator))
                .stream()
                .map(e -> e.getAttribute("innerText"))
                .collect(Collectors.toList());
    }
}

