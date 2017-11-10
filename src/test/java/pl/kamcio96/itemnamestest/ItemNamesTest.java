package pl.kamcio96.itemnamestest;

import org.bukkit.Material;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.kamcio96.itemnames.ItemNames;

public class ItemNamesTest {

    private static ItemNames names;

    @BeforeAll
    public static void setup() {
        names = new ItemNames(ItemNames.PL);
    }

    @AfterAll
    public static void cleanup() {
        names = null;
    }

    @Test
    public void testTranslate() {
        String name = names.getTranslatedName(Material.GRASS);
        Assertions.assertEquals("trawa", name);
    }

    @Test
    public void testException() {
        names.addException(Material.COBBLESTONE, "cobbletest");
        Assertions.assertEquals("cobbletest", names.getTranslatedName(Material.COBBLESTONE));
    }

}
