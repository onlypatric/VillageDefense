package plugily.projects.villagedefense.kits.base;

import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import plugily.projects.minigamesbox.classic.handlers.language.MessageBuilder;
import plugily.projects.minigamesbox.classic.kits.basekits.PremiumKit;
import plugily.projects.villagedefense.Main;

public abstract class VillagePremiumKit extends PremiumKit {

  protected VillagePremiumKit(String key, String nameKey, String descriptionKey, ItemStack icon) {
    super(key,
        new MessageBuilder(nameKey).asKey().build(),
        JavaPlugin.getPlugin(Main.class).getLanguageManager().getLanguageListFromKey(descriptionKey),
        icon);
    JavaPlugin.getPlugin(Main.class).getKitRegistry().registerKit(this);
  }

  protected Main plugin() {
    return JavaPlugin.getPlugin(Main.class);
  }
}
