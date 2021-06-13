package utils;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import static org.awaitility.Awaitility.await;

import java.time.Duration;

public class PageObjectUtils {

    public static void assertElement(WebElement element) {
        await().atLeast(Duration.ZERO)
                .atMost(Duration.ofMinutes(Integer.parseInt(Configuration.getProperty("await.atMost.minutes"))))
                .pollInterval(Duration.ofSeconds(Integer.parseInt(Configuration.getProperty("await.interval.seconds"))))
                .ignoreExceptions()
                .untilAsserted(() -> Assert.assertTrue("WebElement not enable in 2 minutes: " + element, element.isEnabled()));
    }
}
