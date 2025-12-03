package plugily.projects.villagedefense.kits.base;

import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import plugily.projects.minigamesbox.classic.handlers.language.MessageBuilder;
import plugily.projects.minigamesbox.classic.kits.basekits.Kit;
import plugily.projects.villagedefense.Main;

/**
 * Shared Kit wrapper that adapts the MiniGamesBox constructor changes to the
 * Village Defense kit registration pattern.
 */
public abstract class VillageKit extends Kit {

  protected VillageKit(String key, String nameKey, String descriptionKey, ItemStack icon) {
    super(new MessageBuilder(nameKey).asKey().build(), key,
        JavaPlugin.getPlugin(Main.class).getLanguageManager().getLanguageListFromKey(descriptionKey), icon);
    JavaPlugin.getPlugin(Main.class).getKitRegistry().registerKit(this);
  }

  protected Main plugin() {
    return JavaPlugin.getPlugin(Main.class);
  }
}
