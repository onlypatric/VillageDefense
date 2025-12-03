/*
 *  Village Defense - Protect villagers from hordes of zombies
 *  Copyright (c) 2023 Plugily Projects - maintained by Tigerpanzer_02 and contributors
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package plugily.projects.villagedefense.kits.premium;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionType;
import org.bukkit.plugin.java.JavaPlugin;
import plugily.projects.minigamesbox.api.user.IUser;
import plugily.projects.minigamesbox.classic.handlers.language.MessageBuilder;
import plugily.projects.minigamesbox.classic.kits.basekits.PremiumKit;
import plugily.projects.minigamesbox.classic.utils.version.VersionUtils;
import plugily.projects.minigamesbox.classic.utils.version.events.api.PlugilyPlayerInteractEvent;
import plugily.projects.minigamesbox.classic.utils.version.xseries.XMaterial;
import plugily.projects.villagedefense.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Tom on 8/02/2015.
 */
public class NakedKit extends PremiumKit implements Listener {

  private final List<Material> armorTypes = new ArrayList<>();

  public NakedKit() {
    super("Naked",
        new MessageBuilder("KIT_CONTENT_WILD_NAKED_NAME").asKey().build(),
        new ArrayList<>(),
        new ItemStack(Material.IRON_SWORD));
    List<String> description = getPlugin().getLanguageManager().getLanguageListFromKey("KIT_CONTENT_WILD_NAKED_DESCRIPTION");
    getDescription().clear();
    getDescription().addAll(description);
    Main plugin = JavaPlugin.getPlugin(Main.class);
    plugin.getServer().getPluginManager().registerEvents(this, plugin);
    plugin.getKitRegistry().registerKit(this);
    setupArmorTypes();
  }

  private void setupArmorTypes() {
    armorTypes.addAll(Arrays.asList(
        Material.LEATHER_BOOTS, Material.LEATHER_CHESTPLATE, Material.LEATHER_LEGGINGS, Material.LEATHER_HELMET,
        XMaterial.GOLDEN_BOOTS.get(), XMaterial.GOLDEN_CHESTPLATE.get(), XMaterial.GOLDEN_LEGGINGS.get(), XMaterial.GOLDEN_HELMET.get(),
        Material.DIAMOND_BOOTS, Material.DIAMOND_LEGGINGS, Material.DIAMOND_CHESTPLATE, Material.DIAMOND_HELMET,
        Material.IRON_CHESTPLATE, Material.IRON_BOOTS, Material.IRON_HELMET, Material.IRON_LEGGINGS,
        Material.CHAINMAIL_BOOTS, Material.CHAINMAIL_LEGGINGS, Material.CHAINMAIL_CHESTPLATE, Material.CHAINMAIL_HELMET)
    );
  }

  @Override
  public boolean isUnlockedByPlayer(Player player) {
    Main plugin = JavaPlugin.getPlugin(Main.class);
    return player.hasPermission("villagedefense.kit.naked") || plugin.getPermissionsManager().hasPermissionString("KIT_PREMIUM_UNLOCK", player);
  }

  @Override
  public void giveKitItems(Player player) {
    ItemStack itemStack = new ItemStack(getMaterial());
    itemStack.addUnsafeEnchantment(Enchantment.SHARPNESS, 6);
    itemStack.addUnsafeEnchantment(Enchantment.SMITE, 2);
    itemStack.addUnsafeEnchantment(Enchantment.UNBREAKING, 10);
    player.getInventory().addItem(itemStack);
    player.getInventory().addItem(new ItemStack(Material.SADDLE));
  }

  public Material getMaterial() {
    return Material.IRON_SWORD;
  }

  @Override
  public void reStock(Player player) {
    player.getInventory().addItem(VersionUtils.getPotion(PotionType.HEALING, 1, true));
  }

  @EventHandler
  public void onArmor(InventoryClickEvent event) {
    if(!(event.getWhoClicked() instanceof Player)) {
      return;
    }
    Player who = (Player) event.getWhoClicked();
    if(!getPlugin().getArenaRegistry().isInArena(who)) {
      return;
    }
    IUser user = getPlugin().getUserManager().getUser(who);
    if(!(user.getKit() instanceof NakedKit)) {
      return;
    }
    ClickType clickType = event.getClick();
    if(clickType == ClickType.DROP || clickType == ClickType.CONTROL_DROP) {
      return;
    }
    Inventory inventory = event.getClickedInventory();
    if(inventory == null || inventory.getType() != InventoryType.PLAYER) {
      return;
    }

    boolean hasArmor = false;
    ItemStack itemStack = event.getCurrentItem();
    if(itemStack != null && armorTypes.contains(itemStack.getType())) {
      hasArmor = true;
    } else if(clickType == ClickType.NUMBER_KEY) {
      ItemStack hotbarItem = who.getInventory().getItem(event.getHotbarButton());
      if(hotbarItem != null && armorTypes.contains(hotbarItem.getType())) {
        hasArmor = true;
      }
    }
    if(hasArmor) {
      new MessageBuilder("KIT_CONTENT_WILD_NAKED_CANNOT_WEAR_ARMOR").asKey().send(who);
      event.setCancelled(true);
    }
  }

  @EventHandler
  public void onArmorClick(PlugilyPlayerInteractEvent event) {
    if(!getPlugin().getArenaRegistry().isInArena(event.getPlayer())) {
      return;
    }
    IUser user = getPlugin().getUserManager().getUser(event.getPlayer());
    if(!(user.getKit() instanceof NakedKit) || !event.hasItem()) {
      return;
    }
    if(armorTypes.contains(event.getItem().getType())) {
      event.setCancelled(true);
      new MessageBuilder("KIT_CONTENT_WILD_NAKED_CANNOT_WEAR_ARMOR").asKey().player(event.getPlayer()).sendPlayer();
    }
  }
}
