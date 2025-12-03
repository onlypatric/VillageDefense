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

package plugily.projects.villagedefense.boot;

import plugily.projects.minigamesbox.classic.handlers.language.Message;
import plugily.projects.minigamesbox.classic.handlers.language.MessageManager;
import plugily.projects.villagedefense.Main;

/**
 * @author Tigerpanzer_02
 * <p>
 * Created at 15.10.2022
 */
public class MessageInitializer {
  private final Main plugin;

  public MessageInitializer(Main plugin) {
    this.plugin = plugin;
  }

  public void registerMessages() {
    MessageManager manager = getMessageManager();
    if(manager == null) {
      return;
    }

    manager.registerMessage("COMMANDS_ADMIN_ADDED_ORBS", new Message("Commands.Admin.Added-Orbs", ""));
    manager.registerMessage("COMMANDS_ADMIN_RECEIVED_ORBS", new Message("Commands.Admin.Received-Orbs", ""));


    manager.registerMessage("IN_GAME_MESSAGES_GAME_END_PLACEHOLDERS_DIED_PLAYERS", new Message("In-Game.Messages.Game-End.Placeholders.Died.Players", ""));
    manager.registerMessage("IN_GAME_MESSAGES_GAME_END_PLACEHOLDERS_DIED_VILLAGERS", new Message("In-Game.Messages.Game-End.Placeholders.Died.Villagers", ""));
    manager.registerMessage("IN_GAME_MESSAGES_GAME_END_PLACEHOLDERS_SURVIVED", new Message("In-Game.Messages.Game-End.Placeholders.Survived", ""));

    manager.registerMessage("IN_GAME_MESSAGES_ADMIN_REMOVED_VILLAGERS", new Message("In-Game.Messages.Admin.Removed.Villagers", ""));
    manager.registerMessage("IN_GAME_MESSAGES_ADMIN_REMOVED_GOLEMS", new Message("In-Game.Messages.Admin.Removed.Golems", ""));
    manager.registerMessage("IN_GAME_MESSAGES_ADMIN_REMOVED_ZOMBIES", new Message("In-Game.Messages.Admin.Removed.Zombies", ""));
    manager.registerMessage("IN_GAME_MESSAGES_ADMIN_REMOVED_WOLVES", new Message("In-Game.Messages.Admin.Removed.Wolves", ""));
    manager.registerMessage("IN_GAME_MESSAGES_ADMIN_CHANGED_WAVE", new Message("In-Game.Messages.Admin.Changed.Wave", ""));


    manager.registerMessage("IN_GAME_MESSAGES_VILLAGE_ROTTEN_FLESH_LEVEL_UP", new Message("In-Game.Messages.Village.Rotten-Flesh-Level-Up", ""));
    manager.registerMessage("IN_GAME_MESSAGES_VILLAGE_FEEL_REFRESHED", new Message("In-Game.Messages.Village.You-Feel-Refreshed", ""));
    manager.registerMessage("IN_GAME_MESSAGES_VILLAGE_VILLAGER_DIED", new Message("In-Game.Messages.Village.Villager.Died", ""));
    manager.registerMessage("IN_GAME_MESSAGES_VILLAGE_VILLAGER_NAMES", new Message("In-Game.Messages.Village.Villager.Names", ""));
    manager.registerMessage("IN_GAME_MESSAGES_VILLAGE_WAVE_STUCK_ZOMBIES", new Message("In-Game.Messages.Village.Wave.Stuck-Zombies", ""));
    /*unused*/
    manager.registerMessage("IN_GAME_MESSAGES_VILLAGE_WAVE_SPECTATOR_WARNING", new Message("In-Game.Messages.Village.Wave.Spectator-Warning", ""));
    manager.registerMessage("IN_GAME_MESSAGES_VILLAGE_WAVE_RESPAWN_ON_NEXT", new Message("In-Game.Messages.Village.Wave.Respawn-On-Next", ""));
    manager.registerMessage("IN_GAME_MESSAGES_VILLAGE_WAVE_RESPAWNED", new Message("In-Game.Messages.Village.Wave.Respawned", ""));
    manager.registerMessage("IN_GAME_MESSAGES_VILLAGE_WAVE_NEXT_IN", new Message("In-Game.Messages.Village.Wave.Next-In", ""));
    manager.registerMessage("IN_GAME_MESSAGES_VILLAGE_WAVE_STARTED", new Message("In-Game.Messages.Village.Wave.Started", ""));
    manager.registerMessage("IN_GAME_MESSAGES_VILLAGE_WAVE_TITLE_START", new Message("In-Game.Messages.Village.Wave.Title.Start", ""));
    manager.registerMessage("IN_GAME_MESSAGES_VILLAGE_WAVE_TITLE_END", new Message("In-Game.Messages.Village.Wave.Title.End", ""));
    manager.registerMessage("IN_GAME_MESSAGES_VILLAGE_WAVE_ORBS_PICKUP", new Message("In-Game.Messages.Village.Orbs.Pickup", ""));
    manager.registerMessage("IN_GAME_MESSAGES_VILLAGE_WAVE_ENTITIES_WOLF_SPAWN", new Message("In-Game.Messages.Village.Entities.Wolf.Spawn", ""));
    manager.registerMessage("IN_GAME_MESSAGES_VILLAGE_WAVE_ENTITIES_WOLF_NAME", new Message("In-Game.Messages.Village.Entities.Wolf.Name", ""));
    manager.registerMessage("IN_GAME_MESSAGES_VILLAGE_WAVE_ENTITIES_WOLF_DEATH", new Message("In-Game.Messages.Village.Entities.Wolf.Death", ""));
    manager.registerMessage("IN_GAME_MESSAGES_VILLAGE_WAVE_ENTITIES_GOLEM_SPAWN", new Message("In-Game.Messages.Village.Entities.Golem.Spawn", ""));
    manager.registerMessage("IN_GAME_MESSAGES_VILLAGE_WAVE_ENTITIES_GOLEM_NAME", new Message("In-Game.Messages.Village.Entities.Golem.Name", ""));
    manager.registerMessage("IN_GAME_MESSAGES_VILLAGE_WAVE_ENTITIES_GOLEM_CANT_RIDE_OTHER", new Message("In-Game.Messages.Village.Entities.Golem.Cant-Ride-Other", ""));


    manager.registerMessage("IN_GAME_MESSAGES_VILLAGE_SHOP_GUI", new Message("In-Game.Messages.Village.Shop.GUI", ""));
    manager.registerMessage("IN_GAME_MESSAGES_VILLAGE_SHOP_GOLEM_ITEM", new Message("In-Game.Messages.Village.Shop.Golem-Item-Name", ""));
    manager.registerMessage("IN_GAME_MESSAGES_VILLAGE_SHOP_WOLF_ITEM", new Message("In-Game.Messages.Village.Shop.Wolf-Item-Name", ""));
    manager.registerMessage("IN_GAME_MESSAGES_VILLAGE_SHOP_MOB_LIMIT_REACHED", new Message("In-Game.Messages.Village.Shop.Mob-Limit-Reached", ""));
    manager.registerMessage("IN_GAME_MESSAGES_VILLAGE_SHOP_NOT_ENOUGH_CURRENCY", new Message("In-Game.Messages.Village.Shop.Not-Enough-Currency", ""));
    manager.registerMessage("IN_GAME_MESSAGES_VILLAGE_SHOP_CURRENCY", new Message("In-Game.Messages.Village.Shop.Currency", ""));
    manager.registerMessage("IN_GAME_MESSAGES_VILLAGE_SHOP_NOT_DEFINED", new Message("In-Game.Messages.Village.Shop.Not-Defined", ""));


    manager.registerMessage("LEADERBOARD_STATISTICS_ORBS", new Message("Leaderboard.Statistics.Orbs", ""));
    manager.registerMessage("LEADERBOARD_STATISTICS_HIGHEST_WAVE", new Message("Leaderboard.Statistics.Highest-Wave", ""));
    manager.registerMessage("LEADERBOARD_STATISTICS_KILLS", new Message("Leaderboard.Statistics.Kills", ""));
    manager.registerMessage("LEADERBOARD_STATISTICS_DEATHS", new Message("Leaderboard.Statistics.Deaths", ""));


    manager.registerMessage("UPGRADE_MENU_TITLE", new Message("Upgrade-Menu.Title", ""));
    manager.registerMessage("UPGRADE_MENU_UPGRADED_ENTITY", new Message("Upgrade-Menu.Upgraded-Entity", ""));
    manager.registerMessage("UPGRADE_MENU_CANNOT_AFFORD", new Message("Upgrade-Menu.Cannot-Afford", ""));
    manager.registerMessage("UPGRADE_MENU_MAX_TIER", new Message("Upgrade-Menu.Max-Tier", ""));
    manager.registerMessage("UPGRADE_MENU_STATS_ITEM_NAME", new Message("Upgrade-Menu.Stats-Item.Name", ""));
    manager.registerMessage("UPGRADE_MENU_STATS_ITEM_DESCRIPTION", new Message("Upgrade-Menu.Stats-Item.Description", ""));
    manager.registerMessage("UPGRADE_MENU_UPGRADES_HEALTH_NAME", new Message("Upgrade-Menu.Upgrades.Health.Name", ""));
    manager.registerMessage("UPGRADE_MENU_UPGRADES_HEALTH_DESCRIPTION", new Message("Upgrade-Menu.Upgrades.Health.Description", ""));
    manager.registerMessage("UPGRADE_MENU_UPGRADES_DAMAGE_NAME", new Message("Upgrade-Menu.Upgrades.Damage.Name", ""));
    manager.registerMessage("UPGRADE_MENU_UPGRADES_DAMAGE_DESCRIPTION", new Message("Upgrade-Menu.Upgrades.Damage.Description", ""));
    manager.registerMessage("UPGRADE_MENU_UPGRADES_SPEED_NAME", new Message("Upgrade-Menu.Upgrades.Speed.Name", ""));
    manager.registerMessage("UPGRADE_MENU_UPGRADES_SPEED_DESCRIPTION", new Message("Upgrade-Menu.Upgrades.Speed.Description", ""));
    manager.registerMessage("UPGRADE_MENU_UPGRADES_SWARM_NAME", new Message("Upgrade-Menu.Upgrades.Swarm-Awareness.Name", ""));
    manager.registerMessage("UPGRADE_MENU_UPGRADES_SWARM_DESCRIPTION", new Message("Upgrade-Menu.Upgrades.Swarm-Awareness.Description", ""));
    manager.registerMessage("UPGRADE_MENU_UPGRADES_DEFENSE_NAME", new Message("Upgrade-Menu.Upgrades.Final-Defense.Name", ""));
    manager.registerMessage("UPGRADE_MENU_UPGRADES_DEFENSE_DESCRIPTION", new Message("Upgrade-Menu.Upgrades.Final-Defense.Description", ""));


    //CLEANER KIT

    manager.registerMessage("KIT_CONTENT_CLEANER_NAME", new Message("Kit.Content.Cleaner.Name", ""));
    manager.registerMessage("KIT_CONTENT_CLEANER_DESCRIPTION", new Message("Kit.Content.Cleaner.Description", ""));
    manager.registerMessage("KIT_CONTENT_CLEANER_GAME_ITEM_NAME", new Message("Kit.Content.Cleaner.Game-Item.Name", ""));
    manager.registerMessage("KIT_CONTENT_CLEANER_GAME_ITEM_DESCRIPTION", new Message("Kit.Content.Cleaner.Game-Item.Description", ""));
    manager.registerMessage("KIT_CONTENT_CLEANER_CLEANED_MAP", new Message("Kit.Content.Cleaner.Cleaned.Map", ""));
    manager.registerMessage("KIT_CONTENT_CLEANER_CLEANED_NOTHING", new Message("Kit.Content.Cleaner.Cleaned.Nothing", ""));

//ZOMBIE_TELEPORTER KIT

    manager.registerMessage("KIT_CONTENT_ZOMBIE_TELEPORTER_NAME", new Message("Kit.Content.Zombie-Teleporter.Name", ""));
    manager.registerMessage("KIT_CONTENT_ZOMBIE_TELEPORTER_DESCRIPTION", new Message("Kit.Content.Zombie-Teleporter.Description", ""));
    manager.registerMessage("KIT_CONTENT_ZOMBIE_TELEPORTER_GAME_ITEM_NAME", new Message("Kit.Content.Zombie-Teleporter.Game-Item.Name", ""));
    manager.registerMessage("KIT_CONTENT_ZOMBIE_TELEPORTER_GAME_ITEM_DESCRIPTION", new Message("Kit.Content.Zombie-Teleporter.Game-Item.Description", ""));
    manager.registerMessage("KIT_CONTENT_ZOMBIE_TELEPORTER_GAME_ITEM_GUI", new Message("Kit.Content.Zombie-Teleporter.Game-Item.GUI", ""));
    manager.registerMessage("KIT_CONTENT_ZOMBIE_TELEPORTER_TELEPORT_ZOMBIE", new Message("Kit.Content.Zombie-Teleporter.Teleport.Zombie", ""));
    manager.registerMessage("KIT_CONTENT_ZOMBIE_TELEPORTER_TELEPORT_NOT_FOUND", new Message("Kit.Content.Zombie-Teleporter.Teleport.Not-Found", ""));

//KNIGHT

    manager.registerMessage("KIT_CONTENT_KNIGHT_NAME", new Message("Kit.Content.Knight.Name", ""));
    manager.registerMessage("KIT_CONTENT_KNIGHT_DESCRIPTION", new Message("Kit.Content.Knight.Description", ""));

//LIGHT_TANK

    manager.registerMessage("KIT_CONTENT_LIGHT_TANK_NAME", new Message("Kit.Content.Light-Tank.Name", ""));
    manager.registerMessage("KIT_CONTENT_LIGHT_TANK_DESCRIPTION", new Message("Kit.Content.Light-Tank.Description", ""));

//ARCHER

    manager.registerMessage("KIT_CONTENT_ARCHER_NAME", new Message("Kit.Content.Archer.Name", ""));
    manager.registerMessage("KIT_CONTENT_ARCHER_DESCRIPTION", new Message("Kit.Content.Archer.Description", ""));

//PUNCHER

    manager.registerMessage("KIT_CONTENT_PUNCHER_NAME", new Message("Kit.Content.Puncher.Name", ""));
    manager.registerMessage("KIT_CONTENT_PUNCHER_DESCRIPTION", new Message("Kit.Content.Puncher.Description", ""));

//HEALER

    manager.registerMessage("KIT_CONTENT_HEALER_NAME", new Message("Kit.Content.Healer.Name", ""));
    manager.registerMessage("KIT_CONTENT_HEALER_DESCRIPTION", new Message("Kit.Content.Healer.Description", ""));

//LOOTER

    manager.registerMessage("KIT_CONTENT_LOOTER_NAME", new Message("Kit.Content.Looter.Name", ""));
    manager.registerMessage("KIT_CONTENT_LOOTER_DESCRIPTION", new Message("Kit.Content.Looter.Description", ""));

//RUNNER

    manager.registerMessage("KIT_CONTENT_RUNNER_NAME", new Message("Kit.Content.Runner.Name", ""));
    manager.registerMessage("KIT_CONTENT_RUNNER_DESCRIPTION", new Message("Kit.Content.Runner.Description", ""));

//MEDIUM_TANK

    manager.registerMessage("KIT_CONTENT_MEDIUM_TANK_NAME", new Message("Kit.Content.Medium-Tank.Name", ""));
    manager.registerMessage("KIT_CONTENT_MEDIUM_TANK_DESCRIPTION", new Message("Kit.Content.Medium-Tank.Description", ""));

//WORKER

    manager.registerMessage("KIT_CONTENT_WORKER_NAME", new Message("Kit.Content.Worker.Name", ""));
    manager.registerMessage("KIT_CONTENT_WORKER_DESCRIPTION", new Message("Kit.Content.Worker.Description", ""));
    manager.registerMessage("KIT_CONTENT_WORKER_GAME_ITEM_CHAT", new Message("Kit.Content.Worker.Game-Item.Chat", ""));

//DOG_FRIEND

    manager.registerMessage("KIT_CONTENT_DOG_FRIEND_NAME", new Message("Kit.Content.Dog-Friend.Name", ""));
    manager.registerMessage("KIT_CONTENT_DOG_FRIEND_DESCRIPTION", new Message("Kit.Content.Dog-Friend.Description", ""));

//HARDCORE

    manager.registerMessage("KIT_CONTENT_HARDCORE_NAME", new Message("Kit.Content.Hardcore.Name", ""));
    manager.registerMessage("KIT_CONTENT_HARDCORE_DESCRIPTION", new Message("Kit.Content.Hardcore.Description", ""));

//GOLEM_FRIEND

    manager.registerMessage("KIT_CONTENT_GOLEM_FRIEND_NAME", new Message("Kit.Content.Golem-Friend.Name", ""));
    manager.registerMessage("KIT_CONTENT_GOLEM_FRIEND_DESCRIPTION", new Message("Kit.Content.Golem-Friend.Description", ""));

//TORNADO

    manager.registerMessage("KIT_CONTENT_TORNADO_NAME", new Message("Kit.Content.Tornado.Name", ""));
    manager.registerMessage("KIT_CONTENT_TORNADO_DESCRIPTION", new Message("Kit.Content.Tornado.Description", ""));
    manager.registerMessage("KIT_CONTENT_TORNADO_GAME_ITEM_NAME", new Message("Kit.Content.Tornado.Game-Item.Name", ""));
    manager.registerMessage("KIT_CONTENT_TORNADO_GAME_ITEM_DESCRIPTION", new Message("Kit.Content.Tornado.Game-Item.Description", ""));

//TERMINATOR

    manager.registerMessage("KIT_CONTENT_TERMINATOR_NAME", new Message("Kit.Content.Terminator.Name", ""));
    manager.registerMessage("KIT_CONTENT_TERMINATOR_DESCRIPTION", new Message("Kit.Content.Terminator.Description", ""));

//TELEPORTER

    manager.registerMessage("KIT_CONTENT_TELEPORTER_NAME", new Message("Kit.Content.Teleporter.Name", ""));
    manager.registerMessage("KIT_CONTENT_TELEPORTER_DESCRIPTION", new Message("Kit.Content.Teleporter.Description", ""));
    manager.registerMessage("KIT_CONTENT_TELEPORTER_GAME_ITEM_NAME", new Message("Kit.Content.Teleporter.Game-Item.Name", ""));
    manager.registerMessage("KIT_CONTENT_TELEPORTER_GAME_ITEM_DESCRIPTION", new Message("Kit.Content.Teleporter.Game-Item.Description", ""));
    manager.registerMessage("KIT_CONTENT_TELEPORTER_GAME_ITEM_GUI", new Message("Kit.Content.Teleport.Game-Item.GUI", ""));
    manager.registerMessage("KIT_CONTENT_TELEPORTER_TELEPORT_VILLAGER", new Message("Kit.Content.Teleporter.Teleport.Villager", ""));
    manager.registerMessage("KIT_CONTENT_TELEPORTER_TELEPORT_WARNING", new Message("Kit.Content.Teleporter.Teleport.Warning", ""));
    manager.registerMessage("KIT_CONTENT_TELEPORTER_TELEPORT_PLAYER", new Message("Kit.Content.Teleporter.Teleport.Player", ""));
    manager.registerMessage("KIT_CONTENT_TELEPORTER_TELEPORT_NOT_FOUND", new Message("Kit.Content.Teleporter.Teleport.Not-Found", ""));

//HEAVY_TANK

    manager.registerMessage("KIT_CONTENT_HEAVY_TANK_NAME", new Message("Kit.Content.Heavy-Tank.Name", ""));
    manager.registerMessage("KIT_CONTENT_HEAVY_TANK_DESCRIPTION", new Message("Kit.Content.Heavy-Tank.Description", ""));

//SHOT_BOW

    manager.registerMessage("KIT_CONTENT_SHOT_BOW_NAME", new Message("Kit.Content.Shot-Bow.Name", ""));
    manager.registerMessage("KIT_CONTENT_SHOT_BOW_DESCRIPTION", new Message("Kit.Content.Shot-Bow.Description", ""));

//BLOCKER

    manager.registerMessage("KIT_CONTENT_BLOCKER_NAME", new Message("Kit.Content.Blocker.Name", ""));
    manager.registerMessage("KIT_CONTENT_BLOCKER_DESCRIPTION", new Message("Kit.Content.Blocker.Description", ""));
    manager.registerMessage("KIT_CONTENT_BLOCKER_GAME_ITEM_NAME", new Message("Kit.Content.Blocker.Game-Item.Name", ""));
    manager.registerMessage("KIT_CONTENT_BLOCKER_GAME_ITEM_DESCRIPTION", new Message("Kit.Content.Blocker.Game-Item.Description", ""));
    manager.registerMessage("KIT_CONTENT_BLOCKER_PLACE_SUCCESS", new Message("Kit.Content.Blocker.Place.Success", ""));
    manager.registerMessage("KIT_CONTENT_BLOCKER_PLACE_FAIL", new Message("Kit.Content.Blocker.Place.Fail", ""));

//PREMIUM_HARDCORE

    manager.registerMessage("KIT_CONTENT_PREMIUM_HARDCORE_NAME", new Message("Kit.Content.Premium-Hardcore.Name", ""));
    manager.registerMessage("KIT_CONTENT_PREMIUM_HARDCORE_DESCRIPTION", new Message("Kit.Content.Premium-Hardcore.Description", ""));

//MEDIC

    manager.registerMessage("KIT_CONTENT_MEDIC_NAME", new Message("Kit.Content.Medic.Name", ""));
    manager.registerMessage("KIT_CONTENT_MEDIC_DESCRIPTION", new Message("Kit.Content.Medic.Description", ""));

//WILD_NAKED

    manager.registerMessage("KIT_CONTENT_WILD_NAKED_NAME", new Message("Kit.Content.Wild-Naked.Name", ""));
    manager.registerMessage("KIT_CONTENT_WILD_NAKED_DESCRIPTION", new Message("Kit.Content.Wild-Naked.Description", ""));
    manager.registerMessage("KIT_CONTENT_WILD_NAKED_CANNOT_WEAR_ARMOR", new Message("Kit.Content.Wild-Naked.Cannot-Wear-Armor", ""));

//WIZARD

    manager.registerMessage("KIT_CONTENT_WIZARD_NAME", new Message("Kit.Content.Wizard.Name", ""));
    manager.registerMessage("KIT_CONTENT_WIZARD_DESCRIPTION", new Message("Kit.Content.Wizard.Description", ""));
    manager.registerMessage("KIT_CONTENT_WIZARD_GAME_ITEM_ESSENCE_NAME", new Message("Kit.Content.Wizard.Game-Item.Essence.Name", ""));
    manager.registerMessage("KIT_CONTENT_WIZARD_GAME_ITEM_ESSENCE_DESCRIPTION", new Message("Kit.Content.Wizard.Game-Item.Essence.Description", ""));
    manager.registerMessage("KIT_CONTENT_WIZARD_GAME_ITEM_WAND_NAME", new Message("Kit.Content.Wizard.Game-Item.Wand.Name", ""));
    manager.registerMessage("KIT_CONTENT_WIZARD_GAME_ITEM_WAND_DESCRIPTION", new Message("Kit.Content.Wizard.Game-Item.Wand.Description", ""));

  }

  private MessageManager getMessageManager() {
    return plugin.getMessageManager();
  }

}
