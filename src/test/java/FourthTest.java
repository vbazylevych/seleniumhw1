import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
    public void zonesForCountriesWithSeveralZonesIsSorted() {
        loginToAdmin();
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        List<WebElement> listOfCountriesWithSeveralZones = getListOfCountriesWithSeveralZones();
        int size = listOfCountriesWithSeveralZones.size();

        for (int i = 0; i < size; i++) {
            List<WebElement> actualListOfCountriesWithSeveralZones = getListOfCountriesWithSeveralZones();
            actualListOfCountriesWithSeveralZones.get(i).findElement(By.cssSelector("td:nth-child(5) > a")).click();
            testZoneSorted();
            driver.navigate().back();
        }
    }

    @Test
    public void geoZonesIsSorted() {
        loginToAdmin();
        driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        List<WebElement> listOfCountries = driver.findElements(By.cssSelector(".row"));
        int size = listOfCountries.size();
        for (int i = 0; i < size; i++) {
            List<WebElement> newListOfCountries = driver.findElements(By.cssSelector(".row"));
            newListOfCountries.get(i).findElement(By.cssSelector("td:nth-child(3) > a")).click();
            testGeoZoneSorted();
            driver.navigate().back();
        }
    }

    private List<WebElement> getListOfCountriesWithSeveralZones() {
        return driver.findElements(By.cssSelector(".row")).
                stream().filter(e -> Integer.parseInt(e.findElement(By.cssSelector("td:nth-child(6)")).getAttribute("textContent")) > 0)
                .collect(Collectors.toList());
    }

    private void testGeoZoneSorted() {
        List<String> listOfCountries = getListOfNames("select[name*='zone_code'] > option[selected='selected']");
        List<String> listOfSortedCountries = getListOfNames("select[name*='zone_code'] > option[selected='selected']");
        listOfSortedCountries.sort(Comparator.naturalOrder());
        assertThat(listOfCountries, equalTo(listOfSortedCountries));
    }

    private void testZoneSorted() {
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

