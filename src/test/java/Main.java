import model.Koffieautomaat;

import org.junit.*;
import java.util.ArrayList;
import java.util.List;

import service.CityService;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

public class Main {
    private CityService service = new CityService();
    private List<Koffieautomaat> list = service.getAlleKoffieautomaten();

    @Test
    public void checkPriceStatus() {
        for (Koffieautomaat k : list) {
            Assert.assertThat("prijs", (int)k.getPrice(), greaterThan(500));
        }
    }

    @Test
    public void checkCodeLength() {
        for (Koffieautomaat k : list) {
            Assert.assertThat("code", k.getCode().length(), equalTo(2));
        }
    }
}
