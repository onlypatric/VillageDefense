## VillageDefense Setup Guide

This guide covers how to build, install and configure VillageDefense on a modern Paper server, plus optional integrations and local development setup.

---

## 1. Requirements

- **Minecraft server (required)**
  - Paper `1.21.4` (or compatible Paper fork).
  - At least **2–3 GB RAM** recommended if running other plugins.

- **Java (required)**
  - **Runtime / server**: Java **17+** (Paper 1.21.x supports 17+, recommended 21).
  - **Development**: JDK **21** (the Gradle toolchain is set to use Java 21 and compile with `release 17` bytecode).

- **Build tooling (for building from source)**
  - Git (optional if you just download the source).
  - No standalone Gradle needed; the repo includes the **Gradle Wrapper** (`./gradlew`).

- **Optional external plugins (soft-depends)**
  - [PlaceholderAPI](https://www.spigotmc.org/resources/6245/) – placeholders for scoreboards, holograms, etc.
  - Party plugins:
    - Parties
    - Spigot-Party-API-PAF
    - PartyAndFriends
  - Protocol / version plugins:
    - ViaVersion
    - ProtocolSupport

VillageDefense runs fine without any of the soft-dependencies; they just enable extra features.

---

## 2. Getting the Plugin JAR

### Option A – Download from Maven (recommended for server owners)

You can grab prebuilt releases from Plugily’s Maven:

- Latest release badge and link: see `.github/README.md` or visit  
  `https://maven.plugily.xyz/#/releases/plugily/projects/villagedefense`

Download the main JAR (not the sources or javadoc) and skip to “Install on your server”.

### Option B – Build from source (for custom forks / development)

1. Clone the repo:
   - `git clone https://github.com/Plugily-Projects/Village_Defense.git`
   - `cd Village_Defense`
2. Ensure you are using **JDK 21** on the CLI:
   - `java -version` should report a 21.x JDK.
3. Build with Gradle:
   - On macOS/Linux: `./gradlew clean build`
   - On Windows: `gradlew clean build`
4. Find the shaded plugin jar:
   - `build/libs/VillageDefense-<version>.jar` (without `-all` or `-sources`).
   - This JAR already **includes MiniGamesBox-Classic** via shading; you do **not** need to install MiniGamesBox as a separate plugin.

---

## 3. Install on Your Server

1. Stop your Paper server.
2. Copy the built / downloaded JAR into your server’s `plugins/` folder:
   - Example: `plugins/VillageDefense-4.7.0.jar`
3. Start the server.
4. On first run, VillageDefense will create its configuration files under `plugins/VillageDefense/` (in this fork the defaults come from `src/main/resources/*.yml`):
   - `config.yml`
   - `arenas.yml`
   - `kits.yml`
   - `creatures.yml`
   - `language.yml`
   - `rewards.yml`
   - `stats.yml`, `signs.yml`, `powerups.yml`, `spectator.yml`, etc.
5. Check the console:
   - You should see a line similar to `Full VillageDefense plugin enabled` with initialization time.

---

## 4. Minimal Game Setup (Required)

You need at least **one finished arena** to start playing.

### 4.1 Create / choose a world

- Use your main world or create a dedicated map (recommended).
- Make sure the world is loaded by your server (via `server.properties`, Multiverse, etc.).

### 4.2 Create an arena with commands (recommended)

VillageDefense uses a **GUI-based arena setup** provided by MiniGamesBox. The config file (`arenas.yml`) is generated from what you do in-game.

Basic admin flow:

1. Give yourself admin perms:
   - `villagedefense.admin.*` (or at minimum `villagedefense.admin.setup`).
2. Create an empty arena:
   - `/vda create <id>`
   - Example: `/vda create default`
3. Open the setup GUI for that arena:
   - `/vda setup <id>`
   - Example: `/vda setup default`
4. In the setup GUI, configure all required locations:
   - Lobby location
   - Start location
   - End / finish location
   - Spectator location
5. Configure **VillageDefense-specific** locations via the “Specific” category:
   - Zombie spawns (use the “Zombie Spawn” item in the GUI).
   - Villager spawns (use the “Villager Spawn” item).
   - Game doors (use the “Game Door” item; doors are auto-regenerated each game).
   - Game shop chest (use the “Game Shop” item; then later `/vda setprice` to assign prices).
6. Set min/max players in the GUI:
   - Make sure `minimumplayers` ≥ 1, and `maximumplayers` ≥ `minimumplayers`.
7. When everything is set, mark the arena as done:
   - `/vda done <id>` or toggle the corresponding option in the GUI (depending on your MiniGamesBox version).

After this flow, `arenas.yml` is updated automatically and the arena is ready to use.

### 4.3 Manual arenas.yml configuration (alternative)

You can also edit `arenas.yml` by hand instead of using the GUI.

- File: `plugins/VillageDefense/arenas.yml`
- Each arena is under `instances:`. A minimal entry looks like:

```yaml
instances:
  default:
    lobbylocation: world,0.5,64.0,0.5,0.0,0.0
    startlocation: world,10.5,64.0,10.5,0.0,0.0
    endlocation: world,0.5,64.0,0.5,0.0,0.0
    spectatorlocation: world,0.5,70.0,0.5,0.0,0.0
    minimumplayers: 2
    maximumplayers: 12
    mapname: DemoMap
    world: world
    signs: [ ]
    isdone: true
    shop: world,5.5,64.0,5.5,0.0,0.0
```

- Replace `world` and coordinates with locations from your server:
  - Stand at a location and use `/coord` or F3 to copy coordinates.
  - Keep the format: `worldName,x,y,z,yaw,pitch`.
- **Set `isdone: true`** when the arena is ready; unfinished arenas (`isdone: false`) are ignored.

### 4.4 Protect the map (strongly recommended)

- Use a region plugin (WorldGuard, etc.) to prevent building / breaking outside allowed areas.
- Ensure villagers and critical blocks cannot be destroyed by players if that’s not part of your design.

### 4.5 Basic commands and permissions

- Main commands:
  - `/vd` – player commands (join, leave, stats, etc.).
  - `/vda` – admin commands (setup, force-start, etc.).
- Give your admins:
  - `villagedefense.admin.*` – full administration access.
- Regular players generally need:
  - `villagedefense.player` (and related sub-perms; check `plugin.yml` for the full tree).

---

## 5. Important Configuration Files

All of these live in the plugin’s data folder on your server (mirrored from `src/main/resources` in the source tree).

- `config.yml` (required)
  - Core options: lobby behaviour, orbs, stats storage, database connection, bungeecord, etc.
  - **Orbs section** controls how player currency behaves on death:
    - `Orbs.Death.Type`: `KEEP`, `AMOUNT`, `SET`, or `PERCENTAGE`.
    - `Orbs.Death.Value`: numeric value interpreted according to the type.

- `arenas.yml` (required)
  - Defines all arenas and their locations.
  - An arena must have valid locations and `isdone: true` to be playable.

- `kits.yml` (required)
  - Enables / disables kits and controls unlock conditions.
  - Works together with the internal kit classes (e.g. `KnightKit`, `LightTankKit`, `WorkerKit`, etc.).

- `creatures.yml` (required)
  - Controls **enemy types, attributes and spawn rates**.
  - This fork also supports a `weight` per creature:
    - Example:
      ```yaml
      Creatures:
        Content:
          BABY_ZOMBIE:
            weight: 1
      ```
    - Weight is used to count “how many normal zombies” this enemy is worth in the wave logic.

- `language.yml` / `locales/*` (optional but recommended)
  - All messages shown to players.
  - You can translate or reword everything; keep placeholders as-is.

- `rewards.yml` (optional)
  - Defines rewards for events (zombie kill, villager death, wave complete, etc.).
  - Integrated with the plugin’s reward system (e.g. commands, orbs, exp).

- `stats.yml`, `mysql.yml` (optional)
  - Choose between flatfile and MySQL storage and configure connection parameters if using MySQL.

---

## 6. Optional Integrations

### 6.1 PlaceholderAPI

- Install PlaceholderAPI.
- VillageDefense registers its placeholders via its internal placeholder manager.
- Use them in:
  - Scoreboards
  - Holograms
  - Other PlaceholderAPI-aware plugins

### 6.2 Party plugins

- If you run **Parties**, **PAF** or **PartyAndFriends**, party members can be kept together when joining arenas.
- Configuration is mostly automatic; consult those plugins’ docs if you need advanced behaviour.

### 6.3 ViaVersion / ProtocolSupport

- Let newer / older clients connect to your 1.21.4 server.
- VillageDefense itself targets Paper 1.21.4; ViaVersion/ProtocolSupport handle the protocol translation layer.

### 6.4 Metrics (bStats)

- Anonymous stats collection via bStats is enabled by default.
- You can disable it globally in `plugins/bStats/config.yml` or per plugin if needed.

---

## 7. Local Development & Testing (Optional)

### 7.1 IDE setup

- Recommended: IntelliJ IDEA or VS Code with the Java extension.
- Open the project as a **Gradle project**.
- Ensure the IDE uses:
  - JDK 21 for Gradle and the project SDK.
  - Gradle wrapper (`./gradlew`) instead of a local Gradle install.

Common VS Code tip: if you see `Unsupported class file major version 65` from Gradle, make sure:
- Your `JAVA_HOME` points to a full JDK (not a stripped runtime).
- VS Code’s Gradle / Java extensions are set to use that JDK.

### 7.2 Running tests

- Unit and integration tests:
  - `./gradlew test`
  - Uses:
    - JUnit 5 (`org.junit.jupiter:junit-jupiter`).
    - MockBukkit (`org.mockbukkit.mockbukkit:mockbukkit-v1.21`).
- Notable tests:
  - `RateTest` (`src/test/java/plugily/projects/villagedefense/creatures/v1_9_UP/RateTest.java`)
    - Verifies enemy spawn rate logic.
  - `FullGameMockBukkitTest` (`src/test/java/plugily/projects/villagedefense/integration/FullGameMockBukkitTest.java`)
    - Loads the plugin under MockBukkit and exercises basic arena wave start logic when a finished arena is configured.

### 7.3 Debugging on a real server

For deeper debugging than MockBukkit:

1. Run a local Paper 1.21.4 server.
2. Deploy your dev build to `plugins/`.
3. Start the server with remote debugging flags, e.g.:
   - `java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005 -jar paper-1.21.4.jar`
4. Attach your IDE’s debugger to `localhost:5005`.

---

## 8. Quick Checklist

**Required for a playable setup**
- [ ] Paper 1.21.4 server running Java 17+ (preferably 21).
- [ ] VillageDefense JAR in `plugins/`.
- [ ] At least one arena in `arenas.yml` with valid coordinates and `isdone: true`.
- [ ] Admin permissions (`villagedefense.admin.*`) assigned to at least one staff member.

**Recommended extras**
- [ ] PlaceholderAPI installed (if you use scoreboards / other placeholder consumers).
- [ ] A protection plugin to guard your village map.
- [ ] Basic translation tweaks in `language.yml`.

Once all the above are in place, start your server, run `/vd` to see player commands, `/vda` for admin tools, and you should be ready to defend your villagers. 🎮
