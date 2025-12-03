# VillageDefense Wiki

## Overview
VillageDefense is a Minecraft minigame plugin where players cooperate to protect villagers from waves of zombies while progressing through kit unlocks, power-ups, and arena events. The plugin is built on the MiniGamesBox Classic framework, targets the Paper/Spigot API, and packages with a shaded artifact for server deployment. 【F:src/main/java/plugily/projects/villagedefense/Main.java†L2-L139】【F:build.gradle.kts†L19-L84】

## Key Features
- **Arena lifecycle management** through registries for arenas, enemy spawners, setup categories, power-ups, and plugin events, all initialized during plugin enable. 【F:src/main/java/plugily/projects/villagedefense/Main.java†L107-L139】
- **Extensive kit roster** spanning free, level-locked, and premium kits that are instantiated at startup. 【F:src/main/java/plugily/projects/villagedefense/Main.java†L141-L157】
- **Configurable gameplay systems** including power-ups, kits, leaderboard creation, and optional entity upgrades. 【F:src/main/resources/config.yml†L122-L176】
- **Customizable commands and permissions** exposed via Bukkit command declarations and bundled admin permission tree. 【F:src/main/resources/plugin.yml†L8-L45】

## Wiki Map
- [Setup & Installation](Setup.md) — building the plugin, dependencies, and configuration files to prepare a server.
- [Gameplay & Mechanics](Gameplay.md) — core loop, wave settings, economy, and optional features like power-ups or entity upgrades.
- [Administration](Administration.md) — commands, permissions, and operational toggles for chat, parties, and arenas.
- [Architecture & Development](Architecture.md) — codebase layout, initialization flow, and guidance for extending the plugin.
