# Administration

## Commands
- **Player-facing**: `/villagedefense` (aliases `/vd`, `/villaged`) for joining arenas and general gameplay actions.
- **Administrative**: `/villagedefenseadmin` (aliases `/vda`, `/villageadmin`) for setup, moderation, and debugging tasks. 【F:src/main/resources/plugin.yml†L8-L16】
- **Short command aliases** can be configured (e.g., `/start` triggers `vda forcestart`, `/leave` maps to `vd leave`) or disabled entirely through the `Commands.Shorter` section. 【F:src/main/resources/config.yml†L37-L63】
- **In-game command blocking** prevents non-plugin commands during matches, with exceptions defined in the whitelist. 【F:src/main/resources/config.yml†L66-L75】

## Permissions
The `villagedefense.admin.*` node grants a comprehensive set of privileges for arena creation, sign management, forcestarts, respawns, stat adjustments, and command overrides. Use granular children such as `villagedefense.admin.setwave`, `villagedefense.admin.clear`, or `villagedefense.admin.reload` to delegate specific abilities. 【F:src/main/resources/plugin.yml†L18-L45】

For a step‑by‑step list of required arena setup commands and a practical admin checklist, see [`ADMIN_SETUP.md`](../../ADMIN_SETUP.md).

## Operational Toggles
- **Bungee-Mode** can be enabled for arena-per-server setups and works with external hub sign plugins. 【F:src/main/resources/config.yml†L24-L29】
- **Inventory Manager** safely stores and restores player state when entering or leaving arenas on multi-arena servers. 【F:src/main/resources/config.yml†L31-L35】
- **Database**: Switch between flat-file stats and MySQL by toggling the database option before players start accumulating progress. 【F:src/main/resources/config.yml†L77-L82】
- **Update notifications** inform admins of new releases (including beta builds if desired) on plugin start or admin join. 【F:src/main/resources/config.yml†L245-L251】
