package plugily.projects.villagedefense.creatures.v1_9_UP;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateTest {

  @Nested
  @DisplayName("Phase and wave matching")
  class PhaseWaveTests {

    @Test
    void matchesExactPhaseOrAnyWhenZero() {
      Rate exactPhase = new Rate(3, 0, 0, 0, 0, 0, 0, Rate.RateType.SPAWN);
      assertTrue(exactPhase.isPhase(3));
      assertFalse(exactPhase.isPhase(2));

      Rate anyPhase = new Rate(0, 0, 0, 0, 0, 0, 0, Rate.RateType.SPAWN);
      assertTrue(anyPhase.isPhase(5));
    }

    @Test
    void respectsWaveBounds() {
      Rate bounded = new Rate(0, 5, 10, 0, 0, 0, 0, Rate.RateType.CHECK);
      assertTrue(bounded.isWaveHigher(5));
      assertTrue(bounded.isWaveHigher(7));
      assertFalse(bounded.isWaveHigher(4));

      assertTrue(bounded.isWaveLower(8));
      assertTrue(bounded.isWaveLower(10));
      assertFalse(bounded.isWaveLower(11));
    }
  }

  @Nested
  @DisplayName("Spawn limits and rate calculations")
  class SpawnRateTests {

    @Test
    void evaluatesSpawnLowerThreshold() {
      Rate withLimit = new Rate(0, 0, 0, 3, 0, 0, 0, Rate.RateType.AMOUNT);
      assertTrue(withLimit.isSpawnLower(2));
      assertTrue(withLimit.isSpawnLower(3));
      assertFalse(withLimit.isSpawnLower(4));
    }

    @Test
    void defaultsRateAndDivisionWhenUnset() {
      Rate zeroed = new Rate(0, 0, 0, 0, 0, 0, 2, Rate.RateType.SPAWN);
      assertEquals(1, zeroed.getRate());
      assertEquals(1, zeroed.getDivision());
      assertEquals(2, zeroed.getReduce());
      assertEquals(Rate.RateType.SPAWN, zeroed.getRateType());
    }
  }
}
