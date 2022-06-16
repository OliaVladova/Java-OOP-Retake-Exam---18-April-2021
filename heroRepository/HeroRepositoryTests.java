package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class HeroRepositoryTests {
    private Hero hero;
    private Hero heroTwo;
    private Hero heroNull;
    private HeroRepository heroRepository;
    private static final String SUCCESSFULLY_CREATED_HERO = "Successfully added hero %s with level %d";
    private static final int HERO_LEVEL_FIFTY = 50;
    private static final String HERO_NAME_BATMAN = "Batman";
    private static final Hero BATMAN = new Hero(HERO_NAME_BATMAN, HERO_LEVEL_FIFTY);
    @Before
    public void setUp() {
        hero = new Hero("Gumboll", 10);

        heroNull = null;
        // heroList = new ArrayList<>();
        heroRepository = new HeroRepository();

    }

    @Test
    public void testShouldReturnCorrectlySize() {
        heroRepository.create(hero);
        int count = heroRepository.getCount();
        Assert.assertEquals(1, count);
    }

    @Test(expected = NullPointerException.class)
    public void testShouldThrowExceptionWhenHeroIsNull() {
        heroRepository.create(heroNull);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionWhenHeroIsExists() {
        heroRepository.create(hero);
        heroRepository.create(hero);
    }

    @Test(expected = NullPointerException.class)
    public void testShouldThrowExceptionWhenHeroNameIsNull() {
        heroRepository.remove(null);
    }

    @Test
    public void testShouldReturnHeroWithHighestLevel() {
        heroRepository.create(hero);
        heroRepository.create(BATMAN);
        Hero toReturn = heroRepository.getHeroWithHighestLevel();
        Assert.assertEquals(BATMAN, toReturn);
    }
    @Test
    public void testShouldRemoveHeroFromTheRepositoryByTheGivenName() {
        heroRepository.create(BATMAN);

        boolean isRemoved = heroRepository.remove("Batman");
        Assert.assertTrue(isRemoved);
    }

    @Test
    public void testShouldReturnHeroWithGivenName() {
        heroRepository.create(hero);
        Hero heroToReturn = this.heroRepository.getHero("Gumboll");
        Assert.assertEquals(hero, heroToReturn);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testShouldThrowExceptionWhenModified() {
        heroRepository.getHeroes().clear();
    }

    @Test
    public void testShouldCreateHeroCorrectlyAndReturnTheInformationAboutCreation() {
        String expectedMessage = String.format(SUCCESSFULLY_CREATED_HERO, HERO_NAME_BATMAN, HERO_LEVEL_FIFTY);
        String actualMessage = heroRepository.create(BATMAN);

        Assert.assertEquals(expectedMessage, actualMessage);
    }


}
