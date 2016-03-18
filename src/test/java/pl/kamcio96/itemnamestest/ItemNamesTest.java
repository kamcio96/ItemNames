package pl.kamcio96.itemnamestest;

import org.bukkit.Material;
import org.junit.Assert;
import org.junit.Test;
import pl.kamcio96.itemnames.ItemNames;

public class ItemNamesTest {

    @Test
    public void itemNames_test() {
        ItemNames names = new ItemNames();
        String name = names.getTranslatedName(Material.GRASS);
        Assert.assertEquals("trawa", name);

        names.addException(Material.COBBLESTONE, "cobbletest");
        Assert.assertEquals("cobbletest", names.getTranslatedName(Material.COBBLESTONE));
    }

}
