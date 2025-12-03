# VillageDefense Wiki

## Overview
VillageDefense is a Minecraft minigame plugin where players cooperate to protect villagers from waves of zombies while progressing through kit unlocks, power-ups, and arena events. The plugin is built on the MiniGamesBox Classic framework, targets modern Paper/Spigot (1.21.4+), and ships as a shaded JAR for drop‑in server deployment.

## Key Features
- **Arena lifecycle management** through registries for arenas, enemy spawners, setup categories, power-ups, and plugin events, all initialized during plugin enable.
- **Extensive kit roster** spanning free, level-locked, and premium kits that are instantiated at startup.
- **Configurable gameplay systems** including power-ups, kits, leaderboards, configurable waves, and optional entity upgrades.
- **Customizable commands and permissions** via `/vd` and `/vda` with a rich admin permission tree.

---

## Quick Start for Server Admins

If you just want to get a playable arena running on a Paper server:

1. **Install the plugin**
   - Drop the built JAR into your server’s `plugins/` folder.
   - Start the server once to generate configuration files.
2. **Give yourself admin access**
   - Grant `villagedefense.admin.*` to your account or admin group.
3. **Create and configure an arena (in‑game)**
   - `/vda create <id>` – create a new arena.
   - `/vda setup <id>` – open the setup GUI for that arena.
   - In the GUI, set:
     - Lobby, start, end and spectator locations.
     - Zombie spawn points, villager spawn points.
     - Game doors and the game shop chest.
     - Minimum and maximum player counts.
   - Mark the arena as finished (`done`) so it becomes joinable.
4. **(Optional) Add a join sign**
   - Place a sign and use `/vda addsign <id>` so players can join via signs.
5. **Let players in**
   - Players use `/vd` or your join sign to enter the arena.

For a detailed, command‑by‑command admin guide see:
- **Admin checklist and commands**: [`ADMIN_SETUP.md`](../../ADMIN_SETUP.md)

---

## Quick Start for Developers

To work on VillageDefense or build a custom fork:

1. **Clone and open the project**
   - Clone the repository.
   - Open it as a Gradle project in your IDE (IntelliJ or VS Code).
2. **Java & Gradle**
   - Use JDK 21 for development (the build compiles with `release 17` bytecode).
   - Use the included Gradle wrapper (`./gradlew` / `gradlew`).
3. **Build**
   - Run `./gradlew clean build`.
   - Use the shaded JAR from `build/libs` on your test server.
4. **Run tests**
   - Run `./gradlew test` to execute:
     - Unit tests (e.g., enemy rate logic).
     - MockBukkit integration tests that load the plugin and exercise arena logic.
5. **Explore the architecture**
   - Start with:
     - `plugily.projects.villagedefense.Main` (plugin entry point).
     - `arena/` for arena state and events.
     - `creatures/` for enemy definitions and spawn logic.
     - `kits/` for player kits.

For a deeper architectural view and build notes see:
- **Architecture & development**: [`Architecture.md`](Architecture.md)
- **Setup & build details**: [`Setup.md`](Setup.md)

## Wiki Map
- [Setup & Installation](Setup.md) — building the plugin, dependencies, and configuration files to prepare a server.
- [Gameplay & Mechanics](Gameplay.md) — core loop, waves, economy, power-ups, and upgrades.
- [Administration](Administration.md) — commands, permissions, and operational toggles for chat, parties, and arenas.
- [Architecture & Development](Architecture.md) — codebase layout, initialization flow, and guidance for extending the plugin.
