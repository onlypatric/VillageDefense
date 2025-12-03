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

package plugily.projects.villagedefense.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import plugily.projects.minigamesbox.classic.utils.helper.MaterialUtils;
import plugily.projects.minigamesbox.classic.utils.version.xseries.XMaterial;

/**
 * Created by Tom on 29/07/2014.
 */
public class Utils {

  private Utils() {
  }

  public static Material getCachedDoor(Block block) {
    //material can not be cached as we allow other door types
    if(block == null) {
      return XMaterial.OAK_DOOR.get();
    }
    return (MaterialUtils.isDoor(block.getType()) ? block.getType() : Material.AIR);
  }

  public static String stripColor(String input) {
    if(input == null) {
      return null;
    }
    // Remove legacy color codes using § or & prefixes
    return input.replaceAll("(?i)[§&][0-9A-FK-OR]", "");
  }

  public static String getPlainCustomName(Entity entity) {
    if(entity == null) {
      return null;
    }
    Component customName = entity.customName();
    if(customName == null) {
      return null;
    }
    return PlainTextComponentSerializer.plainText().serialize(customName);
  }
}
