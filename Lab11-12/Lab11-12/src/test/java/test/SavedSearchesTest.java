package test;

import org.testng.annotations.Test;
import page.SearchedPage;

import static org.hamcrest.MatcherAssert.assertThat;

public class SavedSearchesTest extends CommonConditions {
    @Test
    public void testSearches() throws InterruptedException {
        boolean res = new SearchedPage(driver)
                .open()
                .findAndSaveSearch();
        assertThat("Saved Searches works correct", !res);
    }

}
