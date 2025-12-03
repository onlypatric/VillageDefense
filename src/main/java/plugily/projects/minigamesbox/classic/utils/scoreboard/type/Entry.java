package plugily.projects.minigamesbox.classic.utils.scoreboard.type;

/**
 * Minimal scoreboard entry used by Village Defense while the upstream
 * MiniGamesBox scoreboard utilities are being refactored. It simply wraps the
 * rendered line text that will later be pushed to a FastBoard.
 */
public class Entry {

  private final String text;

  public Entry(String text) {
    this.text = text;
  }

  public String getText() {
    return text;
  }
}
