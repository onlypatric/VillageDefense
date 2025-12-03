# Gameplay & Mechanics

## Core Loop
VillageDefense pits players against waves of hostile creatures while they defend villagers; games can run indefinitely or end after a configured wave cap (default 200). 【F:src/main/java/plugily/projects/villagedefense/Main.java†L2-L139】【F:src/main/resources/config.yml†L185-L203】

## Timing & Flow Control
- Lobby and match pacing is governed by the `Time-Manager` section, with separate waiting, starting, in-game, cooldown, ending, and restarting timers. 【F:src/main/resources/config.yml†L161-L170】
- Players can respawn after waves and even join mid-game when enabled, keeping teams populated through long matches. 【F:src/main/resources/config.yml†L178-L183】
- Optional glowing highlights make remaining zombies easier to find starting at wave 6, with thresholds based on remaining creature counts. 【F:src/main/resources/config.yml†L236-L243】

## Player Progression & Economy
- Players start each match with orbs and retain a percentage on death, forming the in-match currency for purchases. 【F:src/main/resources/config.yml†L216-L226】
- Rewards can be toggled globally and customized via the rewards configuration. 【F:src/main/resources/config.yml†L84-L87】
- Power-ups, kits, and leaderboard tracking are individually toggleable to tailor complexity and competitiveness. 【F:src/main/resources/config.yml†L122-L132】
- Optional entity upgrades let players strengthen wolves and golems when enabled, with pricing controlled in `entity_upgrades.yml`; administrators can also block re-purchasing slain allies. 【F:src/main/resources/config.yml†L173-L203】

## Visibility & UX Enhancements
- A boss bar can cycle arena information at a configurable interval, and block states behind join signs reflect game state. 【F:src/main/resources/config.yml†L17-L22】【F:src/main/resources/config.yml†L104-L112】
- Firework celebrations and always-visible mob name tags improve feedback around key events and friendly units. 【F:src/main/resources/config.yml†L100-L101】【F:src/main/resources/config.yml†L229-L233】

## Multiplayer Support
- Built-in options integrate with external party plugins or the plugin's own party system, letting groups enter arenas together. 【F:src/main/resources/config.yml†L134-L140】
- Separate arena chat and formatted plugin chat can be enabled to keep communications organized during matches. 【F:src/main/resources/config.yml†L89-L99】
