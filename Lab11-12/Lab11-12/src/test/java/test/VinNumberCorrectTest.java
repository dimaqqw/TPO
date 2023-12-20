package test;

import org.testng.annotations.Test;
import page.VinPage;

public class VinNumberCorrectTest extends CommonConditions {
    @Test
    public void testCorrectVin() throws InterruptedException {
        boolean result = new VinPage(driver)
                .open()
                .checkCorectVin("ZFA22300005556777");
    }

    @Test
    public void testUnCorrectVin() throws InterruptedException {
        boolean result = new VinPage(driver)
                .open()
                .checkUnCorectVin("12345678901234567");
    }
}
