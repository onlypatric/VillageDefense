# Architecture & Development

## Entry Point & Startup
`plugily.projects.villagedefense.Main` extends the MiniGamesBox `PluginMain`, wiring together arenas, enemy spawners, placeholders, power-ups, events, and optional upgrade menus during `onEnable`. Arena signs, argument registries, and metrics are also initialized when not under MockBukkit. 【F:src/main/java/plugily/projects/villagedefense/Main.java†L90-L139】

## Module Overview
- **Arena management**: `Arena`, `ArenaEvents`, `ArenaManager`, `ArenaRegistry`, and `ArenaUtils` coordinate arena state, registration, and utilities. 【F:src/main/java/plugily/projects/villagedefense/Main.java†L28-L33】【F:src/main/java/plugily/projects/villagedefense/Main.java†L107-L139】
- **Enemy spawning**: `EnemySpawnerRegistry` governs creature spawn behaviors and is constructed during initialization. 【F:src/main/java/plugily/projects/villagedefense/Main.java†L33-L137】
- **Boot services**: `MessageInitializer`, `PlaceholderInitializer`, and `AdditionalValueInitializer` load messages, placeholders, and additional config values before gameplay systems start. 【F:src/main/java/plugily/projects/villagedefense/Main.java†L93-L139】
- **Gameplay systems**: Power-ups, upgrade menus, door-breaking listeners, creature utilities, and plugin-wide events are registered to supply arena mechanics and optional upgrade paths. 【F:src/main/java/plugily/projects/villagedefense/Main.java†L124-L139】
- **Kits**: A broad roster of free, level-based, and premium kits is instantiated reflectively on startup to populate the kit selector. 【F:src/main/java/plugily/projects/villagedefense/Main.java†L141-L157】

## Build & Release Pipeline
- The Gradle build applies Shadow for shading, relocates packaged dependencies, and sets the `build` task to depend on `shadowJar`. 【F:build.gradle.kts†L55-L65】
- Publishing configuration targets Plugily Maven repositories for releases and snapshots, drawing credentials from environment variables. 【F:build.gradle.kts†L86-L109】
- Testing relies on JUnit Jupiter with MockBukkit for in-server simulations, while Javadoc jars are produced alongside the main artifact. 【F:build.gradle.kts†L43-L44】【F:build.gradle.kts†L50-L84】

## Contributing Tips
- Configuration-driven features (kits, power-ups, creatures, leaderboards, database) live in `src/main/resources` and are loaded via `addFileName` calls, so add new YAML templates alongside existing ones when introducing systems. 【F:src/main/java/plugily/projects/villagedefense/Main.java†L108-L139】【db73d3†L1-L2】
- When creating new kits or gameplay handlers, follow the reflective registration pattern used in `addKits` so classes self-register without manual enumeration elsewhere. 【F:src/main/java/plugily/projects/villagedefense/Main.java†L141-L157】
