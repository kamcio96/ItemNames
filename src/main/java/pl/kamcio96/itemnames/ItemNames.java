package pl.kamcio96.itemnames;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.Material;

import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class ItemNames {

    public static final Source PL = new Source(Repository.KAMCIO96_GITHUB, "PL");

    /*=================================================*/

    private final HashMap<Material, String> translatedNames = new HashMap<>(Material.values().length);

    public ItemNames() {
        this(PL);
    }

    public ItemNames(Source source) {

        URL url;
        try {
            url = new URL(source.getRepository().getHost() + source.getLang().toLowerCase() + ".json");
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(e);
        }

        JsonObject element;
        try {
            InputStreamReader reader = new InputStreamReader(url.openStream(), StandardCharsets.UTF_8);
            element = new JsonParser().parse(reader).getAsJsonObject();
            reader.close();
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }

        for (Map.Entry<String, JsonElement> entry : element.entrySet()) {
            if(!entry.getValue().isJsonPrimitive()) {
                continue;
            }

            Material material = Material.matchMaterial(entry.getKey());

            if (material == null) {
                System.out.println("[ItemNames] Cannot find material '" + entry.getKey() + "'");
                continue;
            }

            translatedNames.put(material, entry.getValue().getAsString());
        }
    }

    public String getTranslatedName(Material material) {
        String name = translatedNames.get(material);
        if (name == null || name.equals("")) {
            name = material.name().toLowerCase().replace("_", " ");
        }
        return name;
    }

    @Getter
    @AllArgsConstructor
    public static class Source {
        private Repository repository;
        private String lang;
    }

    @Getter
    @AllArgsConstructor
    public enum Repository {
        KAMCIO96_GITHUB("http://kamcio96.github.io/items/")
        ;
        private String host;
    }
}
