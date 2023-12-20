package test;

import org.testng.annotations.Test;
import page.FavoritePage;

import static org.hamcrest.MatcherAssert.assertThat;

public class FavoritesTest extends CommonConditions {
    @Test
    public void testFavorites() throws InterruptedException {
        Boolean testFav = new FavoritePage(driver)
                .open()
                .login()
                .choiceCar();
        assertThat("Favs works!", testFav);
    }
    @Test
    public void testDeleteFavorites() throws InterruptedException {
        Boolean testFav = new FavoritePage(driver)
                .open()
                .login()
                .deleteCar();
        assertThat("Favs delete works!", testFav);
    }
}
