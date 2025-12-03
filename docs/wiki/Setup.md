# Setup & Installation

This page explains how to build VillageDefense from source and get it running on a Paper 1.21.4+ server. For a more narrative, non‑wiki guide, see the root [`SETUP.md`](../../SETUP.md).

## Prerequisites

- **Java toolchain**
  - JDK 21 installed for development.
  - Gradle compiler configured to emit Java 17‑compatible bytecode via `options.release = 17`.
- **Server API**
  - Paper 1.21.4 (or compatible fork).
  - MiniGamesBox Classic is shaded into the final JAR; no separate plugin install is required.

## Building the Plugin

1. Clone the repository and ensure the Gradle wrapper is executable:
   - `git clone <repo-url>`
   - `cd VillageDefense`
2. Build with Gradle:
   - `./gradlew clean build`
   - This runs tests and then builds a shaded JAR; the `build` task depends on `shadowJar`, which relocates bundled dependencies and clears the classifier for drop‑in server use.
3. Resource processing:
   - `processResources` expands placeholders in `plugin.yml` from project properties so the final JAR has the correct name and version.

## Deploying to a Server

1. Copy the built JAR from `build/libs` into your Paper server's `plugins` directory.
2. Start the server; Bukkit will load the plugin using the `plugily.projects.villagedefense.Main` entry point and register:
   - `/villagedefense` (player commands, aliases `/vd`, `/villaged`)
   - `/villagedefenseadmin` (admin commands, aliases `/vda`, `/villageadmin`)
3. Stop the server once the startup finishes so you can edit the generated configuration files.

## Configuration Files

After the first run, VillageDefense creates multiple YAML files in its data folder. The most important ones are:

- `config.yml` – global options (locale, boss bar, database, Bungee mode, inventory manager, chat formatting, etc.).
- `arenas.yml` – arena instances, including lobby/start/end/spectator locations and the `isdone` flag.
- `kits.yml` – kit unlocks and visibility.
- `creatures.yml` – custom enemy types, attributes, spawn rates and weights.
- `powerups.yml` – power‑up definitions and durations.
- `entity_upgrades.yml` – optional golem/wolf upgrade pricing.
- `language.yml` and `locales/` – messages and translations.

Edit these to match your server’s needs, then restart the server (or use `/vda reload` for some non‑structural changes).

For a full set of arena setup commands and required steps, see the admin‑oriented [`ADMIN_SETUP.md`](../../ADMIN_SETUP.md).
