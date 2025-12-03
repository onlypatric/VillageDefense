# Setup & Installation

## Prerequisites
- **Java toolchain**: The build uses Java toolchain 21 with classes compiled for release 17. 【F:build.gradle.kts†L50-L84】
- **Server API**: Compile targets the Paper/Spigot API (1.21.4 snapshot) and the MiniGamesBox Classic framework. 【F:build.gradle.kts†L38-L44】

## Building the Plugin
1. Clone the repository and ensure the Gradle wrapper is executable.
2. Run `./gradlew build` to produce a shaded JAR; the `build` task depends on `shadowJar`, which relocates bundled dependencies and clears the classifier for drop-in server use. 【F:build.gradle.kts†L55-L65】
3. The resource processing step expands placeholders in `plugin.yml` using project properties, ensuring the final JAR has the correct plugin metadata. 【F:build.gradle.kts†L67-L71】

## Deploying to a Server
1. Copy the built JAR from `build/libs` into your Paper/Spigot server's `plugins` directory.
2. Start the server; Bukkit will load the plugin using the `plugily.projects.villagedefense.Main` entry point and register the `/villagedefense` and `/villagedefenseadmin` command namespaces. 【F:src/main/resources/plugin.yml†L1-L16】

## Configuration Files
VillageDefense ships with multiple YAML configuration files for arenas, kits, power-ups, rewards, leaderboards, and database connectivity. Key files include `config.yml`, `kits.yml`, `powerups.yml`, `entity_upgrades.yml`, `arenas.yml`, and supporting localization assets under `locales/`. 【db73d3†L1-L2】

After deploying, start the server once to generate copies of these files in the plugin data folder, then tailor options such as locale, boss bar visibility, BungeeCord mode, inventory manager, and database usage inside `config.yml`. 【F:src/main/resources/config.yml†L9-L82】
