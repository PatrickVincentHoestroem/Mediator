package demo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MediatorTest {
    private Mediator mediator;

    @BeforeEach
    public void setup() {
        mediator = new Mediator();
        mediator.add(new Command("North America", "89.123.3.32", "oooWIHOWdoiaw0fW?2800...", mediator));
        mediator.add(new Command("Europe", "79.113.1.21", "ublKANSOF029248jf...", mediator));
        mediator.add(new Command("South Atlantic", "212.76.4.2", "kfjASIOOIFHOasfao...", mediator));
        mediator.add(new Command("Asia", "111.51.8.5", "AFJAS/(¤!87914HIFAHF...", mediator));
    }

    @Test
    public void doNotify_success() {
        Command sender = mediator.get("North America");

        mediator.doNotify(sender);

        assertEquals("A lot of 'Asia' Data. A lot of 'North America' Data. " , mediator.get("Asia").getData());
        assertEquals("A lot of 'Europe' Data. A lot of 'North America' Data. " , mediator.get("Europe").getData());
        assertEquals("A lot of 'South Atlantic' Data. A lot of 'North America' Data. " , mediator.get("South Atlantic").getData());
    }

}