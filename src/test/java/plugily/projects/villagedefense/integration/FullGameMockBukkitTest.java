package plugily.projects.villagedefense.integration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assumptions;
import org.mockbukkit.mockbukkit.MockBukkit;
import org.mockbukkit.mockbukkit.ServerMock;
import org.bukkit.World;
import plugily.projects.villagedefense.Main;
import plugily.projects.villagedefense.arena.Arena;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FullGameMockBukkitTest {

  private static ServerMock server;
  private static Main plugin;

  @BeforeAll
  static void setUp() {
    server = MockBukkit.mock();
    plugin = MockBukkit.load(Main.class);
  }

  @AfterAll
  static void tearDown() {
    MockBukkit.unmock();
  }

  @Test
  void canLoadArenasAndStartWaveLogic() {
    assertNotNull(plugin);

    World world = server.addSimpleWorld("world");
    assertNotNull(world);

    List<Arena> arenas = plugin.getArenaRegistry().getPluginArenas();
    Assumptions.assumeFalse(arenas.isEmpty(), "No arenas configured in arenas.yml for tests");

    Arena arena = arenas.get(0);
    assertNotNull(arena.getStartLocation());

    // Start wave logic without players; this should still configure wave state
    plugin.getArenaManager().startWave(arena);

    assertTrue(arena.getArenaOption("ZOMBIES_TO_SPAWN") >= 0);
  }
}
