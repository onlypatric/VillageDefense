## VillageDefense – Admin Arena Setup Cheat Sheet

This document is for **server admins** who need a quick, command‑oriented guide to set up arenas and basic gameplay. It assumes the plugin is already installed and enabled on your Paper server.

---

## 1. Permissions & Basics

- Give your setup account:
  - `villagedefense.admin.*`
- Main commands:
  - Player: `/vd`
  - Admin: `/vda` (aliases: `/vda`, `/villageadmin`)

All commands below use `/vda ...`.

---

## 2. Required Steps to Create an Arena

Follow these steps for **each** new arena you want to add.

1. **Create the arena entry**
   - `/vda create <id>`
   - Example: `/vda create default`

2. **Open the setup GUI**
   - `/vda setup <id>`
   - Example: `/vda setup default`
   - This opens a menu where you click items to set all locations and options.

3. **Set core locations (required)**
   In the setup GUI, set:
   - **Lobby location** – where players wait before the game starts.
   - **Start location** – where players spawn when the game begins.
   - **End location** – where players are sent when the game ends.
   - **Spectator location** – where dead players / spectators stay.

4. **Set VillageDefense‑specific locations (required)**
   In the “Specific” category (or equivalent tab in the GUI):
   - **Zombie spawn points**
     - Use the “Zombie Spawn” item:
       - Stand where you want a spawn.
       - Click the GUI item to add that location.
     - Add multiple spots around the map.
   - **Villager spawn points**
     - Use the “Villager Spawn” item the same way.
   - **Game doors**
     - Use the “Game Door” item.
     - Click on each door block you want to register.
     - Doors are auto‑regenerated each game; villagers hide in houses behind these doors.
   - **Game shop chest**
     - Use the “Game Shop” item.
     - Look at the (double) chest that contains your shop items and click to register it.
     - Prices for items are set later with `/vda setprice`.

5. **Set minimum and maximum players**
   - In the GUI, set:
     - `minimumplayers` – minimum players required to start.
     - `maximumplayers` – max players allowed in that arena.

6. **Mark the arena as finished**
   - Either:
     - Use the “done” / “finish” toggle in the setup GUI, **or**
     - Run: `/vda done <id>` (if exposed by your version of the setup system).
   - Internally this sets `isdone: true` in `arenas.yml`. Only arenas marked as done are joinable.

At this point the arena is playable; players can use `/vd` to join, or you can add signs (see optional steps).

---

## 3. Optional / Recommended Setup Commands

These are not strictly required for the game to function but are strongly recommended for a nice server experience.

### 3.1 Join signs

- Add a join sign for an arena (exact syntax may differ slightly by MiniGamesBox version, but typically):
  - Place a sign where you want players to join.
  - Run:
    - `/vda addsign <id>`
  - Requires `villagedefense.admin.sign.create`.

Break / manage signs with the same permission tree (`villagedefense.admin.sign.break`, etc.).

### 3.2 Shop prices

- After registering a shop chest via the GUI:
  - Hold the item in your hand.
  - Set its price:
    - `/vda setprice <orbs>`
    - Example: `/vda setprice 50`
  - Permission: `villagedefense.admin.setprice`.
  - The price is used when players interact with the in‑arena shop.

### 3.3 Testing & tweaking arena waves

Useful while testing / balancing:

- Set the current wave in the arena you’re standing in:
  - `/vda setwave <number>`
  - Example: `/vda setwave 5`
  - Permission: `villagedefense.admin.setwave`.

- Force‑start / stop games:
  - `/vda forcestart <id>` – start a game before min players (perm: `villagedefense.admin.forcestart`).
  - `/vda stopgame <id>` – force stop a running game (perm: `villagedefense.admin.stopgame`).

- Clear entities if they get stuck or you’re debugging:
  - `/vda clear <zombie|villager|golem|wolf>`
  - Example: `/vda clear zombie`
  - Permission: `villagedefense.admin.clear`.

### 3.4 Orbs & player testing

- Give orbs to yourself:
  - `/vda addorbs <amount>`
  - Example: `/vda addorbs 500`
- Give orbs to another player:
  - `/vda addorbs <player> <amount>`
  - Example: `/vda addorbs Alice 1000`
  - Permissions:
    - `villagedefense.admin.addorbs` (self)
    - `villagedefense.admin.addorbs.others` (others)

### 3.5 Respawning during tests

- Respawn yourself or another player in the current arena:
  - `/vda respawn` – respawn yourself.
  - `/vda respawn <player>` – respawn a specific player.
  - Permissions:
    - `villagedefense.admin.respawn` (self)
    - `villagedefense.admin.respawn.others` (others)

### 3.6 Reloading configuration

- Reload VillageDefense configuration and language files:
  - `/vda reload`
  - Permission: `villagedefense.admin.reload`.
  - Use this after editing configs; for arena layout changes, a full server restart is still safest.

---

## 4. Maintenance Commands & Tips

- **List arenas**  
  - `/vda list` – see all arena IDs and their status (name may vary slightly; check `/vda` help).

- **Delete an arena**  
  - `/vda delete <id>` – removes an arena definition; use with care.

- **Spy / admin chat (optional)**  
  - Features like `villagedefense.admin.spychat` and `villagedefense.command.override` are available for staff oversight and debugging.

---

## 5. Minimal Checklist for a Working Arena

For each arena, confirm:

- [ ] `/vda create <id>` run.
- [ ] `/vda setup <id>` used to open the GUI.
- [ ] Lobby, start, end, and spectator locations set.
- [ ] Zombie spawn points configured.
- [ ] Villager spawn points configured.
- [ ] Doors and shop chest set.
- [ ] Minimum / maximum players set.
- [ ] Arena marked as done (`/vda done <id>` or GUI toggle).
- [ ] (Recommended) At least one join sign created with `/vda addsign <id>`.

Once these are done, your arena is ready for real players. Use `/vd` or the join sign to test a full game. 

